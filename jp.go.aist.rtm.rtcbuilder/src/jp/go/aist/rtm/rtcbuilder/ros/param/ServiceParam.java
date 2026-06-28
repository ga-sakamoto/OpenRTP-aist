package jp.go.aist.rtm.rtcbuilder.ros.param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jp.go.aist.rtm.rtcbuilder.generator.param.AbstractRecordedParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.PropertyParam;
import jp.go.aist.rtm.rtcbuilder.nl.Messages;
import jp.go.aist.rtm.rtcbuilder.util.StringUtil;

public class ServiceParam extends AbstractRecordedParam implements Serializable {
	private static final long serialVersionUID = -5584413830295784662L;
	
	private String name;
	private String role;
	private String type;
	private String varCallbackName;
	//
	private String docDescription;
	private String docArgument;
	private String docReturn;
	//Properties
	private List<PropertyParam> properties = new ArrayList<PropertyParam>();

	public ServiceParam() {
		this.name = "";
		this.role = "";
		this.type = "";
		this.varCallbackName = "";
		//
		this.docDescription = "";
		this.docArgument = "";
		this.docReturn = "";
		//
		setUpdated(false);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		checkUpdated(this.name, name);
		this.name = name;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		checkUpdated(this.role, role);
		this.role = role;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		checkUpdated(this.type, type);
		this.type = type;
	}

	public String getVarCallbackName() {
		return varCallbackName;
	}
	public void setVarCallbackName(String var_callback_name) {
		checkUpdated(this.varCallbackName, var_callback_name);
		this.varCallbackName = var_callback_name;
	}

	public String getDocDescription() {
		return docDescription;
	}
	public void setDocDescription(String doc_description) {
		checkUpdated(this.docDescription, doc_description);
		this.docDescription = doc_description;
	}

	public String getDocArgument() {
		return docArgument;
	}
	public void setDocArgument(String doc_argument) {
		checkUpdated(this.docArgument, doc_argument);
		this.docArgument = doc_argument;
	}

	public String getDocReturn() {
		return docReturn;
	}

	public void setDocReturn(String doc_return) {
		checkUpdated(this.docReturn, doc_return);
		this.docReturn = doc_return;
	}

	public List<PropertyParam> getProperties() {
		return properties;
	}
	/////
	public String validateInfo() {
		if(this.name == null || this.name.length() == 0) {
			return Messages.getString("IMC.VALIDATE_SERVICE_NAME1");
		}
		if( !StringUtil.checkDigitSmallAlphabetUｓSlash(this.name) ) {
			return Messages.getString("IMC.VALIDATE_SERVICE_NAME2");
		}
		if( this.name.endsWith("/") ) {
			return Messages.getString("IMC.VALIDATE_SERVICE_NAME3");
		}
		if( this.name.contains("//") || this.name.contains("__") ) {
			return Messages.getString("IMC.VALIDATE_SERVICE_NAME4");
		}
		
		if( this.type==null || this.type.length()==0 ) {
			return Messages.getString("IMC.VALIDATE_SERVICE_TYPE");
		}

		return null;
	}
	
	public void convertInfo() {
		if(this.varCallbackName == null || this.varCallbackName.length() == 0) {
			this.varCallbackName = this.name;
		}
	}
}
