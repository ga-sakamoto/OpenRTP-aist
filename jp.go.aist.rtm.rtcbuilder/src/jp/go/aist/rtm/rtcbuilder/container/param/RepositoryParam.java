package jp.go.aist.rtm.rtcbuilder.container.param;

public class RepositoryParam {
	private String URL;
	private String Branch;
	
	public RepositoryParam() {
		this.URL = "";
		this.Branch = "";
	}

	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
}
