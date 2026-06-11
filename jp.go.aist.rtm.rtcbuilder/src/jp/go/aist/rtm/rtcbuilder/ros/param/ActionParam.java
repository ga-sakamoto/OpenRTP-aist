package jp.go.aist.rtm.rtcbuilder.ros.param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jp.go.aist.rtm.rtcbuilder.generator.param.AbstractRecordedParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.PropertyParam;

public class ActionParam extends AbstractRecordedParam implements Serializable {
	private static final long serialVersionUID = -5584413830295784662L;

	private String name;
	private String role;
	private String type;
	private String callback_name;
	//
	private String doc_description;
	private String doc_goal;
	private String doc_feedback;
	private String doc_result;
	//Properties
	private List<PropertyParam> properties = new ArrayList<PropertyParam>();
	
	public ActionParam() {
		this.name = "";
		this.role = "";
		this.type = "";
		this.callback_name = "";
		//
		this.doc_description = "";
		this.doc_goal = "";
		this.doc_feedback = "";
		this.doc_result = "";
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

	public String getCallbackName() {
		return callback_name;
	}
	public void setCallbackName(String callback_name) {
		checkUpdated(this.callback_name, callback_name);
		this.callback_name = callback_name;
	}

	public String getDocDescription() {
		return doc_description;
	}
	public void setDocDescription(String doc_description) {
		checkUpdated(this.doc_description, doc_description);
		this.doc_description = doc_description;
	}

	public String getDocGoal() {
		return doc_goal;
	}
	public void setDocGoal(String doc_goal) {
		checkUpdated(this.doc_goal, doc_goal);
		this.doc_goal = doc_goal;
	}

	public String getDocFeedback() {
		return doc_feedback;
	}
	public void setDocFeedback(String doc_feedback) {
		checkUpdated(this.doc_feedback, doc_feedback);
		this.doc_feedback = doc_feedback;
	}

	public String getDocResult() {
		return doc_result;
	}
	public void setDocResult(String doc_result) {
		checkUpdated(this.doc_result, doc_result);
		this.doc_result = doc_result;
	}

	public List<PropertyParam> getProperties() {
		return properties;
	}
}
