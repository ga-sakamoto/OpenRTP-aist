package jp.go.aist.rtm.rtcbuilder.container.param.setting;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContainerConfig {
	public List<Middleware> middlewares;
    
    @JsonProperty("mapping_db")
    public MappingDb mappingDb;
}
