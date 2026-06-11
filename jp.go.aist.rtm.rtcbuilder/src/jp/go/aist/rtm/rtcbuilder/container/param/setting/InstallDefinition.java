package jp.go.aist.rtm.rtcbuilder.container.param.setting;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.HashMap;
import java.util.Map;

public class InstallDefinition {
    private Map<String, Object> installInfo = new HashMap<>();

    @JsonAnySetter
    public void addInstallInfo(String key, Object value) {
        installInfo.put(key, value);
    }

    public Map<String, Object> getInstallInfo() {
        return installInfo;
    }

    public void setInstallInfo(Map<String, Object> installInfo) {
        this.installInfo = installInfo;
    }
}
