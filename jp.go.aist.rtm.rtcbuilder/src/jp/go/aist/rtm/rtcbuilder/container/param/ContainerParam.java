package jp.go.aist.rtm.rtcbuilder.container.param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.go.aist.rtm.rtcbuilder.container.param.setting.ConditionalRule;
import jp.go.aist.rtm.rtcbuilder.container.param.setting.ContainerConfig;
import jp.go.aist.rtm.rtcbuilder.container.param.setting.InstallDefinition;
import jp.go.aist.rtm.rtcbuilder.container.param.setting.LibraryMapping;
import jp.go.aist.rtm.rtcbuilder.container.param.setting.MappingDb;
import jp.go.aist.rtm.rtcbuilder.generator.param.AbstractRecordedParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.RecordedList;

public class ContainerParam extends AbstractRecordedParam {
	private String middleware;
	private String mdlVersion;
	private String osVersion;
	private String workspace;
	private String language;
	private String configuration;
	private RecordedList<LibraryParam> libraries;
	private RecordedList<String> preSets;
	private RecordedList<RepositoryParam> repositories;
	
	private List<String> aptList = new ArrayList<String>();
	private List<String> pipList = new ArrayList<String>();
	
	public ContainerParam() {
		this.middleware = "";
		this.mdlVersion = "";
		this.osVersion = "";
		this.workspace = "";
		this.language = "";
		this.configuration = "";
		this.libraries = new RecordedList<LibraryParam>();
		this.preSets = new RecordedList<String>();
		this.repositories = new RecordedList<RepositoryParam>();
	}

	public String getMiddleware() {
		return middleware;
	}
	public void setMiddleware(String middleware) {
		checkUpdated(this.middleware, middleware);
		this.middleware = middleware;
	}

	public String getMdlVersion() {
		return mdlVersion;
	}
	public void setMdlVersion(String mdlVersion) {
		checkUpdated(this.mdlVersion, mdlVersion);
		this.mdlVersion = mdlVersion;
	}

	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		checkUpdated(this.osVersion, osVersion);
		this.osVersion = osVersion;
	}

	public String getWorkspace() {
		return workspace;
	}
	public void setWorkspace(String workspace) {
		checkUpdated(this.workspace, workspace);
		this.workspace = workspace;
	}

	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		checkUpdated(this.language, language);
		this.language = language;
	}

	public String getConfiguration() {
		return configuration;
	}
	public void setConfiguration(String configuration) {
		checkUpdated(this.configuration, configuration);
		this.configuration = configuration;
	}

	public List<LibraryParam> getLibraries() {
		return libraries;
	}

	public List<String> getPreSets() {
		return preSets;
	}

	public List<RepositoryParam> getRepositories() {
		return repositories;
	}
	
	public List<String> getAptList() {
		return aptList;
	}
	public List<String> getPipList() {
		return pipList;
	}
	
	public void prepareLibraries(ContainerConfig containerConfig) {
		List<String> libList = new ArrayList<String>();
		List<String> apts = new ArrayList<String>();
		List<String> pips = new ArrayList<String>();

		MappingDb mdb = containerConfig.mappingDb;
		libList.addAll(mdb.defaultLibs.common);

		String middleware = this.middleware.replace(" ", "").toLowerCase();
		libList.addAll(mdb.defaultLibs.byMiddleware.get(middleware));
		
		if(mdb.defaultLibs.byLanguage.keySet().contains(middleware)) {
			Map<String, List<String>> byLang = mdb.defaultLibs.byLanguage.get(middleware);
			if(byLang!= null) {
				if(byLang.keySet().contains(this.language.toLowerCase())) {
					libList.addAll(byLang.get(this.language.toLowerCase()));
				}
			}
		}
		
		for(LibraryParam libParam : this.libraries) {
			String libName = libParam.getName();
			if(libList.contains(libName) == false) {
				libList.add(libName);	
			}
			for(ConditionalRule each : mdb.defaultLibs.conditional) {
				if(each.triggers.contains(libName)) {
					for(String lib : each.libs) {
						if(libList.contains(lib) == false) {
							libList.add(lib);	
						}
					}
				}
			}
		}
		/////
		Map<String, LibraryMapping> libDb = mdb.libraries;
		for(String lib : libList) {
			if(libDb.keySet().contains(lib)) {
				LibraryMapping mapping = libDb.get(lib);
				Map<String, InstallDefinition> detailMap = mapping.getPlatforms();
				InstallDefinition def = getDefinition(detailMap);
				if(def != null) {
					Map<String, Object> instInfo = def.getInstallInfo();
					if(instInfo.size() == 1) {
						String key = def.getInstallInfo().keySet().iterator().next();
						if(key.equals("pip")) {
							pips.add(lib);
						} else {
							apts.add(lib);
						}
					} else {
						String infoKey = "default";
						if(instInfo.keySet().contains(this.mdlVersion)) {
							infoKey = this.mdlVersion;
						};
						Object target = instInfo.get(infoKey);
						if (target instanceof HashMap) {
						    HashMap<?, ?> map = (HashMap<?, ?>) target;
						    if (!map.isEmpty()) {
						        Object key = map.keySet().iterator().next();
								if(key.equals("pip")) {
									pips.add(lib);
								} else {
									apts.add(lib);
								}
						    }
						}
					}
				}
				
			} else {
				apts.add(lib);
			}
		}
		//
		for(String each : apts) {
			String convName = getContainerLibName(containerConfig, each, "apt");
			if(convName.contains(" ")) {
				String[] convNames = convName.split(" ");
				for(String eachLib : convNames) {
					if(this.aptList.contains(eachLib) == false) {
						this.aptList.add(eachLib);	
					}
				}
			} else {
				if(this.aptList.contains(convName)==false) {
					this.aptList.add(convName);
				}
			}
		}
		for(String each : pips) {
			String convName = getContainerLibName(containerConfig, each, "pip");
			if(convName.contains(" ")) {
				String[] convNames = convName.split(" ");
				for(String eachLib : convNames) {
					if(this.pipList.contains(eachLib) == false) {
						this.pipList.add(eachLib);	
					}
				}
			} else {
				if(this.pipList.contains(convName)==false) {
					this.pipList.add(convName);
				}
			}
		}
		if(0 < this.aptList.size()) {
			this.aptList.sort(null);
		}
		if(0 < this.pipList.size()) {
			this.pipList.sort(null);
		}
	}
	
	public String getContainerLibName(ContainerConfig containerConfig, String source, String strKey) {
		MappingDb mdb = containerConfig.mappingDb;
		Map<String, LibraryMapping> libDb = mdb.libraries;
		
		if(libDb.keySet().contains(source)) {
			LibraryMapping mapping = libDb.get(source);
			Map<String, InstallDefinition> detailMap = mapping.getPlatforms();
			
			InstallDefinition def = getDefinition(detailMap);
			if(def != null) {
				Map<String, Object> instInfo = def.getInstallInfo();
				if(instInfo.size() == 1) {
					String targtValue = (String)instInfo.get(strKey);
					if(targtValue != null) {
						if(targtValue.contains("${ROS_DISTRO}")) {
							String middleware = this.mdlVersion.toLowerCase();
							targtValue = targtValue.replace("${ROS_DISTRO}", middleware);
						}
						return targtValue;
					}
				} else {
					String infoKey = "default";
					if(instInfo.keySet().contains(this.mdlVersion.toLowerCase())) {
						infoKey = this.mdlVersion.toLowerCase();
					};
					Object target = instInfo.get(infoKey);
					if (target instanceof HashMap) {
					    HashMap<?, ?> map = (HashMap<?, ?>) target;
					    if (!map.isEmpty()) {
							String targtValue = (String)map.get(strKey);
							if(targtValue.contains("${ROS_DISTRO}")) {
								String middleware = this.mdlVersion.toLowerCase();
								targtValue = targtValue.replace("${ROS_DISTRO}", middleware);
							}
							return targtValue;
					    }
					}
				}
			}
			return source;
		} else {
			return source;
		}
	}

	
	private InstallDefinition getDefinition(Map<String, InstallDefinition> detailMap) {
		InstallDefinition def = null;
		String middleware = this.middleware.replace(" ", "").toLowerCase();
		if(detailMap.keySet().contains(middleware)) {
			def = detailMap.get(middleware);
			return def;
		}

		String lang = this.language.toLowerCase();
		if(detailMap.keySet().contains(lang)) {
			def = detailMap.get(lang);
			return def;
		}

		String osInfo = this.osVersion;
		String[] elems = osInfo.split(" ");
		if(0<elems.length) {
			String osName = elems[0].toLowerCase();
			if(detailMap.keySet().contains(osName)) {
				def = detailMap.get(osName);
				return def;
			} 
		}
		if(detailMap.keySet().contains("default")) {
			def = detailMap.get("default");
			return def;
		}
		return null;
	}

	@Override
	public boolean isUpdated() {
		if (super.isUpdated()) {
			return true;
		}
		if (libraries.isUpdated()) {
			return true;
		}
		if (preSets.isUpdated()) {
			return true;
		}
		if (repositories.isUpdated()) {
			return true;
		}
		return false;
	}

	@Override
	public void resetUpdated() {
		super.resetUpdated();
		libraries.resetUpdated();
		preSets.resetUpdated();
		repositories.resetUpdated();
	}
}
