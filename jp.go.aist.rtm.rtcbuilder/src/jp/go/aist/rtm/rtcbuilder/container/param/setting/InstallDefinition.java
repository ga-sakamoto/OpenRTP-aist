package jp.go.aist.rtm.rtcbuilder.container.param.setting;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.HashMap;
import java.util.Map;

public class InstallDefinition {
    private Map<String, String> installInfo = new HashMap<>();

    @JsonAnySetter
    public void addInstallInfo(String key, String value) {
        installInfo.put(key, value);
    }

    public Map<String, String> getInstallInfo() {
        return installInfo;
    }

    public void setInstallInfo(Map<String, String> installInfo) {
        this.installInfo = installInfo;
    }
}
