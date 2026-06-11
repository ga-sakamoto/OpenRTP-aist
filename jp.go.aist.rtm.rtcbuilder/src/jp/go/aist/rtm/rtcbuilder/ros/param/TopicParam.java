package jp.go.aist.rtm.rtcbuilder.ros.param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jp.go.aist.rtm.rtcbuilder.generator.param.AbstractRecordedParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.PropertyParam;

public class TopicParam extends AbstractRecordedParam implements Serializable {
	private static final long serialVersionUID = 533482869407934299L;

	private String name;
	private String role;
	private String message_type;

	private String reliability_type;
	private String history_type;
	private Integer depth;

	private String var_callback_name;
	//
	private String doc_description;
	private String doc_type;
	private String doc_semantics;
	private String doc_unit;
	private String doc_occurrence;
	//Properties
	private List<PropertyParam> properties = new ArrayList<PropertyParam>();

	public TopicParam() {
		this.name = "";
		this.role = "";
		this.message_type = "";
		this.reliability_type = "";
		this.history_type = "";
		this.depth = 0;
		this.var_callback_name = "";
		//
		this.doc_description = "";
		this.doc_type = "";
		this.doc_semantics = "";
		this.doc_unit = "";
		this.doc_occurrence = "";
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

	public String getMessage_type() {
		return message_type;
	}
	public void setMessage_type(String message_type) {
		checkUpdated(this.message_type, message_type);
		this.message_type = message_type;
	}

	public String getReliability_type() {
		return reliability_type;
	}
	public void setReliability_type(String reliability_type) {
		checkUpdated(this.reliability_type, reliability_type);
		this.reliability_type = reliability_type;
	}

	public String getHistory_type() {
		return history_type;
	}
	public void setHistory_type(String history_type) {
		checkUpdated(this.history_type, history_type);
		this.history_type = history_type;
	}

	public Integer getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
		checkUpdated(this.depth, depth);
		this.depth = depth;
	}

	public String getVar_callback_name() {
		return var_callback_name;
	}
	public void setVar_callback_name(String var_callback_name) {
		checkUpdated(this.var_callback_name, var_callback_name);
		this.var_callback_name = var_callback_name;
	}

	public String getDoc_description() {
		return doc_description;
	}
	public void setDoc_description(String doc_description) {
		checkUpdated(this.doc_description, doc_description);
		this.doc_description = doc_description;
	}

	public String getDoc_type() {
		return doc_type;
	}
	public void setDoc_type(String doc_type) {
		checkUpdated(this.doc_type, doc_type);
		this.doc_type = doc_type;
	}

	public String getDoc_semantics() {
		return doc_semantics;
	}
	public void setDoc_semantics(String doc_semantics) {
		checkUpdated(this.doc_semantics, doc_semantics);
		this.doc_semantics = doc_semantics;
	}

	public String getDoc_unit() {
		return doc_unit;
	}
	public void setDoc_unit(String doc_unit) {
		checkUpdated(this.doc_unit, doc_unit);
		this.doc_unit = doc_unit;
	}

	public String getDoc_occurrence() {
		return doc_occurrence;
	}
	public void setDoc_occurrence(String doc_occurrence) {
		checkUpdated(this.doc_occurrence, doc_occurrence);
		this.doc_occurrence = doc_occurrence;
	}

	public List<PropertyParam> getProperties() {
		return properties;
	}
}
