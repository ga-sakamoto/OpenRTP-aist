package jp.go.aist.rtm.rtcbuilder.ros.param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jp.go.aist.rtm.rtcbuilder.ParamBase;
import jp.go.aist.rtm.rtcbuilder.generator.param.ActionsParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.GeneratorParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.PropertyParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.RecordedList;
import jp.go.aist.rtm.rtcbuilder.nl.Messages;
import jp.go.aist.rtm.rtcbuilder.ros.IRtcBuilderConstantsROS;
import jp.go.aist.rtm.rtcbuilder.ros.ProfileHandlerROS;
import jp.go.aist.rtm.rtcbuilder.util.StringUtil;

public class ROSParam extends ParamBase implements Serializable {
	private static final long serialVersionUID = -1249129059979166068L;

	public static final String DEFAULT_DESCRIPTION = "TODO: package description";
	public static final String DEFAULT_VERSION = "0.0.1";
	public static final String DEFAULT_MAINTAINER = "TODO Maintainer";
	public static final String DEFAULT_LICENSE = "Apache-2.0";
	public static final String DEFAULT_CONTACT_ADDRESS = "todo@example.com";
	
	private GeneratorParam parent;

	private String schemaVersion;

	private String packageName;
	private String nodeName;
	private String className;
	private String description;
	private String version;
	private String maintainer;	
	private String category;

	private String license;
	private String contactAddress;
	
	private String docAlgorithm;
	private String docInOut;
	private String docCreator;
	private String docReference;

	private RecordedList<ActionsParam> actions;
	private RecordedList<TimerParam> timers = new RecordedList<TimerParam>();
	///
	private RecordedList<TopicParam> topicSubscribes = new RecordedList<TopicParam>();
	private RecordedList<TopicParam> topicPublishes = new RecordedList<TopicParam>();
	///
	private RecordedList<ServiceParam> serviceServers = new RecordedList<ServiceParam>();
	private RecordedList<ServiceParam> serviceClients = new RecordedList<ServiceParam>();
	///
	private RecordedList<ActionParam> actionServers = new RecordedList<ActionParam>();
	private RecordedList<ActionParam> actionClients = new RecordedList<ActionParam>();
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
		this.contactAddress = ROSParam.DEFAULT_CONTACT_ADDRESS;
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
		return packageName;
	}
	public void setPackageName(String package_name) {
		checkUpdated(this.packageName, package_name);
		this.packageName = package_name;
	}
	
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String node_name) {
		checkUpdated(this.nodeName, node_name);
		this.nodeName = node_name;
	}
	
	public String getClass_name() {
		return className;
	}
	public void setClass_name(String class_name) {
		checkUpdated(this.className, class_name);
		this.className = class_name;
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
		return contactAddress;
	}
	public void setContactAddress(String contact_address) {
		checkUpdated(this.contactAddress, contact_address);
		this.contactAddress = contact_address;
	}
	
	public String getDocAlgorithm() {
		return docAlgorithm;
	}
	public void setDocAlgorithm(String doc_algorithm) {
		checkUpdated(this.docAlgorithm, doc_algorithm);
		this.docAlgorithm = doc_algorithm;
	}
	
	public String getDocInOut() {
		return docInOut;
	}
	public void setDocInOut(String doc_in_out) {
		checkUpdated(this.docInOut, doc_in_out);
		this.docInOut = doc_in_out;
	}
	
	public String getDocCreator() {
		return docCreator;
	}
	public void setDocCreator(String doc_creator) {
		checkUpdated(this.docCreator, doc_creator);
		this.docCreator = doc_creator;
	}
	
	public String getDocReference() {
		return docReference;
	}
	public void setDocReference(String doc_reference) {
		checkUpdated(this.docReference, doc_reference);
		this.docReference = doc_reference;
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
		return topicSubscribes;
	}
	
	public List<TopicParam> getTopicPublishes() {
		return topicPublishes;
	}
	/////
	public List<ServiceParam> getServiceServers() {
		return serviceServers;
	}

	public List<ServiceParam> getServiceClients() {
		return serviceClients;
	}
	/////
	public List<ActionParam> getActionServers() {
		return actionServers;
	}
	public List<ActionParam> getActionClients() {
		return actionClients;
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
		if (this.topicSubscribes.isUpdated() || this.topicPublishes.isUpdated()) {
			return true;
		}
		if (this.serviceServers.isUpdated() || this.serviceClients.isUpdated()) {
			return true;
		}
		if (this.actionServers.isUpdated() || this.actionClients.isUpdated()) {
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
		this.topicSubscribes.resetUpdated();
		this.topicPublishes.resetUpdated();
		//
		this.serviceServers.resetUpdated();
		this.serviceClients.resetUpdated();
		//
		this.actionServers.resetUpdated();
		this.actionClients.resetUpdated();
		//
		this.parameters.resetUpdated();
		//
		this.langList.resetUpdated();
		//
		this.target_env.resetUpdated();
		
//		this.containerSettings.resetUpdated();
	}
	//////////
	public String validateBasicInfo() {
		if ( this.packageName == null || this.packageName.length() == 0) {
			return Messages.getString("IMC.VALIDATE_BASIC_PACKAGE_NAME1");
		}
		if( !StringUtil.checkDigitSmallAlphabetUS(this.packageName) ) {
			return Messages.getString("IMC.VALIDATE_BASIC_PACKAGE_NAME2");
		}
		if( !StringUtil.checkSmallAlphabetFirst(this.packageName) ) {
			return Messages.getString("IMC.VALIDATE_BASIC_PACKAGE_NAME3");
		}
		
		if ( this.nodeName == null || this.nodeName.length() == 0) {
			return Messages.getString("IMC.VALIDATE_BASIC_NODE_NAME1");
		}
		if( !StringUtil.checkDigitSmallAlphabetUS(this.nodeName) ) {
			return Messages.getString("IMC.VALIDATE_BASIC_NODE_NAME2");
		}
		if( !StringUtil.checkSmallAlphabetFirst(this.nodeName) ) {
			return Messages.getString("IMC.VALIDATE_BASIC_NODE_NAME3");
		}

		if ( this.version == null || this.version.length() == 0) {
			return Messages.getString("IMC.VALIDATE_BASIC_VERSION1");
		}

		if ( this.maintainer == null || this.maintainer.length() == 0) {
			return Messages.getString("IMC.VALIDATE_BASIC_MAINTAINER1");
		}

		if ( this.category == null || this.category.length() == 0) {
			return Messages.getString("IMC.VALIDATE_BASIC_CATEGORY1");
		}

		if ( this.license == null || this.license.length() == 0) {
			return Messages.getString("IMC.VALIDATE_BASIC_LICENSE1");
		}

		if ( this.contactAddress == null || this.contactAddress.length() == 0) {
			return Messages.getString("IMC.VALIDATE_BASIC_CONTACT1");
		}
		
		if(this.langList == null || this.langList.size() == 0) {
			return Messages.getString("IMC.VALIDATE_BASIC_LANGUAGE");
		}

		return null;
	}
	
	public String validateLifecycleInfo() {
		Set<String> checkSet = new HashSet<String>();
		Set<String> checkCBSet = new HashSet<String>();
		for(TimerParam each : this.timers) {
			String result = each.validateInfo();
			if(result != null) return result;
			
			if(checkSet.contains(each.getName())) {
				return Messages.getString("IMC.VALIDATE_LICYCLE_TIMER_NAME_DUPL");
			}
			checkSet.add(each.getName());

			if(checkCBSet.contains(each.getCallBack())) {
				return Messages.getString("IMC.VALIDATE_LICYCLE_CALLBACK_DUPL");
			}
			checkCBSet.add(each.getCallBack());
		}

		return null;
	}
	
	public String validateTopicInfo() {
		Set<String> checkSet = new HashSet<String>();
		Set<String> checkVarSet = new HashSet<String>();
		
		for(TopicParam each : this.topicSubscribes) {
			String result = each.validateInfo();
			if(result != null) return result;
			
			if( checkSet.contains(each.getName()) ) {
				return Messages.getString("IMC.VALIDATE_TOPIC_DUPLICATE");
			}
			checkSet.add(each.getName());

			if( checkSet.contains(each.getVarCallbackName()) ) {
				return Messages.getString("IMC.VALIDATE_TOPIC_DUPLICATE");
			}
			checkVarSet.add(each.getVarCallbackName());
		}
		for(TopicParam each : this.topicPublishes) {
			String result = each.validateInfo();
			if(result != null) return result;
			
			if( checkSet.contains(each.getName()) ) {
				return Messages.getString("IMC.VALIDATE_TOPIC_DUPLICATE");
			}
			checkSet.add(each.getName());

			if( checkSet.contains(each.getVarCallbackName()) ) {
				return Messages.getString("IMC.VALIDATE_TOPIC_DUPLICATE");
			}
			checkVarSet.add(each.getVarCallbackName());
		}

		return null;
	}
	
	public String validateServiceInfo() {
		Set<String> checkSet = new HashSet<String>();
		Set<String> checkVarSet = new HashSet<String>();
		
		for(ServiceParam each : this.serviceServers) {
			String result = each.validateInfo();
			if(result != null) return result;
			
			if( checkSet.contains(each.getName()) ) {
				return Messages.getString("IMC.VALIDATE_SERVICE_DUPLICATE");
			}
			checkSet.add(each.getName());

			if( checkSet.contains(each.getVarCallbackName()) ) {
				return Messages.getString("IMC.VALIDATE_SERVICE_CALLBACK_DUPLICATE");
			}
			checkVarSet.add(each.getVarCallbackName());
		}
		for(ServiceParam each : this.serviceClients) {
			String result = each.validateInfo();
			if(result != null) return result;
			
			if( checkSet.contains(each.getName()) ) {
				return Messages.getString("IMC.VALIDATE_SERVICE_DUPLICATE");
			}
			checkSet.add(each.getName());

			if( checkSet.contains(each.getVarCallbackName()) ) {
				return Messages.getString("IMC.VALIDATE_SERVICE_CALLBACK_DUPLICATE");
			}
			checkVarSet.add(each.getVarCallbackName());
		}

		return null;
	}
	
	public String validateActionInfo() {
		Set<String> checkSet = new HashSet<String>();
		Set<String> checkVarSet = new HashSet<String>();
		
		for(ActionParam each : this.actionServers) {
			String result = each.validateInfo();
			if(result != null) return result;
			
			if( checkSet.contains(each.getName()) ) {
				return Messages.getString("IMC.VALIDATE_ACTION_DUPLICATE");
			}
			checkSet.add(each.getName());

			if( checkSet.contains(each.getCallbackName()) ) {
				return Messages.getString("IMC.VALIDATE_ACTION_CALLBACK_DUPLICATE");
			}
			checkVarSet.add(each.getCallbackName());
		}
		for(ActionParam each : this.actionClients) {
			String result = each.validateInfo();
			if(result != null) return result;
			
			if( checkSet.contains(each.getName()) ) {
				return Messages.getString("IMC.VALIDATE_ACTION_DUPLICATE");
			}
			checkSet.add(each.getName());

			if( checkSet.contains(each.getCallbackName()) ) {
				return Messages.getString("IMC.VALIDATE_ACTION_CALLBACK_DUPLICATE");
			}
			checkVarSet.add(each.getCallbackName());
		}

		return null;
	}
	
	public String validateParameterInfo() {
		Set<String> checkSet = new HashSet<String>();
		
		for(ParameterParam each : this.parameters) {
			String result = each.validateInfo();
			if(result != null) return result;
			
			if( checkSet.contains(each.getName()) ) {
				return Messages.getString("IMC.VALIDATE_PARAMETER_DUPLICATE");
			}
			checkSet.add(each.getName());
		}
		
		return null;
	}
	
	public boolean validateNames() {
		Set<String> checkSet = new HashSet<String>();
		
		for(TopicParam each : this.topicSubscribes) {
			if( checkSet.contains(each.getName()) ) {
				return true;
			}
			checkSet.add(each.getName());
		}
		for(TopicParam each : this.topicPublishes) {
			if( checkSet.contains(each.getName()) ) {
				return true;
			}
			checkSet.add(each.getName());
		}
		
		for(ServiceParam each : this.serviceServers) {
			if( checkSet.contains(each.getName()) ) {
				return true;
			}
			checkSet.add(each.getName());
		}
		for(ServiceParam each : this.serviceClients) {
			if( checkSet.contains(each.getName()) ) {
				return true;
			}
			checkSet.add(each.getName());
		}
		
		for(ActionParam each : this.actionServers) {
			if( checkSet.contains(each.getName()) ) {
				return true;
			}
			checkSet.add(each.getName());
		}
		for(ActionParam each : this.actionClients) {
			if( checkSet.contains(each.getName()) ) {
				return true;
			}
			checkSet.add(each.getName());
		}

		for(ParameterParam each : this.parameters) {
			if( checkSet.contains(each.getName()) ) {
				return true;
			}
			checkSet.add(each.getName());
		}

		return false;
	}
	/////
	public void convertInfo() {
		if(this.className == null || this.className.length() == 0) {
			this.className = StringUtil.convertCamelCase(this.nodeName);
		}
		
		for(TopicParam each : this.topicSubscribes) {
			each.convertInfo();
		}
		for(TopicParam each : this.topicPublishes) {
			each.convertInfo();
		}
		
		for(ServiceParam each : this.serviceServers) {
			each.convertInfo();
		}
		for(ServiceParam each : this.serviceClients) {
			each.convertInfo();
		}
		
		for(ActionParam each : this.actionServers) {
			each.convertInfo();
		}
		for(ActionParam each : this.actionClients) {
			each.convertInfo();
		}
	}
}
