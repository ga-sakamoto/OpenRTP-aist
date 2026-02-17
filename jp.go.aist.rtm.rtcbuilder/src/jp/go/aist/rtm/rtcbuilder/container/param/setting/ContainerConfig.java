package jp.go.aist.rtm.rtcbuilder.container.param.setting;

import java.util.ArrayList;
import java.util.List;

public class ContainerConfig {
    private List<Middleware> middlewares;
    private MappingDb mapping_db;
    
    public ContainerConfig() {
    	this.middlewares = new ArrayList<Middleware>();
    	this.mapping_db = new MappingDb();
    }

    public List<Middleware> getMiddlewares() {
        return middlewares;
    }

    public void setMiddlewares(List<Middleware> middlewares) {
        this.middlewares = middlewares;
    }

    public MappingDb getMapping_db() {
        return mapping_db;
    }
    public void setMapping_db(MappingDb mapping_db) {
        this.mapping_db = mapping_db;
    }
}
