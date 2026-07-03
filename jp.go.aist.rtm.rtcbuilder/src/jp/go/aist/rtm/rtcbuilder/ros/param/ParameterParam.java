package jp.go.aist.rtm.rtcbuilder.ros.param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jp.go.aist.rtm.rtcbuilder.generator.param.AbstractRecordedParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.PropertyParam;
import jp.go.aist.rtm.rtcbuilder.nl.Messages;
import jp.go.aist.rtm.rtcbuilder.util.StringUtil;

public class ParameterParam extends AbstractRecordedParam implements Serializable {
	private static final long serialVersionUID = -7557513141707055620L;

	private String name;
	private String type;
	private String defaultValue;
	private Double min;
	private Double max;
	private Double step;
	private boolean readOnly;
	//
	private String docDescription;
	private String docDataname;
	private String docDefault;
	private String docUnit;
	private String docRange;
	private String docConstraint;
	//Properties
	private List<PropertyParam> properties = new ArrayList<PropertyParam>();
	
	public ParameterParam() {
		this.name = "";
		this.type = "";
		this.defaultValue = "";
		this.min = null;
		this.max = null;
		this.step = null;
		this.readOnly = false;
		//
		this.docDataname = "";
		this.docDefault = "";
		this.docDescription = "";
		this.docUnit = "";
		this.docRange = "";
		this.docConstraint = "";
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
		return defaultValue;
	}
	public void setDefaultValue(String default_value) {
		checkUpdated(this.defaultValue, default_value);
		this.defaultValue = default_value;
	}

	public Double getMin() {
		return min;
	}
	public void setMin(Double min) {
		checkUpdated(this.min, min);
		this.min = min;
	}

	public Double getMax() {
		return max;
	}
	public void setMax(Double max) {
		checkUpdated(this.max, max);
		this.max = max;
	}

	public Double getStep() {
		return step;
	}
	public void setStep(Double step) {
		checkUpdated(this.step, step);
		this.step = step;
	}

	public boolean isReadOnly() {
		return readOnly;
	}
	public void setReadOnly(boolean read_only) {
		checkUpdated(this.readOnly, read_only);
		this.readOnly = read_only;
	}

	public String getDocDescription() {
		return docDescription;
	}
	public void setDocDescription(String doc_description) {
		checkUpdated(this.docDescription, doc_description);
		this.docDescription = doc_description;
	}

	public String getDocDataname() {
		return docDataname;
	}
	public void setDocDataname(String doc_dataname) {
		checkUpdated(this.docDataname, doc_dataname);
		this.docDataname = doc_dataname;
	}

	public String getDocDefault() {
		return docDefault;
	}
	public void setDocDefault(String doc_default) {
		checkUpdated(this.docDefault, doc_default);
		this.docDefault = doc_default;
	}

	public String getDocUnit() {
		return docUnit;
	}
	public void setDocUnit(String doc_unit) {
		checkUpdated(this.docUnit, doc_unit);
		this.docUnit = doc_unit;
	}

	public String getDocRange() {
		return docRange;
	}
	public void setDocRange(String doc_range) {
		checkUpdated(this.docRange, doc_range);
		this.docRange = doc_range;
	}

	public String getDocConstraint() {
		return docConstraint;
	}
	public void setDocConstraint(String doc_constraint) {
		checkUpdated(this.docConstraint, doc_constraint);
		this.docConstraint = doc_constraint;
	}

	public List<PropertyParam> getProperties() {
		return properties;
	}
	/////
	public String validateInfo() {
		if(this.name == null || this.name.length() == 0) {
			return Messages.getString("IMC.VALIDATE_PARAMETER_NAME1");
		}
		if( !StringUtil.checkDigitSmallAlphabetUｓSlash(this.name) ) {
			return Messages.getString("IMC.VALIDATE_PARAMETER_NAME2");
		}
		if( this.name.endsWith("/") ) {
			return Messages.getString("IMC.VALIDATE_PARAMETER_NAME3");
		}
		if( this.name.contains("//") || this.name.contains("__") ) {
			return Messages.getString("IMC.VALIDATE_PARAMETER_NAME4");
		}
		
		if(this.type == null || this.type.length() == 0) {
			return Messages.getString("IMC.VALIDATE_PARAMETER_TYPE");
		}
		
		if(this.defaultValue == null || this.defaultValue.length() == 0) {
			return Messages.getString("IMC.VALIDATE_PARAMETER_DEFVALUE");
		}

		return null;
	}
}
