package jp.go.aist.rtm.rtcbuilder.container.param.setting;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

public class MappingDb {
    private String _comment;
    private Map<String, LibraryMapping> libraries;
    
    public MappingDb() {
    	this._comment = "";
    	this.libraries = new HashedMap();
    }

	public String get_comment() {
		return _comment;
	}
	public void set_comment(String _comment) {
		this._comment = _comment;
	}

	public Map<String, LibraryMapping> getLibraries() {
		return libraries;
	}
	public void setLibraries(Map<String, LibraryMapping> libraries) {
		this.libraries = libraries;
	}
}
