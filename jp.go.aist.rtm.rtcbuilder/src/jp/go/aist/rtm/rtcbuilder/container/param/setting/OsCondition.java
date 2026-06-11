package jp.go.aist.rtm.rtcbuilder.container.param.setting;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OsCondition {
    public String name;
    public String middleware;
    
    @JsonProperty("exclude_os_versions")
    public List<String> excludeOsVersions;
    
    public List<String> libs;
}