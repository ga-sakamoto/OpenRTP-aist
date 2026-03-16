package jp.go.aist.rtm.rtcbuilder.container.param;

import jp.go.aist.rtm.rtcbuilder.generator.param.AbstractRecordedParam;

public class LibraryParam extends AbstractRecordedParam {
	private String name;
	
	public LibraryParam() {
		this.name = "";
		setUpdated(true);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		checkUpdated(this.name, name);
		this.name = name;
	}
}
