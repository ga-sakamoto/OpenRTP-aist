package jp.go.aist.rtm.rtcbuilder.container.param.setting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

public class Middleware {
    private String name;
    private String type;
    private boolean has_language_selection;

    private List<Version> versions;
    private List<String> supported_os;
    private List<String> workspace_presets;
    private List<String> default_libs;

    private Map<String, List<String>> functional_presets;

    public Middleware() {
    	this.versions = new ArrayList<Version>();
    	this.supported_os = new ArrayList<String>();
    	this.workspace_presets = new ArrayList<String>();
    	this.default_libs = new ArrayList<String>();
    	this.functional_presets = new HashedMap();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHas_language_selection() {
        return has_language_selection;
    }

    public void setHas_language_selection(boolean has_language_selection) {
        this.has_language_selection = has_language_selection;
    }

    public List<Version> getVersions() {
        return versions;
    }

    public void setVersions(List<Version> versions) {
        this.versions = versions;
    }

    public List<String> getSupported_os() {
        return supported_os;
    }

    public void setSupported_os(List<String> supported_os) {
        this.supported_os = supported_os;
    }

    public List<String> getWorkspace_presets() {
        return workspace_presets;
    }

    public void setWorkspace_presets(List<String> workspace_presets) {
        this.workspace_presets = workspace_presets;
    }

    public List<String> getDefault_libs() {
        return default_libs;
    }

    public void setDefault_libs(List<String> default_libs) {
        this.default_libs = default_libs;
    }

    public Map<String, List<String>> getFunctional_presets() {
        return functional_presets;
    }

    public void setFunctional_presets(Map<String, List<String>> functional_presets) {
        this.functional_presets = functional_presets;
    }
}
