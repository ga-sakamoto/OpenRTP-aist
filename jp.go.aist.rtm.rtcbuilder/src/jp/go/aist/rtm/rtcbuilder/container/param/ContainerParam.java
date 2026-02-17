package jp.go.aist.rtm.rtcbuilder.container.param;

import java.util.List;

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
