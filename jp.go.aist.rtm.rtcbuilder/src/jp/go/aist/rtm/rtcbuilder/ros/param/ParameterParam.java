package jp.go.aist.rtm.rtcbuilder.ros.param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jp.go.aist.rtm.rtcbuilder.generator.param.AbstractRecordedParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.PropertyParam;

public class ParameterParam extends AbstractRecordedParam implements Serializable {
	private static final long serialVersionUID = -7557513141707055620L;

	private String name;
	private String type;
	private String default_value;
	private double min;
	private double max;
	private double step;
	private boolean read_only;
	//
	private String doc_description;
	private String doc_dataname;
	private String doc_default;
	private String doc_unit;
	private String doc_range;
	private String doc_constraint;
	//Properties
	private List<PropertyParam> properties = new ArrayList<PropertyParam>();
	
	public ParameterParam() {
		this.name = "";
		this.type = "";
		this.default_value = "";
		this.min = 0.0;
		this.max = 0.0;
		this.step = 0.0;
		this.read_only = false;
		//
		this.doc_dataname = "";
		this.doc_default = "";
		this.doc_description = "";
		this.doc_unit = "";
		this.doc_range = "";
		this.doc_constraint = "";
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

	public String getType() {
		return type;
	}
	public void setType(String type) {
		checkUpdated(this.type, type);
		this.type = type;
	}

	public String getDefaultValue() {
		return default_value;
	}
	public void setDefaultValue(String default_value) {
		checkUpdated(this.default_value, default_value);
		this.default_value = default_value;
	}

	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		checkUpdated(this.min, min);
		this.min = min;
	}

	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		checkUpdated(this.max, max);
		this.max = max;
	}

	public double getStep() {
		return step;
	}
	public void setStep(double step) {
		checkUpdated(this.step, step);
		this.step = step;
	}

	public boolean isRead_only() {
		return read_only;
	}
	public void setRead_only(boolean read_only) {
		checkUpdated(this.read_only, read_only);
		this.read_only = read_only;
	}

	public String getDocDescription() {
		return doc_description;
	}
	public void setDocDescription(String doc_description) {
		checkUpdated(this.doc_description, doc_description);
		this.doc_description = doc_description;
	}

	public String getDocDataname() {
		return doc_dataname;
	}
	public void setDocDataname(String doc_dataname) {
		checkUpdated(this.doc_dataname, doc_dataname);
		this.doc_dataname = doc_dataname;
	}

	public String getDocDefault() {
		return doc_default;
	}
	public void setDocDefault(String doc_default) {
		checkUpdated(this.doc_default, doc_default);
		this.doc_default = doc_default;
	}

	public String getDocUnit() {
		return doc_unit;
	}
	public void setDocUnit(String doc_unit) {
		checkUpdated(this.doc_unit, doc_unit);
		this.doc_unit = doc_unit;
	}

	public String getDocRange() {
		return doc_range;
	}
	public void setDocRange(String doc_range) {
		checkUpdated(this.doc_range, doc_range);
		this.doc_range = doc_range;
	}

	public String getDocConstraint() {
		return doc_constraint;
	}
	public void setDocConstraint(String doc_constraint) {
		checkUpdated(this.doc_constraint, doc_constraint);
		this.doc_constraint = doc_constraint;
	}

	public List<PropertyParam> getProperties() {
		return properties;
	}
}
