package jp.go.aist.rtm.iso22166_part202.util;

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
import org.iso.iso22166.part202.profile.MOType;
import org.iso.iso22166.part202.profile.ModelCase;
import org.iso.iso22166.part202.profile.Modelling;
import org.iso.iso22166.part202.profile.ModuleID;
import org.iso.iso22166.part202.profile.NVList;
import org.iso.iso22166.part202.profile.NameValue;
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
	final private String ELEM_DELIMITOR = ":";
	
	public SIM convertRtc2Iso(RtcProfile source) {
		ObjectFactory factory = new ObjectFactory();

		SIM result = factory.createSIM();
		IDnType idnType = factory.createIDnType();
		result.setIdnType(idnType);	
		
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
		
		createNameValue(factory, "profileVersion", source.getVersion(), simNv);
		
		//BasicInfo
		BasicInfoExt basicProfile = (BasicInfoExt)source.getBasicInfo();
		result.setModuleName(basicProfile.getName());
		result.setDescription(basicProfile.getDescription());
		result.setManufacturer(basicProfile.getVendor());
		
		idnType.setInformationModelVersion(basicProfile.getVersion());

		createNameValue(factory, "activityType", basicProfile.getActivityType(), simNv);
		createNameValue(factory, "componentKind", basicProfile.getComponentKind(), simNv);
		createNameValue(factory, "rtcType", basicProfile.getRtcType(), simNv);
		createNameValue(factory, "category", basicProfile.getCategory(), simNv);
		if(basicProfile.getMaxInstances()!=null) {
			createNameValue(factory, "maxInstances", basicProfile.getMaxInstances().toString(), simNv);
		}
		createNameValue(factory, "abstract", basicProfile.getAbstract(), simNv);
		createNameValue(factory, "hardwareProfile", basicProfile.getHardwareProfile(), simNv);
		if(basicProfile.getCreationDate()!=null) {
			createNameValue(factory, "creationDate", basicProfile.getCreationDate().toString(), simNv);
		}
		if(basicProfile.getUpdateDate() != null) {
			createNameValue(factory, "updateDate", basicProfile.getUpdateDate().toString(), simNv);
		}
		
		DocBasic basicDoc = basicProfile.getDoc();
		if(basicDoc != null) {
			createNameValue(factory, "docAlgorithm", basicDoc.getAlgorithm(), simNv);
			createNameValue(factory, "docDescription", basicDoc.getDescription(), simNv);
			createNameValue(factory, "docInout", basicDoc.getInout(), simNv);
			createNameValue(factory, "docCreator", basicDoc.getCreator(), simNv);
			createNameValue(factory, "docLicense", basicDoc.getLicense(), simNv);
			createNameValue(factory, "docReference", basicDoc.getReference(), simNv);
		}

		createNameValue(factory, "extComment", basicProfile.getComment(), simNv);
		createNameValue(factory, "extSaveProject", basicProfile.getSaveProject(), simNv);
		createNameValue(factory, "extVersionUpLog", String.join(", ", basicProfile.getVersionUpLogs()), simNv);
		
		ExecutionType exeType = factory.createExecutionType();
		properties.getExeType().add(exeType); 
		//TODO 要修正
		exeType.setInstanceType(InstanceType.SINGLETON);
		if(basicProfile.getExecutionRate()!=null) {
			exeType.setTimeConstraint(basicProfile.getExecutionRate());
		}
		exeType.setOpType(OpTypes.PERIODIC);
		
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
			
			createNameValue(factory, "idlFile", port.getIdlFile(), iovarNv);
			createNameValue(factory, "interfaceType", port.getInterfaceType(), iovarNv);
			createNameValue(factory, "dataflowType", port.getDataflowType(), iovarNv);
			createNameValue(factory, "subscriptionType", port.getSubscriptionType(), iovarNv);
			
			DocDataport portDoc = port.getDoc();
			if(portDoc != null) {
				var.setDescription(portDoc.getDescription());
				createNameValue(factory, "type", portDoc.getType(), iovarNv);
				createNameValue(factory, "number", portDoc.getNumber(), iovarNv);
				createNameValue(factory, "semantics", portDoc.getSemantics(), iovarNv);
				createNameValue(factory, "unit", portDoc.getUnit(), iovarNv);
				createNameValue(factory, "occurrence", portDoc.getOccerrence(), iovarNv);
				createNameValue(factory, "operation", portDoc.getOperation(), iovarNv);
			}

			createNameValue(factory, "comment", port.getComment(), iovarNv);
			createNameValue(factory, "variableName", port.getVariableName(), iovarNv);
			try {
				createNameValue(factory, "position", port.getPosition().toString(), iovarNv);
			} catch (Exception ex){
			}
			
			for(Property prop : port.getProperties()) {
				String key = prop.getName();
				
				if(key.toLowerCase().equals("value")) {
					var.setValue(prop.getValue());
				} else {
					createNameValue(factory, prop.getName(), prop.getValue(), iovarNv);
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
			services.getSeviceProfile().add(prof);
			NVList serviceNv = factory.createNVList();
			
			prof.setId(port.getName());
			DocServiceport doc = port.getDoc();
			if(doc!=null) {
				createNameValue(factory, "description", doc.getDescription(), serviceNv);
				createNameValue(factory, "ifdescription", doc.getIfdescription(), serviceNv);
			}

			createNameValue(factory, "comment", port.getComment(), serviceNv);
			try {
				createNameValue(factory, "position", port.getPosition().toString(), serviceNv);
			} catch (Exception ex){
			}
			for(Property prop : port.getProperties()) {
				String key = prop.getName();
				
				if(key.toLowerCase().equals("ifurl")) {
					prof.setIfURL(prop.getValue());
				} else if(key.toLowerCase().equals("pvtype")) {
					prof.setPvType(PhysicalVirtual_0020.valueOf(prop.getValue()));
				} else if(key.toLowerCase().equals("motype")) {
					prof.setMoType(MOType.valueOf(prop.getValue()));
				} else {
					createNameValue(factory, prop.getName(), prop.getValue(), serviceNv);
				}
			}
			
			for(TransmissionMethod trans : port.getTransMethods() ) {
				createNameValue(factory, "kind", trans.getKind(), serviceNv);
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
				
				createNameValue(factory, "instanceName", sif.getInstanceName(), sifNv);
				if(sif.getIdlFile() != null) {
					File file = new File(sif.getIdlFile());
					createNameValue(factory, "idlFile", file.getName(), sifNv);
					createNameValue(factory, "path", file.getParent(), sifNv);
				}
				
				DocServiceinterface ifdoc = sif.getDoc();
				if(ifdoc != null) {
					createNameValue(factory, "description", ifdoc.getDescription(), sifNv);
					createNameValue(factory, "docArgument", ifdoc.getDocArgument(), sifNv);
					createNameValue(factory, "docReturn", ifdoc.getDocReturn(), sifNv);
					createNameValue(factory, "docException", ifdoc.getDocException(), sifNv);
					createNameValue(factory, "docPreCondition", ifdoc.getDocPreCondition(), sifNv);
					createNameValue(factory, "docPostCondition", ifdoc.getDocPostCondition(), sifNv);
					
				}

				createNameValue(factory, "comment", sif.getComment(), sifNv);
				createNameValue(factory, "variableName", sif.getVariableName(), sifNv);
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
				prop.setVallue(conf.getDefaultValue());
				prop.setUnit(conf.getUnit());
				String constraintStr;
				try {
					constraintStr = XmlHandler.restoreConstraint(conf.getConstraint());
					createNameValue(factory, "constraint", constraintStr, propNv);
				} catch (Exception e) {
				}
				
				DocConfiguration docConf = conf.getDoc();
				if(docConf != null) {
					prop.setDescription(docConf.getDescription());
					createNameValue(factory, "docDataname", docConf.getDataname(), propNv);
					createNameValue(factory, "docDefaultValue", docConf.getDefaultValue(), propNv);
					createNameValue(factory, "docUnit", docConf.getUnit(), propNv);
					createNameValue(factory, "docRange", docConf.getRange(), propNv);
					createNameValue(factory, "docConstraint", docConf.getConstraint(), propNv);
				}
				
				createNameValue(factory, "comment", conf.getComment(), propNv);
				createNameValue(factory, "variableName", conf.getVariableName(), propNv);
				for(Property confprop : conf.getProperties()) {
					String key = confprop.getName();
					String value = confprop.getValue();
					
					if(key.equals("immutable")) {
						prop.setImmutable(Boolean.valueOf(value));
					} else {
						createNameValue(factory, key, value, propNv);
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
			//TODO 要修正
			for(TargetEnvironment env : langext.getTargets()) {
				
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

	private void parseInterfaceProperties(ObjectFactory factory, List<Property> propList, ServiceMethod method, NVList sifNv) {
		for(Property prop : propList) {
			String key = prop.getName();
			String value = prop.getValue();
			if(value==null || value.length() == 0) continue;
			
			if(key.toLowerCase().startsWith("argtype_valuename")) {
				if(key.toLowerCase().equals("argtype_valuename") == false) continue;
				
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
					createNameValue(factory, orgKey, each.getValue(), argNv);
				}
				if(0 < argNv.getNv().size()) {
					arg.setAdditionalInfo(argNv);
				}
			} else {
				if(key.toLowerCase().equals("motype")) continue;
				if(key.toLowerCase().startsWith("argtype_")) continue;

				createNameValue(factory, key, value, sifNv);
			}
		}
	}

	private void parseBasicProperties(ObjectFactory factory, SIM result, List<Property> propList) {
		Status status = result.getStatus();
		NVList simNv = result.getAdditionalInfo();
		
		result.setExamples(getTargetPropertyValue(propList, "examples"));

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

			if(key.toLowerCase().equals("examples")
				|| key.toLowerCase().startsWith("infra_")
				|| key.toLowerCase().startsWith("safesecure_")
				|| key.toLowerCase().startsWith("modelling_")
				|| key.toLowerCase().startsWith("exeform_")) continue;
				
			if(key.toLowerCase().equals("swaspects")){
				if(value.contains(ELEM_DELIMITOR) == false) continue;
				String[] elems = value.split(ELEM_DELIMITOR);
				if(0 < elems.length) {
					ModuleID mid = factory.createModuleID();
					result.getIdnType().getSwAspects().add(mid);
					mid.getMID().add(hexStringToBytes(elems[0]));
					if(1 < elems.length) {
						mid.setIID(hexStringToBytes(elems[1]));
					}
				}

			} else if(key.toLowerCase().equals("executionstatus")){
				status.setExecutionStatus(ExeStatus.valueOf(prop.getValue()));
			} else if(key.toLowerCase().equals("errortype")){
				BigInteger val = new BigInteger(prop.getValue());
				status.setErrorType(val);

			} else {
				createNameValue(factory, prop.getName(), prop.getValue(), simNv);
			}
		}
	}
	
	private void buildExeForm(ObjectFactory factory, SIM result, List<Property> propList) {
		ExecutableForm exeFrom = factory.createExecutableForm();
		result.setExecForm(exeFrom);
		
		List<Property> libList = getTargetStartProperty(propList, "exeForm_LibraryURL");
		for(Property each : libList) {
			exeFrom.getLibraryURL().add(each.getValue());
		}
		
		for(Property each : propList) {
			String eachKey = each.getName();
			String eachValue = each.getValue();
			
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
						createNameValue(factory, orgKey, eachP.getValue(), mcNv);
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
					targetProp.setVallue(eachValue);
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
						createNameValue(factory, orgKey, eachP.getValue(), mcNv);
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
							createNameValue(factory, orgKey, eachP.getValue(), dynNv);
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
						targetProp.setVallue(eachValue);
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
			createNameValue(factory, orgKey, each.getValue(), safesNv);
		}
		if(0 < safesNv.getNv().size()) {
			safes.setAdditionalInfo(safesNv);
		}
		///////
		safes.setOverallvalidSafetyLevelType(PLSILType.valueOf(getTargetPropertyValue(propList, "safesecure_overallvalidsafetyleveltype")));
		safes.setOverallSafetyLevelPL(SafeytLevelPL.valueOf(getTargetPropertyValue(propList, "safesecure_overallsafetylevelpl")));
		safes.setOverallSafetyLevelSIL(getTargetPropertyValue(propList, "safesecure_overallsafetylevelsil"));
		safes.setOverallPhySecurityLevel(getTargetPropertyValue(propList, "safesecure_overallphysecuritylevel"));
		safes.setOverallCybSecurityLevel(getTargetPropertyValue(propList, "safesecure_overallcybsecuritylevel"));
		///////
		List<Property> inSafeList = getTargetStartProperty(propList, "safesecure_insafetylevel_");
		for(Property each : inSafeList) {
			String eachKey = each.getName();
			String eachValue = each.getValue();
			
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
				func.setSecurityLevel(eachValue);
			}
		}
	}
	
	private void buildInfrastructure(ObjectFactory factory, SIM result, List<Property> propList) {
		Infrastructure infra = factory.createInfrastructure();
		result.setInfra(infra);

		NVList infraNv = factory.createNVList();
		List<Property> otherList = getTargetProperty(propList, "infra_add_");
		for(Property each : otherList) {
			String orgKey = each.getName().replace("infra_add_", "");
			createNameValue(factory, orgKey, each.getValue(), infraNv);
		}
		if(0 < infraNv.getNv().size()) {
			infra.setAdditionalInfo(infraNv);
		}
		///////				
		List<Property> dbList = getTargetProperty(propList, "infra_database");
		for(Property each : dbList) {
			String eachValue = each.getValue();
			if(eachValue.contains(ELEM_DELIMITOR) == false) continue;
			String[] elems = eachValue.split(ELEM_DELIMITOR);
			
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
			
			String commsNoStr = eachKey.replace("infra_comms_mostTop_", "");
			try {
				int commsNo = Integer.parseInt(commsNoStr);
				Communication comms;
				if(infra.getComms().size() < commsNo) {
					comms = factory.createCommunication();
					infra.getComms().add(comms);
				} else {
					comms = infra.getComms().get(commsNo-1); 
				}

				if(eachValue.contains(ELEM_DELIMITOR) == false) continue;
				String[] elems = eachValue.split(ELEM_DELIMITOR);
				
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
				targetCom.setUnderlyingProrocol(dBus);
				NVList dbNv = new NVList();
				for(Property each : upList) {
					String eachName = each.getName();
					String eachValue = each.getValue();
					if(eachName.startsWith("infra_comms_underlaying_" + comIdx + "_connectionType")) {
						dBus.setConnectionType(eachValue);
					} else if(eachName.startsWith("infra_comms_underlaying_" + comIdx + "_typePhyMac")) {
						dBus.setTypePhyMac(eachValue);
					} else if(eachName.startsWith("infra_comms_underlaying_" + comIdx + "_typeNetTrans")) {
						dBus.getTypeNetTrans().addAll(Arrays.asList(eachValue.split(",")));
					} else if(eachName.startsWith("infra_comms_underlaying_" + comIdx + "_typeApp")) {
						dBus.getTypeApp().addAll(Arrays.asList(eachValue.split(",")));
					} else if(eachName.startsWith("infra_comms_underlaying_" + comIdx + "_speed")) {
						dBus.setSpeed(Double.parseDouble(eachValue));
					} else if(eachName.startsWith("infra_comms_underlaying_" + comIdx + "_add_")) {
						String orgKey = each.getName().replace("infra_comms_underlaying_" + comIdx + "_add_", "");
						createNameValue(factory, orgKey, eachValue, dbNv);
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
			if(eachValue.contains(ELEM_DELIMITOR) == false) continue;
			String[] elems = eachValue.split(ELEM_DELIMITOR);
			
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
	
	private String getTargetPropertyValue(List<Property> propList, String key) {
		List<Property> filtered = getTargetProperty(propList, key);
		if(filtered.size() == 1) return filtered.get(0).getValue();
		return "";
	}

	private List<Property> getTargetProperty(List<Property> propList, String key) {
		List<Property> filtered = propList.stream()
									.filter(p -> p.getName().toLowerCase().equals(key))
									.collect(Collectors.toList());
		return filtered;
	}
	
	private List<Property> getTargetStartProperty(List<Property> propList, String key) {
		List<Property> filtered = propList.stream()
									.filter(p -> p.getName().toLowerCase().startsWith(key.toLowerCase()))
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
			createNameValue(factory, actionName, action.getImplemented(), nvs);
			ActionStatusDoc actionDoc = (ActionStatusDoc)action;
			DocAction docaction = actionDoc.getDoc();
			if(docaction != null) {
				createNameValue(factory, actionName + "DocDescription", docaction.getDescription(), nvs);
				createNameValue(factory, actionName + "DocPreCondition", docaction.getPreCondition(), nvs);
				createNameValue(factory, actionName + "DocPostCondition", docaction.getPostCondition(), nvs);
			}
		}
	}

	private void createNameValue(ObjectFactory factory, String key, String value, NVList nvs) {
		if(value==null || value.length() == 0) return;
		NameValue nv = factory.createNameValue();
		nv.setName(key);
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
//	 * XMLGregorianCalendar 繧剃ｻｻ諢上�ｮ譌･莉倥〒逕滓�舌＠縺ｾ縺吶��(Map謖�螳�)
//	 */
//	public static XMLGregorianCalendar createXMLGregorianCalendar(Map<String, Integer> dateY) {
//		return createXMLGregorianCalendar((dateY.get("year")).intValue(), (dateY.get("month")).intValue(),
//				(dateY.get("day")).intValue(), (dateY.get("hour")).intValue(), (dateY.get("minute")).intValue(),
//				(dateY.get("second")).intValue());
//	}
//
//	/**
//	 * XMLGregorianCalendar 繧剃ｻｻ諢上�ｮ譌･莉倥〒逕滓�舌＠縺ｾ縺吶��(蟷ｴ縲∵怦縲∵律縲∵凾縲∝�縲∫ｧ呈欠螳�)
//	 */
//	public static XMLGregorianCalendar createXMLGregorianCalendar(int year, int month, int day, int hourOfDay,
//			int minute, int second) {
//		GregorianCalendar c = new GregorianCalendar();
//		c.set(year, month - 1, day, hourOfDay, minute, second);
//		c.set(GregorianCalendar.MILLISECOND, 0);
//		return createXMLGregorianCalendar(c);
//	}

//	/**
//	 * XMLGregorianCalendar 繧剃ｻｻ諢上�ｮ譌･莉倥〒逕滓�舌＠縺ｾ縺吶��(譁�蟄怜�玲欠螳� yyyy-MM-ddTHH:mm:ss)
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
//	 * XMLGregorianCalendar 繧剃ｻｻ諢上�ｮ譌･莉倥〒逕滓�舌＠縺ｾ縺吶��(譌･莉俶欠螳�)
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
