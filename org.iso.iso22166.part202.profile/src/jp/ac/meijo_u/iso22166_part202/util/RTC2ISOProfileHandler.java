package jp.ac.meijo_u.iso22166_part202.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.iso.iso22166.part202.profile.ArgSpec;
import org.iso.iso22166.part202.profile.Communication;
import org.iso.iso22166.part202.profile.CompilerType;
import org.iso.iso22166.part202.profile.CyberSecurity;
import org.iso.iso22166.part202.profile.DataBus;
import org.iso.iso22166.part202.profile.ExeForm;
import org.iso.iso22166.part202.profile.ExeStatus;
import org.iso.iso22166.part202.profile.ExecutableForm;
import org.iso.iso22166.part202.profile.ExecutionType;
import org.iso.iso22166.part202.profile.IDnType;
import org.iso.iso22166.part202.profile.IOVariables;
import org.iso.iso22166.part202.profile.InOutType;
import org.iso.iso22166.part202.profile.InfraType;
import org.iso.iso22166.part202.profile.Infrastructure;
import org.iso.iso22166.part202.profile.InstanceType;
import org.iso.iso22166.part202.profile.Libraries;
import org.iso.iso22166.part202.profile.MOType;
import org.iso.iso22166.part202.profile.ModelCase;
import org.iso.iso22166.part202.profile.Modelling;
import org.iso.iso22166.part202.profile.ModuleID;
import org.iso.iso22166.part202.profile.NVList;
import org.iso.iso22166.part202.profile.NameValue;
import org.iso.iso22166.part202.profile.NoBit;
import org.iso.iso22166.part202.profile.OStype;
import org.iso.iso22166.part202.profile.ObjectFactory;
import org.iso.iso22166.part202.profile.OpTypes;
import org.iso.iso22166.part202.profile.PLSILType;
import org.iso.iso22166.part202.profile.PhysicalVirtual_0020;
import org.iso.iso22166.part202.profile.Properties;
import org.iso.iso22166.part202.profile.RangeString;
import org.iso.iso22166.part202.profile.ReqProvType;
import org.iso.iso22166.part202.profile.SIM;
import org.iso.iso22166.part202.profile.SafeSecure;
import org.iso.iso22166.part202.profile.SafetyFunction;
import org.iso.iso22166.part202.profile.SafetyType;
import org.iso.iso22166.part202.profile.SafeytLevelPL;
import org.iso.iso22166.part202.profile.SecurityType;
import org.iso.iso22166.part202.profile.ServiceMethod;
import org.iso.iso22166.part202.profile.ServiceProfile;
import org.iso.iso22166.part202.profile.Services;
import org.iso.iso22166.part202.profile.Status;
import org.iso.iso22166.part202.profile.Variable;
import org.openrtp.namespaces.rtc.version03.ActionStatus;
import org.openrtp.namespaces.rtc.version03.ActionStatusDoc;
import org.openrtp.namespaces.rtc.version03.Actions;
import org.openrtp.namespaces.rtc.version03.BasicInfoExt;
import org.openrtp.namespaces.rtc.version03.Configuration;
import org.openrtp.namespaces.rtc.version03.ConfigurationExt;
import org.openrtp.namespaces.rtc.version03.ConfigurationSet;
import org.openrtp.namespaces.rtc.version03.Dataport;
import org.openrtp.namespaces.rtc.version03.DataportExt;
import org.openrtp.namespaces.rtc.version03.DocAction;
import org.openrtp.namespaces.rtc.version03.DocBasic;
import org.openrtp.namespaces.rtc.version03.DocConfiguration;
import org.openrtp.namespaces.rtc.version03.DocDataport;
import org.openrtp.namespaces.rtc.version03.DocServiceinterface;
import org.openrtp.namespaces.rtc.version03.DocServiceport;
import org.openrtp.namespaces.rtc.version03.Language;
import org.openrtp.namespaces.rtc.version03.LanguageExt;
import org.openrtp.namespaces.rtc.version03.Library;
import org.openrtp.namespaces.rtc.version03.Property;
import org.openrtp.namespaces.rtc.version03.RtcProfile;
import org.openrtp.namespaces.rtc.version03.Serviceinterface;
import org.openrtp.namespaces.rtc.version03.ServiceinterfaceExt;
import org.openrtp.namespaces.rtc.version03.Serviceport;
import org.openrtp.namespaces.rtc.version03.ServiceportExt;
import org.openrtp.namespaces.rtc.version03.TargetEnvironment;
import org.openrtp.namespaces.rtc.version03.TransmissionMethod;

import jp.go.aist.rtm.toolscommon.profiles.util.XmlHandler;

public class RTC2ISOProfileHandler {
	public SIM convertRtc2Iso(RtcProfile source) {
		ObjectFactory factory = new ObjectFactory();

		SIM result = factory.createSIM();
		IDnType idnType = factory.createIDnType();
		result.setIdnType(idnType);
		ModuleID moduleId = factory.createModuleID();
		idnType.setModuleID(moduleId);
		
		IOVariables iovar = factory.createIOVariables();
		result.setIoVariables(iovar);
		
		Services services = factory.createServices();
		result.setServices(services);
		
		Properties properties = factory.createProperties();
		result.setProperties(properties);	
		
		Status status = factory.createStatus();
		result.setStatus(status);
		
		NVList simNv = factory.createNVList();
		result.setAdditionalInfo(simNv);
		
		createISONameValue(factory, "profileVersion", source.getVersion(), simNv);
		createNameValue(factory, "SIM_Version", "iso22166-202:2025", "", simNv);
		
		//BasicInfo
		BasicInfoExt basicProfile = (BasicInfoExt)source.getBasicInfo();
		result.setModuleName(basicProfile.getName());
		result.setDescription(basicProfile.getDescription());
		result.setManufacturer(basicProfile.getVendor());
		
		idnType.setInformationModelVersion(basicProfile.getVersion());

		createISONameValue(factory, "componentKind", basicProfile.getComponentKind(), simNv);
		createISONameValue(factory, "rtcType", basicProfile.getRtcType(), simNv);
		createISONameValue(factory, "category", basicProfile.getCategory(), simNv);
		if(basicProfile.getMaxInstances()!=null) {
			createISONameValue(factory, "maxInstances", basicProfile.getMaxInstances().toString(), simNv);
		}
		createISONameValue(factory, "abstract", basicProfile.getAbstract(), simNv);
		createISONameValue(factory, "hardwareProfile", basicProfile.getHardwareProfile(), simNv);
		if(basicProfile.getCreationDate()!=null) {
			createISONameValue(factory, "creationDate", basicProfile.getCreationDate().toString(), simNv);
		}
		if(basicProfile.getUpdateDate() != null) {
			createISONameValue(factory, "updateDate", basicProfile.getUpdateDate().toString(), simNv);
		}
		createISONameValue(factory, "executionType", basicProfile.getExecutionType(), simNv);
		
		DocBasic basicDoc = basicProfile.getDoc();
		if(basicDoc != null) {
			createISONameValue(factory, "docAlgorithm", basicDoc.getAlgorithm(), simNv);
			createISONameValue(factory, "docDescription", basicDoc.getDescription(), simNv);
			createISONameValue(factory, "docInout", basicDoc.getInout(), simNv);
			createISONameValue(factory, "docCreator", basicDoc.getCreator(), simNv);
			createISONameValue(factory, "docLicense", basicDoc.getLicense(), simNv);
			createISONameValue(factory, "docReference", basicDoc.getReference(), simNv);
		}

		createISONameValue(factory, "extComment", basicProfile.getComment(), simNv);
		createISONameValue(factory, "extSaveProject", basicProfile.getSaveProject(), simNv);
		createISONameValue(factory, "extVersionUpLog", String.join(", ", basicProfile.getVersionUpLogs()), simNv);
		
		OStype osType = factory.createOStype();
		properties.setOsType(osType);
		
		ExecutionType exeType = factory.createExecutionType();
		properties.getExeType().add(exeType); 
		exeType.setOpType(convertActivityType(basicProfile.getActivityType()));
		exeType.setInstanceType(convertComponentType(basicProfile.getComponentType()));
		if(basicProfile.getExecutionRate()!=null) {
			exeType.setTimeConstraint(basicProfile.getExecutionRate());
		}
		
		List<Property> propList = basicProfile.getProperties();
		propList.sort(Comparator.comparing(Property::getName));
		parseBasicProperties(factory, result, propList);
		//////////
		for(Dataport dport : source.getDataPorts() ) {
			DataportExt port = (DataportExt)dport;
			Variable var = factory.createVariable();
			iovar.getVariable().add(var);
			NVList iovarNv = factory.createNVList();
			
			var.setName(port.getName());
			var.setType(port.getType());
			var.setUnit(port.getUnit());
			String portType = port.getPortType();
			if(portType.toLowerCase().contains("in")) {
				var.setIoType(InOutType.IN);
			} else if(portType.toLowerCase().contains("out")) {
				var.setIoType(InOutType.OUT);
			}
			
			createISONameValue(factory, "idlFile", port.getIdlFile(), iovarNv);
			createISONameValue(factory, "interfaceType", port.getInterfaceType(), iovarNv);
			createISONameValue(factory, "dataflowType", port.getDataflowType(), iovarNv);
			createISONameValue(factory, "subscriptionType", port.getSubscriptionType(), iovarNv);
			
			DocDataport portDoc = port.getDoc();
			if(portDoc != null) {
				var.setDescription(portDoc.getDescription());
				createISONameValue(factory, "type", portDoc.getType(), iovarNv);
				createISONameValue(factory, "number", portDoc.getNumber(), iovarNv);
				createISONameValue(factory, "semantics", portDoc.getSemantics(), iovarNv);
				createISONameValue(factory, "unit", portDoc.getUnit(), iovarNv);
				createISONameValue(factory, "occurrence", portDoc.getOccerrence(), iovarNv);
				createISONameValue(factory, "operation", portDoc.getOperation(), iovarNv);
			}

			createISONameValue(factory, "comment", port.getComment(), iovarNv);
			createISONameValue(factory, "variableName", port.getVariableName(), iovarNv);
			try {
				createISONameValue(factory, "position", port.getPosition().toString(), iovarNv);
			} catch (Exception ex){
			}
			
			for(Property prop : port.getProperties()) {
				String key = prop.getName();
				
				if(equalsKey(key, "value")) {
					var.setValue(prop.getValue());
				} else {
					createISONameValue(factory, prop.getName(), prop.getValue(), iovarNv);
				}
			}
			if(0<iovarNv.getNv().size()) {
				var.setAdditionalInfo(iovarNv);
			}
		}
		//////////
		services.setNoOfBasicService(BigInteger.valueOf(source.getServicePorts().size()));
		services.setNoOfOptionalService(BigInteger.valueOf(0));
		for(Serviceport sport : source.getServicePorts() ) {
			ServiceportExt port = (ServiceportExt)sport;
			ServiceProfile prof = factory.createServiceProfile();
			services.getServiceProfile().add(prof);
			NVList serviceNv = factory.createNVList();
			
			prof.setId(port.getName());
			DocServiceport doc = port.getDoc();
			if(doc!=null) {
				createISONameValue(factory, "description", doc.getDescription(), serviceNv);
				createISONameValue(factory, "ifdescription", doc.getIfdescription(), serviceNv);
			}

			createISONameValue(factory, "comment", port.getComment(), serviceNv);
			try {
				createISONameValue(factory, "position", port.getPosition().toString(), serviceNv);
			} catch (Exception ex){
			}
			for(Property prop : port.getProperties()) {
				String key = prop.getName();
				
				if(equalsKey(key, "ifurl")) {
					prof.setIfURL(prop.getValue());
				} else if(equalsKey(key, "pvtype")) {
					prof.setPvType(PhysicalVirtual_0020.valueOf(prop.getValue()));
				} else if(equalsKey(key, "motype")) {
					prof.setMoType(MOType.valueOf(prop.getValue()));
				} else {
					createISONameValue(factory, prop.getName(), prop.getValue(), serviceNv);
				}
			}
			
			for(TransmissionMethod trans : port.getTransMethods() ) {
				createISONameValue(factory, "kind", trans.getKind(), serviceNv);
			}
			
			for(Serviceinterface sifbasic : port.getServiceInterface()) {
				ServiceinterfaceExt sif = (ServiceinterfaceExt)sifbasic;
				ServiceMethod method = factory.createServiceMethod();
				prof.getMethodList().add(method);
				NVList sifNv = factory.createNVList();
				
				method.setMethodName(sif.getName());
				method.setRetType(sif.getType());
				if(sif.getDirection().toLowerCase().equals("required")) {
					method.setReqProvType(ReqProvType.REQUIRED);
				} else if(sif.getDirection().toLowerCase().equals("provided")) {
					method.setReqProvType(ReqProvType.PROVIDED);
				}
				String strMoType = getTargetPropertyValue(sif.getProperties(), "motype");
				if(strMoType != null && 0 < strMoType.length()) {
					method.setMoType(MOType.valueOf(strMoType));
				}
				
				createISONameValue(factory, "instanceName", sif.getInstanceName(), sifNv);
				if(sif.getIdlFile() != null) {
					File file = new File(sif.getIdlFile());
					createISONameValue(factory, "idlFile", file.getName(), sifNv);
					createISONameValue(factory, "path", file.getParent(), sifNv);
				}
				
				DocServiceinterface ifdoc = sif.getDoc();
				if(ifdoc != null) {
					createISONameValue(factory, "description", ifdoc.getDescription(), sifNv);
					createISONameValue(factory, "docArgument", ifdoc.getDocArgument(), sifNv);
					createISONameValue(factory, "docReturn", ifdoc.getDocReturn(), sifNv);
					createISONameValue(factory, "docException", ifdoc.getDocException(), sifNv);
					createISONameValue(factory, "docPreCondition", ifdoc.getDocPreCondition(), sifNv);
					createISONameValue(factory, "docPostCondition", ifdoc.getDocPostCondition(), sifNv);
					
				}

				createISONameValue(factory, "comment", sif.getComment(), sifNv);
				createISONameValue(factory, "variableName", sif.getVariableName(), sifNv);
				parseInterfaceProperties(factory, sif.getProperties(), method, sifNv);
				
				if(0 < sifNv.getNv().size()) {
					method.setAdditionalInfo(sifNv);
				}
			}
			if(0 < serviceNv.getNv().size()) {
				prof.setAdditionalInfo(serviceNv);
			}
		}
		//////////
		ConfigurationSet confset  = source.getConfigurationSet();
		if(confset != null) {
			for(Configuration confbasic : confset.getConfiguration() ) {
				ConfigurationExt conf= (ConfigurationExt)confbasic;
				org.iso.iso22166.part202.profile.Property prop = factory.createProperty();
				properties.getProperty().add(prop);
				NVList propNv = factory.createNVList();
				
				prop.setName(conf.getName());
				prop.setType(conf.getType());
				prop.setValue(conf.getDefaultValue());
				prop.setUnit(conf.getUnit());
				String constraintStr;
				try {
					constraintStr = XmlHandler.restoreConstraint(conf.getConstraint());
					createISONameValue(factory, "constraint", constraintStr, propNv);
				} catch (Exception e) {
				}
				
				DocConfiguration docConf = conf.getDoc();
				if(docConf != null) {
					prop.setDescription(docConf.getDescription());
					createISONameValue(factory, "docDataname", docConf.getDataname(), propNv);
					createISONameValue(factory, "docDefaultValue", docConf.getDefaultValue(), propNv);
					createISONameValue(factory, "docUnit", docConf.getUnit(), propNv);
					createISONameValue(factory, "docRange", docConf.getRange(), propNv);
					createISONameValue(factory, "docConstraint", docConf.getConstraint(), propNv);
				}
				
				createISONameValue(factory, "comment", conf.getComment(), propNv);
				createISONameValue(factory, "variableName", conf.getVariableName(), propNv);
				for(Property confprop : conf.getProperties()) {
					String key = confprop.getName();
					String value = confprop.getValue();
					
					if(equalsKey(key, "immutable")) {
						prop.setImmutable(Boolean.valueOf(value));
					} else {
						createISONameValue(factory, key, value, propNv);
					}
				}
				if(0 < propNv.getNv().size()) {
					prop.setAdditionalInfo(propNv);
				}
			}
		}
		//////////
		Language lang = source.getLanguage();
		if(lang!=null) {
			CompilerType compiler = factory.createCompilerType();
			properties.setCompiler(compiler);
			
			compiler.setCompilerName(lang.getKind());
			
			LanguageExt langext = (LanguageExt)lang;
			List<TargetEnvironment> envs = langext.getTargets();
			if(0<envs.size()) {
				TargetEnvironment env = envs.get(0);
				
				compiler.setOsName(env.getOs());
				List<String> cpus = env.getCpus();
				if(0<cpus.size()) {
					compiler.setBitnCPUarch(env.getCpus().get(0));
				}
				
				String strVersion = env.getLangVersion();
				String[] elems = strVersion.split(IProfileConstants.ELEM_DELIMITOR);
				if(0<elems.length) {
					RangeString range = factory.createRangeString();
					compiler.setVerRangeCompiler(range);
					range.setMin(elems[0]);
					if(1<elems.length) {
						range.setMax(elems[1]);
					}
				}
				if(0<env.getLibraries().size()) {
					Libraries libs = factory.createLibraries();
					properties.setLibs(libs);
					for(Library each : env.getLibraries() ) {
						org.iso.iso22166.part202.profile.Library lib = factory.createLibrary();
						lib.setName(each.getName());
						lib.setVersion(each.getVersion());
						libs.getLibraries().add(lib);
					}
				}
			}
		}
		//////////
		Actions actions = source.getActions();
		if(actions != null) {
			createActionInfo(factory, actions.getOnInitialize(), "onInitialize", simNv);
			createActionInfo(factory, actions.getOnFinalize(), "onFinalize", simNv);
			createActionInfo(factory, actions.getOnStartup(), "onStartup", simNv);
			createActionInfo(factory, actions.getOnShutdown(), "onShutdown", simNv);
			createActionInfo(factory, actions.getOnActivated(), "onActivated", simNv);
			createActionInfo(factory, actions.getOnDeactivated(), "onDeactivated", simNv);
			createActionInfo(factory, actions.getOnAborting(), "onAborting", simNv);
			createActionInfo(factory, actions.getOnError(), "onError", simNv);
			createActionInfo(factory, actions.getOnReset(), "onReset", simNv);
			createActionInfo(factory, actions.getOnExecute(), "onExecute", simNv);
			createActionInfo(factory, actions.getOnStateUpdate(), "onStateUpdate", simNv);
			createActionInfo(factory, actions.getOnRateChanged(), "onRateChanged", simNv);
			createActionInfo(factory, actions.getOnAction(), "onAction", simNv);
			createActionInfo(factory, actions.getOnModeChanged(), "onModeChanged", simNv);
		}
		
		return result;
	}
	
	private OpTypes convertActivityType(String source) {
		if(source.toUpperCase().equals("PERIODIC")) {
			return OpTypes.PERIODIC;
		} else if(source.toUpperCase().equals("EVENTDRIVEN")) {
			return OpTypes.EVENTDRIVEN;
		} else if(source.toUpperCase().equals("SPORADIC")) {
			return OpTypes.NONRT;
		}
		return null;
	}

	private InstanceType convertComponentType(String source) {
		if(source.toUpperCase().equals("STATIC")) {
			return InstanceType.SINGLETON;
		} else if(source.toUpperCase().equals("UNIQUE")) {
			return InstanceType.MULTITON_STATIC;
		} else if(source.toUpperCase().equals("COMMUTATIVE")) {
			return InstanceType.MULTITON_COMM;
		}
		return null;
	}

	private void parseInterfaceProperties(ObjectFactory factory, List<Property> propList, ServiceMethod method, NVList sifNv) {
		for(Property prop : propList) {
			String key = prop.getName();
			String value = prop.getValue();
			if(value==null || value.length() == 0) continue;
			
			if(startsWithKey(key, "argtype_valuename")) {
				if(equalsKey(key, "argtype_valuename") == false) continue;
				
				ArgSpec arg = factory.createArgSpec();
				method.getArgType().add(arg);
				arg.setValueName(value);
				NVList argNv = factory.createNVList();
				
				arg.setType(getTargetPropertyValue(propList, "argtype_" + value.toLowerCase() + "_type"));
				
				List<Property> inoutList = getTargetProperty(propList, "argtype_" + value.toLowerCase() + "_inout");
				if(0 < inoutList.size()) {
					arg.setInout(InOutType.valueOf(inoutList.get(0).getValue()));
				}
				
				List<Property> otherList = getTargetStartProperty(propList, "argtype_" + value.toLowerCase() + "_add_");
				for(Property each : otherList) {
					String orgKey = each.getName().replace("argType_" + value + "_add_", "");
					createISONameValue(factory, orgKey, each.getValue(), argNv);
				}
				if(0 < argNv.getNv().size()) {
					arg.setAdditionalInfo(argNv);
				}
			} else {
				if(equalsKey(key, "motype")) continue;
				if(startsWithKey(key, "argtype_")) continue;

				createISONameValue(factory, key, value, sifNv);
			}
		}
	}

	private void parseBasicProperties(ObjectFactory factory, SIM result, List<Property> propList) {
		Status status = result.getStatus();
		NVList simNv = result.getAdditionalInfo();
		
		result.setExamples(getTargetPropertyValue(propList, "examples"));

		List<Property> exeTypeList = getTargetStartProperty(propList, "exeType_");
		if(0<exeTypeList.size()) {
			buildExeType(factory, result, exeTypeList);
		}
		List<Property> infraList = getTargetStartProperty(propList, "infra_");
		if(0<infraList.size()) {
			buildInfrastructure(factory, result, infraList);
		}
		List<Property> safesList = getTargetStartProperty(propList, "safesecure_");
		if(0<safesList.size()) {
			buildSafeSecure(factory, result, safesList);
		}
		List<Property> modelList = getTargetStartProperty(propList, "modelling_");
		if(0<modelList.size()) {
			buildModelling(factory, result, modelList);
		}
		List<Property> exeflList = getTargetStartProperty(propList, "exeForm_");
		if(0<exeflList.size()) {
			buildExeForm(factory, result, exeflList);
		}
		
		for(Property prop : propList) {
			String key = prop.getName();
			String value = prop.getValue();
			
			if(value==null || value.length() == 0) continue;

			if(equalsKey(key, "examples")
					|| equalsKey(key, "profileVersion")
					|| key.equals("SIM_Version")
					|| startsWithKey(key, "exeType_")
					|| startsWithKey(key, "infra_")
					|| startsWithKey(key, "safesecure_")
					|| startsWithKey(key, "modelling_")
					|| startsWithKey(key, "exeform_")) continue;
				
			if(equalsKey(key, "swaspects")){
				if(value.contains(IProfileConstants.ELEM_DELIMITOR) == false) continue;
				String[] elems = value.split(IProfileConstants.ELEM_DELIMITOR);
				if(0 < elems.length) {
					ModuleID mid = factory.createModuleID();
					result.getIdnType().getSwAspects().add(mid);
					mid.getMID().add(hexStringToBytes(elems[0]));
					if(1 < elems.length) {
						mid.setIID(hexStringToBytes(elems[1]));
					}
				}

			} else if(equalsKey(key, "mID")){
				result.getIdnType().getModuleID().getMID().add(hexStringToBytes(value));
			} else if(equalsKey(key, "iID")){
				result.getIdnType().getModuleID().setIID(hexStringToBytes(value));

			} else if(equalsKey(key, "osType_type")){
				result.getProperties().getOsType().setType(value);
			} else if(equalsKey(key, "osType_bit")){
				result.getProperties().getOsType().setBit(NoBit.fromValue(value));
			} else if(equalsKey(key, "osType_version")){
				result.getProperties().getOsType().setVersion(value);

			} else if(equalsKey(key, "executionstatus")){
				status.setExecutionStatus(ExeStatus.valueOf(value));
			} else if(equalsKey(key, "errortype")){
				BigInteger val = new BigInteger(value);
				status.setErrorType(val);

			} else {
				createISONameValue(factory, key, value, simNv);
			}
		}
		if(simNv.getNv().size() == 0) {
			result.setAdditionalInfo(null);
		}
	}
	
	private void buildExeType(ObjectFactory factory, SIM result, List<Property> propList) {
		List<ExecutionType> exeTypes = result.getProperties().getExeType();
		ExecutionType exeType = exeTypes.get(0);

		String hardRtStr = getTargetPropertyValue(propList, "exeType_hardRT");
		if(0 < hardRtStr.length()) {
			exeType.setHardRT(Boolean.valueOf(hardRtStr));
		}
		String priorityStr = getTargetPropertyValue(propList, "exeType_priority");
		if(0 < priorityStr.length()) {
			exeType.setPriority(hexStringToBytes(priorityStr));
		}
		
		for(Property each : propList) {
			String eachKey = each.getName();
			String eachValue = each.getValue();
			eachKey = eachKey.replace(IProfileConstants.ISO_PREFIX, "");
			
			if(eachKey.equals("exeType_hardRT")
					|| eachKey.equals("exeType_priority")) continue;

			String[] elems = eachKey.split("_");
			if(elems.length < 3) continue;
			
			String funcNoStr = elems[1];
			ExecutionType func;
			try {
				int funcNo = Integer.parseInt(funcNoStr);
				if(exeTypes.size() < funcNo + 1) {
					func = factory.createExecutionType();
					result.getProperties().getExeType().add(func);
					
				} else {
					func = exeTypes.get(funcNo); 
				}
			} catch (NumberFormatException ex) {
				continue;
			}

			if(eachKey.endsWith("_opType")) {
				func.setOpType(OpTypes.valueOf(eachValue));
			} else if(eachKey.endsWith("_hardRT")) {
				func.setHardRT(Boolean.valueOf(eachValue));
			} else if(eachKey.endsWith("_timeConstraint")) {
				func.setTimeConstraint(Double.valueOf(eachValue));
			} else if(eachKey.endsWith("_priority")) {
				func.setPriority(hexStringToBytes(eachValue));
			} else if(eachKey.endsWith("_instanceType")) {
				func.setInstanceType(InstanceType.valueOf(eachValue));
			}
		}

	}
	
	private void buildExeForm(ObjectFactory factory, SIM result, List<Property> propList) {
		ExecutableForm exeFrom = factory.createExecutableForm();
		result.setExeForm(exeFrom);
		
		List<Property> libList = getTargetStartProperty(propList, "exeForm_LibraryURL");
		for(Property each : libList) {
			exeFrom.getLibraryURL().add(each.getValue());
		}
		
		for(Property each : propList) {
			String eachKey = each.getName();
			String eachValue = each.getValue();
			eachKey = eachKey.replace(IProfileConstants.ISO_PREFIX, "");
			
			if(eachKey.equals("exeForm_LibraryURL")) continue;
			
			String[] elems = eachKey.split("_");
			if(elems.length < 3) continue;
			
			String funcNoStr = elems[2];
			ExeForm func;
			try {
				int funcNo = Integer.parseInt(funcNoStr);
				if(exeFrom.getExeForm().size() < funcNo) {
					func = factory.createExeForm();
					exeFrom.getExeForm().add(func);
					
					List<Property> otherList = getTargetStartProperty(propList, "exeForm_" + funcNo + "_add_");
					NVList mcNv = factory.createNVList();
					for(Property eachP : otherList) {
						String orgKey = eachP.getName().replace("exeForm_" + funcNo + "_add_", "");
						createISONameValue(factory, orgKey, eachP.getValue(), mcNv);
					}
					if(0 < mcNv.getNv().size()) {
						func.setAdditionalInfo(mcNv);
					}
				} else {
					func = exeFrom.getExeForm().get(funcNo-1); 
				}
			} catch (NumberFormatException ex) {
				continue;
			}
			
			if(eachKey.endsWith("_exeFileURL")) {
				func.setExeFileURL(eachValue);
			} else if(eachKey.endsWith("_shellCmd")) {
				func.setShellCmd(eachValue);
			}
		}
		int exeNum = exeFrom.getExeForm().size();
		for(int index=0; index<exeNum; index++) {
			ExeForm ef = exeFrom.getExeForm().get(index);
			int efIdx = index + 1;
			NVList efNv = factory.createNVList();
			
			List<Property> exePropList = getTargetStartProperty(propList, "exeform_" + efIdx + "_property_");
			for(Property each : exePropList) {
				String eachKey = each.getName();
				String eachValue = each.getValue();
				
				String[] elems = eachKey.split("_");
				if(elems.length < 5) continue;
				
				String propNoStr = elems[4];
				org.iso.iso22166.part202.profile.Property targetProp;
				try {
					int propNo = Integer.parseInt(propNoStr);
					if(ef.getProperties().size() < propNo) {
						targetProp = factory.createProperty();
						ef.getProperties().add(targetProp);
					} else {
						targetProp = ef.getProperties().get(propNo-1); 
					}
				} catch (NumberFormatException ex) {
					continue;
				}
				
				if(eachKey.endsWith("_value")) {
					targetProp.setValue(eachValue);
				} else if(eachKey.endsWith("_immutable")) {
					targetProp.setImmutable(Boolean.valueOf(eachValue));
				} else if(eachKey.endsWith("_description")) {
					targetProp.setDescription(eachValue);
				} else if(eachKey.endsWith("_name")) {
					targetProp.setName(eachValue);
				} else if(eachKey.endsWith("_type")) {
					targetProp.setType(eachValue);
				} else if(eachKey.endsWith("_unit")) {
					targetProp.setUnit(eachValue);
				}
			}
		}
	}
	
	private void buildModelling(ObjectFactory factory, SIM result, List<Property> modelList) {
		Modelling modelling = factory.createModelling();
		result.setModelling(modelling);
		
		for(Property each : modelList) {
			String eachKey = each.getName();
			String eachValue = each.getValue();
			eachKey = eachKey.replace(IProfileConstants.ISO_PREFIX, "");
			
			String[] elems = eachKey.split("_");
			if(elems.length < 2) continue;
			
			String funcNoStr = elems[1];
			ModelCase func;
			try {
				int modelNo = Integer.parseInt(funcNoStr);
				if(modelling.getSimulationModel().size() < modelNo) {
					func = factory.createModelCase();
					modelling.getSimulationModel().add(func);
					
					List<Property> modelPropList = getTargetStartProperty(modelList, "modelling_" + modelNo + "_add_");
					NVList mcNv = factory.createNVList();
					for(Property eachP : modelPropList) {
						String orgKey = eachP.getName().replace("modelling_" + modelNo + "_add_", "");
						createISONameValue(factory, orgKey, eachP.getValue(), mcNv);
					}
					if(0 < mcNv.getNv().size()) {
						func.setAdditionalInfo(mcNv);
					}
				} else {
					func = modelling.getSimulationModel().get(modelNo-1); 
				}
			} catch (NumberFormatException ex) {
				continue;
			}
			if(eachKey.endsWith("_simulator")) {
				func.setSimulator(eachValue);
			} else if(eachKey.endsWith("_mdf")) {
				func.getMdf().addAll(Arrays.asList(eachValue.split(",")));
			} else if(eachKey.endsWith("_lib")) {
				func.getLibraries().add(eachValue);
			}
		}
		
		int mcNum = modelling.getSimulationModel().size();
		for(int index=0; index<mcNum; index++) {
			ModelCase mc = modelling.getSimulationModel().get(index);
			int mcIdx = index + 1;
			NVList mcNv = factory.createNVList();

			List<Property> dynamicList = getTargetStartProperty(modelList, "modelling_" + mcIdx + "_dynamicsw_");
			for(Property each : dynamicList) {
				String eachKey = each.getName();
				String eachValue = each.getValue();
				eachKey = eachKey.replace(IProfileConstants.ISO_PREFIX, "");
				
				String[] elems = eachKey.split("_");
				if(elems.length < 4) continue;
				
				String dynamicNoStr = elems[3];
				ExeForm targetDyn;
				try {
					int dynamicNo = Integer.parseInt(dynamicNoStr);
					if(mc.getDynamicSW().size() < dynamicNo) {
						targetDyn = factory.createExeForm();
						mc.getDynamicSW().add(targetDyn);
						List<Property> dynPropList = getTargetStartProperty(modelList, "modelling_" + mcIdx + "_dynamicsw_" + dynamicNo + "_add_");
						NVList dynNv = factory.createNVList();
						for(Property eachP : dynPropList) {
							String orgKey = eachP.getName().replace("modelling_" + mcIdx + "_dynamicsw_" + dynamicNo + "_add_", "");
							createISONameValue(factory, orgKey, eachP.getValue(), dynNv);
						}
						if(0 < dynNv.getNv().size()) {
							targetDyn.setAdditionalInfo(dynNv);
						}

					} else {
						targetDyn = mc.getDynamicSW().get(dynamicNo-1); 
					}
				} catch (NumberFormatException ex) {
					continue;
				}
				if(eachKey.endsWith("_exeFileURL")) {
					targetDyn.setExeFileURL(eachValue);
				} else if(eachKey.endsWith("_shellCmd")) {
					targetDyn.setShellCmd(eachValue);
				}
			}
			
			int dynamicNum = mc.getDynamicSW().size();
			for(int idxDyn=0; idxDyn<dynamicNum; idxDyn++) {
				ExeForm targetDyn = mc.getDynamicSW().get(idxDyn);
				int dynIdx = idxDyn + 1;
				
				List<Property> propertyList = getTargetStartProperty(modelList, "modelling_" + mcIdx + "_dynamicsw_" + dynIdx + "_property_");
				for(Property each : propertyList) {
					String eachKey = each.getName();
					String eachValue = each.getValue();
					
					String[] elems = eachKey.split("_");
					if(elems.length < 6) continue;
					
					String propNoStr = elems[5];
					org.iso.iso22166.part202.profile.Property targetProp;
					try {
						int propNo = Integer.parseInt(propNoStr);
						if(targetDyn.getProperties().size() < propNo) {
							targetProp = factory.createProperty();
							targetDyn.getProperties().add(targetProp);
						} else {
							targetProp = targetDyn.getProperties().get(propNo-1); 
						}
					} catch (NumberFormatException ex) {
						continue;
					}

					if(eachKey.endsWith("_value")) {
						targetProp.setValue(eachValue);
					} else if(eachKey.endsWith("_immutable")) {
						targetProp.setImmutable(Boolean.valueOf(eachValue));
					} else if(eachKey.endsWith("_description")) {
						targetProp.setDescription(eachValue);
					} else if(eachKey.endsWith("_name")) {
						targetProp.setName(eachValue);
					} else if(eachKey.endsWith("_type")) {
						targetProp.setType(eachValue);
					} else if(eachKey.endsWith("_unit")) {
						targetProp.setUnit(eachValue);
					}
				}
			}
		}
	}
	
	private void buildSafeSecure(ObjectFactory factory, SIM result, List<Property> propList) {
		SafeSecure safes = factory.createSafeSecure();
		result.setSafeSecure(safes);
		
		NVList safesNv = factory.createNVList();
		List<Property> otherList = getTargetStartProperty(propList, "safesecure_add_");
		for(Property each : otherList) {
			String orgKey = each.getName().replace("safeSecure_add_", "");
			createISONameValue(factory, orgKey, each.getValue(), safesNv);
		}
		if(0 < safesNv.getNv().size()) {
			safes.setAdditionalInfo(safesNv);
		}
		///////
		safes.setOverallValidSafetyLevelType(PLSILType.valueOf(getTargetPropertyValue(propList, "safesecure_overallvalidsafetyleveltype")));
		safes.setOverallSafetyLevelPL(SafeytLevelPL.valueOf(getTargetPropertyValue(propList, "safesecure_overallsafetylevelpl")));
		safes.setOverallSafetyLevelSIL(getTargetPropertyValue(propList, "safesecure_overallsafetylevelsil"));
		safes.setOverallPhySecurityLevel(getTargetPropertyValue(propList, "safesecure_overallphysecuritylevel"));
		safes.setOverallCybSecurityLevel(getTargetPropertyValue(propList, "safesecure_overallcybsecuritylevel"));
		///////
		List<Property> inSafeList = getTargetStartProperty(propList, "safesecure_insafetylevel_");
		for(Property each : inSafeList) {
			String eachKey = each.getName();
			String eachValue = each.getValue();
			eachKey = eachKey.replace(IProfileConstants.ISO_PREFIX, "");
			
			String[] elems = eachKey.split("_");
			if(elems.length < 3) continue;
			
			String funcNoStr = elems[2];
			SafetyFunction func;
			try {
				int insafeNo = Integer.parseInt(funcNoStr);
				if(safes.getInSafetyLevel().size() < insafeNo) {
					func = factory.createSafetyFunction();
					safes.getInSafetyLevel().add(func);
				} else {
					func = safes.getInSafetyLevel().get(insafeNo-1); 
				}
			} catch (NumberFormatException ex) {
				continue;
			}
			
			if(eachKey.endsWith("_safetyFunctionType")) {
				func.setSafetyFunctionType(SafetyType.valueOf(eachValue));
			} else if(eachKey.endsWith("_validSafetyLevelType")) {
				func.setValidSafetyLevelType(PLSILType.valueOf(eachValue));
			} else if(eachKey.endsWith("_eachSafetyLevelPL")) {
				func.setEachSafetyLevelPL(SafeytLevelPL.valueOf(eachValue));
			} else if(eachKey.endsWith("_eachSafetyLevelSIL")) {
				func.setEachSafetyLevelSIL(eachValue);
			}
		}
		
		List<Property> inCyberList = getTargetStartProperty(propList, "safesecure_incybsecuritylevel_");
		for(Property each : inCyberList) {
			String eachKey = each.getName();
			String eachValue = each.getValue();
			eachKey = eachKey.replace(IProfileConstants.ISO_PREFIX, "");
			
			String[] elems = eachKey.split("_");
			if(elems.length < 3) continue;
			
			String inCyberNoStr = elems[2];
			CyberSecurity func;
			try {
				int inCyberNo = Integer.parseInt(inCyberNoStr);
				if(safes.getInCybSecurityLevel().size() < inCyberNo) {
					func = factory.createCyberSecurity();
					safes.getInCybSecurityLevel().add(func);
				} else {
					func = safes.getInCybSecurityLevel().get(inCyberNo-1); 
				}
			} catch (NumberFormatException ex) {
				continue;
			}
			if(eachKey.endsWith("_securityType")) {
				func.setSecurityType(SecurityType.valueOf(eachValue));
			} else if(eachKey.endsWith("_eachSecurityLevel")) {
				func.setEachSecurityLevel(eachValue);
			}
		}
	}
	
	private void buildInfrastructure(ObjectFactory factory, SIM result, List<Property> propList) {
		Infrastructure infra = factory.createInfrastructure();
		result.setInfra(infra);

		NVList infraNv = factory.createNVList();
		List<Property> otherList = getTargetProperty(propList, "infra_add_");
		for(Property each : otherList) {
			String orgKey = each.getName().replace(IProfileConstants.ISO_PREFIX + "infra_add_", "");
			createISONameValue(factory, orgKey, each.getValue(), infraNv);
		}
		if(0 < infraNv.getNv().size()) {
			infra.setAdditionalInfo(infraNv);
		}
		///////				
		List<Property> dbList = getTargetProperty(propList, "infra_database");
		for(Property each : dbList) {
			String eachValue = each.getValue();
			if(eachValue.contains(IProfileConstants.ELEM_DELIMITOR) == false) continue;
			String[] elems = eachValue.split(IProfileConstants.ELEM_DELIMITOR);
			
			if(0 < elems.length) {
				InfraType itype = factory.createInfraType();
				infra.getDatabase().add(itype);
				itype.setName(elems[0]);
				if(1 < elems.length) {
					RangeString range = factory.createRangeString();
					itype.setVersion(range);
					range.setMin(elems[1]);
					if(2 < elems.length) {
						range.setMax(elems[2]);
					}
				}
			}
		}
		//			
		List<Property> mtpList = getTargetStartProperty(propList, "infra_comms_mosttop");
		for(Property each : mtpList) {
			String eachKey = each.getName();
			String eachValue = each.getValue();
			
			String commsNoStr = eachKey.replace(IProfileConstants.ISO_PREFIX + "infra_comms_mostTop_", "");
			try {
				int commsNo = Integer.parseInt(commsNoStr);
				Communication comms;
				if(infra.getComms().size() < commsNo) {
					comms = factory.createCommunication();
					infra.getComms().add(comms);
				} else {
					comms = infra.getComms().get(commsNo-1); 
				}

				if(eachValue.contains(IProfileConstants.ELEM_DELIMITOR) == false) continue;
				String[] elems = eachValue.split(IProfileConstants.ELEM_DELIMITOR);
				
				if(0 < elems.length) {
					InfraType itype = factory.createInfraType();
					comms.getMostTopProtocol().add(itype);
					itype.setName(elems[0]);
					if(1 < elems.length) {
						RangeString range = factory.createRangeString();
						itype.setVersion(range);
						range.setMin(elems[1]);
						if(2 < elems.length) {
							range.setMax(elems[2]);
						}
					}
				}
			} catch (NumberFormatException ex) {
			}
		}
		//
		int commNum = infra.getComms().size();
		for(int index=0; index<commNum; index++) {
			int comIdx = index + 1;
			List<Property> upList = getTargetStartProperty(propList, "infra_comms_underlaying_" + comIdx);
			if(0<upList.size()) {
				Communication targetCom =infra.getComms().get(index); 
				DataBus dBus = factory.createDataBus();
				targetCom.setUnderlyingProtocol(dBus);
				NVList dbNv = new NVList();
				for(Property each : upList) {
					String eachName = each.getName();
					String eachValue = each.getValue();
					if(startsWithKey(eachName, "infra_comms_underlaying_" + comIdx + "_connectionType")) {
						dBus.setConnectionType(eachValue);
					} else if(startsWithKey(eachName, "infra_comms_underlaying_" + comIdx + "_typePhyMac")) {
						dBus.setTypePhyMac(eachValue);
					} else if(startsWithKey(eachName, "infra_comms_underlaying_" + comIdx + "_typeNetTrans")) {
						dBus.getTypeNetTrans().addAll(Arrays.asList(eachValue.split(",")));
					} else if(startsWithKey(eachName, "infra_comms_underlaying_" + comIdx + "_typeApp")) {
						dBus.getTypeApp().addAll(Arrays.asList(eachValue.split(",")));
					} else if(startsWithKey(eachName, "infra_comms_underlaying_" + comIdx + "_speed")) {
						dBus.setSpeed(Double.parseDouble(eachValue));
					} else if(startsWithKey(eachName, "infra_comms_underlaying_" + comIdx + "_add_")) {
						String orgKey = each.getName().replace("infra_comms_underlaying_" + comIdx + "_add_", "");
						createISONameValue(factory, orgKey, eachValue, dbNv);
					}
				}
				if(0<dbNv.getNv().size()) {
					dBus.setAdditionalInfo(dbNv);
				}
			}
		}
		///////				
		List<Property> mwList = getTargetProperty(propList, "infra_middleware");
		for(Property each : mwList) {
			String eachValue = each.getValue();
			if(eachValue.contains(IProfileConstants.ELEM_DELIMITOR) == false) continue;
			String[] elems = eachValue.split(IProfileConstants.ELEM_DELIMITOR);
			
			if(0 < elems.length) {
				InfraType itype = factory.createInfraType();
				infra.getMiddleware().add(itype);
				itype.setName(elems[0]);
				if(1 < elems.length) {
					RangeString range = factory.createRangeString();
					itype.setVersion(range);
					range.setMin(elems[1]);
					if(2 < elems.length) {
						range.setMax(elems[2]);
					}
				}
			}
		}
	}
	
	private boolean equalsKey(String key, String target) {
		if(key.toLowerCase().equals(IProfileConstants.ISO_PREFIX.toLowerCase() + target.toLowerCase())) {
			return true;
		}
		return false;
	}
	
	private boolean startsWithKey(String key, String target) {
		if(key.toLowerCase().startsWith(IProfileConstants.ISO_PREFIX.toLowerCase() + target.toLowerCase())) {
			return true;
		}
		return false;
	}

	private String getTargetPropertyValue(List<Property> propList, String key) {
		List<Property> filtered = getTargetProperty(propList, key);
		if(filtered.size() == 1) return filtered.get(0).getValue();
		return "";
	}

	private List<Property> getTargetProperty(List<Property> propList, String key) {
		List<Property> filtered = propList.stream()
									.filter(p -> p.getName().toLowerCase().equals(IProfileConstants.ISO_PREFIX.toLowerCase() + key.toLowerCase())
													|| p.getName().toLowerCase().equals(key))
									.collect(Collectors.toList());
		return filtered;
	}
	
	private List<Property> getTargetStartProperty(List<Property> propList, String key) {
		List<Property> filtered = propList.stream()
									.filter(p -> p.getName().toLowerCase().startsWith(IProfileConstants.ISO_PREFIX.toLowerCase() + key.toLowerCase())
													|| p.getName().toLowerCase().startsWith(key.toLowerCase()))
									.collect(Collectors.toList());
		return filtered;
	}

	private byte[] hexStringToBytes(String hex) {
	    int len = hex.length();
	    if (len % 2 != 0) return null;
	    
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
	                            + Character.digit(hex.charAt(i + 1), 16));
	    }
	    return data;
	}

	private void createActionInfo(ObjectFactory factory, ActionStatus action, String actionName, NVList nvs) {
		if(action != null) {
			createISONameValue(factory, actionName, action.getImplemented(), nvs);
			ActionStatusDoc actionDoc = (ActionStatusDoc)action;
			DocAction docaction = actionDoc.getDoc();
			if(docaction != null) {
				createISONameValue(factory, actionName + "DocDescription", docaction.getDescription(), nvs);
				createISONameValue(factory, actionName + "DocPreCondition", docaction.getPreCondition(), nvs);
				createISONameValue(factory, actionName + "DocPostCondition", docaction.getPostCondition(), nvs);
			}
		}
	}

	private void createISONameValue(ObjectFactory factory, String key, String value, NVList nvs) {
		createNameValue(factory, key, value, IProfileConstants.ISO_PREFIX, nvs);
	}
	
	private void createNameValue(ObjectFactory factory, String key, String value, String prefix, NVList nvs) {
		if(value==null || value.length() == 0) return;
		NameValue nv = factory.createNameValue();
		if(key.toLowerCase().startsWith(prefix.toLowerCase())) {
			nv.setName(key.substring(prefix.length()));
		} else {
			nv.setName(prefix + key);
		}
		nv.setValue(value);
		nvs.getNv().add(nv);
	}
	//////////
	public boolean saveXmlIso(SIM profile, String targetFile) throws Exception {
		String xmlString = convertToXmlIso(profile);

		String lineSeparator = System.getProperty( "line.separator" );
		if( lineSeparator==null || lineSeparator.equals("") ) lineSeparator = "\n";
		String xmlSplit[] = xmlString.split(lineSeparator);

		try(BufferedWriter outputFile = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(targetFile), "UTF-8")) ) {
			for(int intIdx=0;intIdx<xmlSplit.length;intIdx++) {
				outputFile.write(xmlSplit[intIdx]);
				outputFile.newLine();
			}
		}
		return true;
	}
	
	public String convertToXmlIso(SIM profile) throws Exception {
	    String xmlString = "";
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(SIM.class);
			
			Marshaller marshaller = jaxbContext.createMarshaller();
		    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT , new Boolean(true));
//		    marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper",
//					new NamespacePrefixMapperImpl(
//							"http://www.openrtp.org/namespaces/rts"));
		    StringWriter xmlFileWriter = new StringWriter();
		    marshaller.marshal(profile, xmlFileWriter);
		    xmlString = xmlFileWriter.toString();
		} catch (JAXBException exception) {
			throw new Exception("XML Transformation Failed.", exception);
		}
		return xmlString;
	}

//
//	/**
//	 * XMLGregorianCalendar 郢ｧ蜑�ｽｻ�ｽｻ隲｢荳奇ｿｽ�ｽｮ隴鯉ｽ･闔牙�･縲帝�墓ｻ難ｿｽ闊鯉ｼ�邵ｺ�ｽｾ邵ｺ蜷ｶ�ｿｽ�ｿｽ(Map隰厄ｿｽ陞ｳ�ｿｽ)
//	 */
//	public static XMLGregorianCalendar createXMLGregorianCalendar(Map<String, Integer> dateY) {
//		return createXMLGregorianCalendar((dateY.get("year")).intValue(), (dateY.get("month")).intValue(),
//				(dateY.get("day")).intValue(), (dateY.get("hour")).intValue(), (dateY.get("minute")).intValue(),
//				(dateY.get("second")).intValue());
//	}
//
//	/**
//	 * XMLGregorianCalendar 郢ｧ蜑�ｽｻ�ｽｻ隲｢荳奇ｿｽ�ｽｮ隴鯉ｽ･闔牙�･縲帝�墓ｻ難ｿｽ闊鯉ｼ�邵ｺ�ｽｾ邵ｺ蜷ｶ�ｿｽ�ｿｽ(陝ｷ�ｽｴ邵ｲ竏ｵ諤ｦ邵ｲ竏ｵ蠕狗ｸｲ竏ｵ蜃ｾ邵ｲ竏晢ｿｽ邵ｲ竏ｫ�ｽｧ蜻域ｬ�陞ｳ�ｿｽ)
//	 */
//	public static XMLGregorianCalendar createXMLGregorianCalendar(int year, int month, int day, int hourOfDay,
//			int minute, int second) {
//		GregorianCalendar c = new GregorianCalendar();
//		c.set(year, month - 1, day, hourOfDay, minute, second);
//		c.set(GregorianCalendar.MILLISECOND, 0);
//		return createXMLGregorianCalendar(c);
//	}

//	/**
//	 * XMLGregorianCalendar 郢ｧ蜑�ｽｻ�ｽｻ隲｢荳奇ｿｽ�ｽｮ隴鯉ｽ･闔牙�･縲帝�墓ｻ難ｿｽ闊鯉ｼ�邵ｺ�ｽｾ邵ｺ蜷ｶ�ｿｽ�ｿｽ(隴�ｿｽ陝�諤懶ｿｽ邇ｲ谺�陞ｳ�ｿｽ yyyy-MM-ddTHH:mm:ss)
//	 */
//	public static XMLGregorianCalendar createXMLGregorianCalendar(String date) {
//		try {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//			sdf.setLenient(false);
//			return createXMLGregorianCalendar(sdf.parse(date));
//		} catch (Exception e) {
//			throw new RuntimeException("Fail to create xml date.", e);
//		}
//	}

//	/**
//	 * XMLGregorianCalendar 郢ｧ蜑�ｽｻ�ｽｻ隲｢荳奇ｿｽ�ｽｮ隴鯉ｽ･闔牙�･縲帝�墓ｻ難ｿｽ闊鯉ｼ�邵ｺ�ｽｾ邵ｺ蜷ｶ�ｿｽ�ｿｽ(隴鯉ｽ･闔我ｿｶ谺�陞ｳ�ｿｽ)
//	 */
//	public static XMLGregorianCalendar createXMLGregorianCalendar(Date date) {
//		GregorianCalendar c = new GregorianCalendar();
//		c.setTime(date);
//		return createXMLGregorianCalendar(c);
//	}

//	public static XMLGregorianCalendar createXMLGregorianCalendar(GregorianCalendar cal) {
//		try {
//			XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
//			return xmlDate;
//		} catch (Exception e) {
//			throw new RuntimeException("Fail to create xml date.", e);
//		}
//	}
}
