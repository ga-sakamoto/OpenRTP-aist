package jp.go.aist.rtm.rtcbuilder.ros.param;

import java.io.Serializable;

import jp.go.aist.rtm.rtcbuilder.generator.param.AbstractRecordedParam;

public class TimerParam extends AbstractRecordedParam implements Serializable {
	private static final long serialVersionUID = -5584413630295784662L;
	
	private String name;
	private Double rate;
	private String callBack;
	private String description;
	
	public TimerParam() {
		this.name = "";
		this.rate = 0.0;
		this.callBack = "";
		this.description = "";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		checkUpdated(this.name, name);
		this.name = name;
	}

	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		checkUpdated(this.rate, rate);
		this.rate = rate;
	}

	public String getCallBack() {
		return callBack;
	}
	public void setCallBack(String callBack) {
		checkUpdated(this.callBack, callBack);
		this.callBack = callBack;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		checkUpdated(this.description, description);
		this.description = description;
	}
}
