package jp.go.aist.rtm.rtcbuilder.ros.param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jp.go.aist.rtm.rtcbuilder.generator.param.AbstractRecordedParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.PropertyParam;

public class ServiceParam extends AbstractRecordedParam implements Serializable {
	private static final long serialVersionUID = -5584413830295784662L;
	
	private String name;
	private String role;
	private String type;
	private String var_callback_name;
	//
	private String doc_description;
	private String doc_argument;
	private String doc_return;
	//Properties
	private List<PropertyParam> properties = new ArrayList<PropertyParam>();

	public ServiceParam() {
		this.name = "";
		this.role = "";
		this.type = "";
		this.var_callback_name = "";
		//
		this.doc_description = "";
		this.doc_argument = "";
		this.doc_return = "";
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
		return var_callback_name;
	}
	public void setVar_callback_name(String var_callback_name) {
		checkUpdated(this.var_callback_name, var_callback_name);
		this.var_callback_name = var_callback_name;
	}

	public String getDocDescription() {
		return doc_description;
	}
	public void setDocDescription(String doc_description) {
		checkUpdated(this.doc_description, doc_description);
		this.doc_description = doc_description;
	}

	public String getDocArgument() {
		return doc_argument;
	}
	public void setDocArgument(String doc_argument) {
		checkUpdated(this.doc_argument, doc_argument);
		this.doc_argument = doc_argument;
	}

	public String getDocReturn() {
		return doc_return;
	}

	public void setDocReturn(String doc_return) {
		checkUpdated(this.doc_return, doc_return);
		this.doc_return = doc_return;
	}

	public List<PropertyParam> getProperties() {
		return properties;
	}
}
