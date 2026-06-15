package jp.go.aist.rtm.rtcbuilder.ros.param;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import jp.go.aist.rtm.rtcbuilder.ParamBase;
import jp.go.aist.rtm.rtcbuilder.generator.param.ActionsParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.GeneratorParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.PropertyParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.RecordedList;
import jp.go.aist.rtm.rtcbuilder.ros.IRtcBuilderConstantsROS;
import jp.go.aist.rtm.rtcbuilder.ros.ProfileHandlerROS;

public class ROSParam extends ParamBase implements Serializable {
	private static final long serialVersionUID = -1249129059979166068L;

	public static final String DEFAULT_DESCRIPTION = "TODO: package description";
	public static final String DEFAULT_VERSION = "0.0.1";
	public static final String DEFAULT_MAINTAINER = "TODO Maintainer";
	public static final String DEFAULT_LICENSE = "Apache-2.0";
	public static final String DEFAULT_CONTACT_ADDRESS = "todo@example.com";
	
	private GeneratorParam parent;

	private String schemaVersion;

	private String package_name;
	private String node_name;
	private String class_name;
	private String description;
	private String version;
	private String maintainer;	
	private String category;

	private String license;
	private String contact_address;
	
	private String doc_algorithm;
	private String doc_in_out;
	private String doc_creator;
	private String doc_reference;

	private RecordedList<ActionsParam> actions;
	private RecordedList<TimerParam> timers = new RecordedList<TimerParam>();
	///
	private RecordedList<TopicParam> topic_subscribes = new RecordedList<TopicParam>();
	private RecordedList<TopicParam> topic_publishes = new RecordedList<TopicParam>();
	///
	private RecordedList<ServiceParam> service_servers = new RecordedList<ServiceParam>();
	private RecordedList<ServiceParam> service_clients = new RecordedList<ServiceParam>();
	///
	private RecordedList<ActionParam> action_servers = new RecordedList<ActionParam>();
	private RecordedList<ActionParam> action_clients = new RecordedList<ActionParam>();
	///
	private RecordedList<ParameterParam> parameters = new RecordedList<ParameterParam>();

	private String outputProject = null;
	private RecordedList<PropertyParam> properties = new RecordedList<PropertyParam>();
	/////
	private TargetEnvParam target_env = new TargetEnvParam();

	private String rosxml;

	public ROSParam() {
		ProfileHandlerROS handler = new ProfileHandlerROS();
		rosxml = handler.createInitialROSXml();

		actions = new RecordedList<ActionsParam>();
		for (int intidx = IRtcBuilderConstantsROS.ACTIVITY_CONFIGURE; intidx < IRtcBuilderConstantsROS.ACTIVITY_DUMMY; intidx++) {
			actions.add(new ActionsParam());
		}
		this.target_env.setRosVersion("2");
		//
		setUpdated(false);
	}
	
	public ROSParam(GeneratorParam parent) {
		this.parent = parent;

		ProfileHandlerROS handler = new ProfileHandlerROS();
		rosxml = handler.createInitialROSXml();

		actions = new RecordedList<ActionsParam>();
		for (int intidx = IRtcBuilderConstantsROS.ACTIVITY_CONFIGURE; intidx < IRtcBuilderConstantsROS.ACTIVITY_DUMMY; intidx++) {
			actions.add(new ActionsParam());
		}
		this.target_env.setRosVersion("2");
		//
		setUpdated(false);
	}

	public void initialize() {
		this.description = ROSParam.DEFAULT_DESCRIPTION;
		this.version = ROSParam.DEFAULT_VERSION;
		this.maintainer = ROSParam.DEFAULT_MAINTAINER;
		
		this.license = ROSParam.DEFAULT_LICENSE;
		this.contact_address = ROSParam.DEFAULT_CONTACT_ADDRESS;
		//
		this.actions.get(IRtcBuilderConstantsROS.ACTIVITY_CONFIGURE).setImplemaented(true);
		this.actions.get(IRtcBuilderConstantsROS.ACTIVITY_ACTIVATE).setImplemaented(true);
		this.actions.get(IRtcBuilderConstantsROS.ACTIVITY_DEACTIVATE).setImplemaented(true);
	}
	
	public String getSchemaVersion() {
		return schemaVersion;
	}
	public void setSchemaVersion(String version) {
		checkUpdated(this.schemaVersion, version);
		this.schemaVersion = version;
	}
	
	public String getPackageName() {
		return package_name;
	}
	public void setPackageName(String package_name) {
		checkUpdated(this.package_name, package_name);
		this.package_name = package_name;
	}
	
	public String getNodeName() {
		return node_name;
	}
	public void setNodeName(String node_name) {
		checkUpdated(this.node_name, node_name);
		this.node_name = node_name;
	}
	
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		checkUpdated(this.class_name, class_name);
		this.class_name = class_name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		checkUpdated(this.description, description);
		this.description = description;
	}
	
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		checkUpdated(this.version, version);
		this.version = version;
	}
	
	public String getMaintainer() {
		return maintainer;
	}
	public void setMaintainer(String maintainer) {
		checkUpdated(this.maintainer, maintainer);
		this.maintainer = maintainer;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		checkUpdated(this.category, category);
		this.category = category;
	}
	
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		checkUpdated(this.license, license);
		this.license = license;
	}
	
	public String getContactAddress() {
		return contact_address;
	}
	public void setContactAddress(String contact_address) {
		checkUpdated(this.contact_address, contact_address);
		this.contact_address = contact_address;
	}
	
	public String getDocAlgorithm() {
		return doc_algorithm;
	}
	public void setDocAlgorithm(String doc_algorithm) {
		checkUpdated(this.doc_algorithm, doc_algorithm);
		this.doc_algorithm = doc_algorithm;
	}
	
	public String getDocInOut() {
		return doc_in_out;
	}
	public void setDocInOut(String doc_in_out) {
		checkUpdated(this.doc_in_out, doc_in_out);
		this.doc_in_out = doc_in_out;
	}
	
	public String getDocCreator() {
		return doc_creator;
	}
	public void setDocCreator(String doc_creator) {
		checkUpdated(this.doc_creator, doc_creator);
		this.doc_creator = doc_creator;
	}
	
	public String getDocReference() {
		return doc_reference;
	}
	public void setDocReference(String doc_reference) {
		checkUpdated(this.doc_reference, doc_reference);
		this.doc_reference = doc_reference;
	}
	
	public String getOutputProject() {
		return outputProject;
	}
	public void setOutputProject(String outputProject) {
		checkUpdated(this.outputProject, outputProject);
		this.outputProject = outputProject;
	}
	//Actions
	public void setAction(int actionId, boolean implemented, String overview, String precond, String postcond) {
		actions.get(actionId).setImplemaented(implemented);
		actions.get(actionId).setOverview(overview);
		actions.get(actionId).setPreCondition(precond);
		actions.get(actionId).setPostCondition(postcond);
	}
	public boolean isActionsExist(int actionsId) {
		if( actions == null )
			return false;
		if( actions.get(actionsId) == null )
			return false;
		if( actions.get(actionsId).getOverView() == null ||
				actions.get(actionsId).getPreCondition() == null ||
				actions.get(actionsId).getPostCondition() == null )
					return false;
		if( actions.get(actionsId).getOverView().equals("") &&
				actions.get(actionsId).getPreCondition().equals("") &&
				actions.get(actionsId).getPostCondition().equals("") )
					return false;
		return true;
	}
	public boolean IsNotImplemented(int actionId) {
		return !actions.get(actionId).getImplemented();
	}
	public String IsComment(int actionId) {
		if(actions.get(actionId).getImplemented()) {
			return "";
		} else {
			return "//";
		}
	}
	public boolean getActionImplemented(int actionId) {
		return actions.get(actionId).getImplemented();
	}
	public void setActionImplemented(int actionId, boolean implemented) {
		actions.get(actionId).setImplemaented(implemented);
	}
	public void setActionImplemented(int actionId, String implemented) {
		actions.get(actionId).setImplemaented(implemented);
	}

	public String getDocActionOverView(int actionId) {
		return actions.get(actionId).getOverView();
	}
	public void setDocActionOverView(int actionId, String overview) {
		actions.get(actionId).setOverview(overview);
	}

	public String getDocActionPreCondition(int actionId) {
		return actions.get(actionId).getPreCondition();
	}
	public void setDocActionPreCondition(int actionId, String precond) {
		actions.get(actionId).setPreCondition(precond);
	}

	public String getDocActionPostCondition(int actionId) {
		return actions.get(actionId).getPostCondition();
	}
	public void setDocActionPostCondition(int actionId, String postcond) {
		actions.get(actionId).setPostCondition(postcond);
	}

	public List<TimerParam> getTimers() {
		return timers;
	}
	/////
	public List<TopicParam> getTopicSubscribes() {
		return topic_subscribes;
	}
	
	public List<TopicParam> getTopicPublishes() {
		return topic_publishes;
	}
	/////
	public List<ServiceParam> getServiceServers() {
		return service_servers;
	}

	public List<ServiceParam> getServiceClients() {
		return service_clients;
	}
	/////
	public List<ActionParam> getActionServers() {
		return action_servers;
	}
	public List<ActionParam> getActionClients() {
		return action_clients;
	}
	/////
	public List<ParameterParam> getParameters() {
		return parameters;
	}
	/////
	public String getROSXml() {
		return rosxml;
	}
	public void setROSXml(String rosxml) {
		checkUpdated(this.rosxml, rosxml);
		this.rosxml = rosxml;
	}
	/////
	public List<String> getLangList() {
		return langList;
	}
	public void setLanguage(String lang) {
		if (lang != null) {
			getLangList().clear();
			getLangList().addAll(Arrays.asList(lang.split(",")));
		}
	}
	public boolean isLanguageExist(String language) {
		boolean result = false;
		for (String str : getLangList()) {
			if (language.equalsIgnoreCase(str)) {
				result = true;
				break;
			}
		}
		return result;
	}

	public TargetEnvParam getTargetEnv() {
		return target_env;
	}
	public void setTargetEnv(TargetEnvParam param) {
		this.target_env = param;
	}
	/////
	public List<PropertyParam> getProperties() {
		return properties;
	}

	public PropertyParam getProperty(String target) {
		PropertyParam result = null;
		for(PropertyParam param : properties) {
			if( param.getName().equals(target)) {
				result = param;
				break;
			}
		}
		return result;
	}
	public void setProperty(String target, String value) {
		PropertyParam prop = null;
		for(PropertyParam param : properties) {
			if( param.getName().equals(target)) {
				prop = param;
				break;
			}
		}
		if(prop==null) {
			prop = new PropertyParam();
			prop.setName(target);
			getProperties().add(prop);
		}
		prop.setValue(value);
	}
	
	@Override
	public boolean isUpdated() {
		if (super.isUpdated()) {
			return true;
		}
		if (this.actions.isUpdated()) {
			return true;
		}
		if (this.topic_subscribes.isUpdated() || this.topic_publishes.isUpdated()) {
			return true;
		}
		if (this.service_servers.isUpdated() || this.service_clients.isUpdated()) {
			return true;
		}
		if (this.action_servers.isUpdated() || this.action_clients.isUpdated()) {
			return true;
		}
		if (this.parameters.isUpdated()) {
			return true;
		}
		if (this.langList.isUpdated()) {
			return true;
		}
		if (this.target_env.isUpdated()) {
			return true;
		}
//		if (this.containerSettings.isUpdated()) {
//			return true;
//		}
		return false;
	}
	@Override
	public void resetUpdated() {
		super.resetUpdated();
		//
		this.actions.resetUpdated();
		//
		this.topic_subscribes.resetUpdated();
		this.topic_publishes.resetUpdated();
		//
		this.service_servers.resetUpdated();
		this.service_clients.resetUpdated();
		//
		this.action_servers.resetUpdated();
		this.action_clients.resetUpdated();
		//
		this.parameters.resetUpdated();
		//
		this.langList.resetUpdated();
		//
		this.target_env.resetUpdated();
		
//		this.containerSettings.resetUpdated();
	}
}
