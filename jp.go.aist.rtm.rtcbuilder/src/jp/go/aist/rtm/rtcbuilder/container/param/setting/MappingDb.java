package jp.go.aist.rtm.rtcbuilder.container.param.setting;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MappingDb {
    @JsonProperty("_comment")
    public String comment;
    
    @JsonProperty("default_libs")
    public DefaultLibs defaultLibs;
    
    public Map<String, LibraryMapping> libraries;
}