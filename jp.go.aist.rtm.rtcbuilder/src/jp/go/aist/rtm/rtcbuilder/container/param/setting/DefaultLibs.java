package jp.go.aist.rtm.rtcbuilder.container.param.setting;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultLibs {
    @JsonProperty("_comment")
    public String comment;
    
    public List<String> common;
    
    @JsonProperty("by_middleware")
    public Map<String, List<String>> byMiddleware;
    
    @JsonProperty("by_language")
    public Map<String, Map<String, List<String>>> byLanguage;
    
    @JsonProperty("by_os_condition")
    public List<OsCondition> byOsCondition;
    
    public List<ConditionalRule> conditional;
}