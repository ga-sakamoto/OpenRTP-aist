package jp.go.aist.rtm.rtcbuilder.container.param.setting;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.HashMap;
import java.util.Map;

public class LibraryMapping {

    private Map<String, InstallDefinition> platforms = new HashMap<>();

    @JsonAnySetter
    public void addPlatform(String key, InstallDefinition value) {
        platforms.put(key, value);
    }

    public Map<String, InstallDefinition> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(Map<String, InstallDefinition> platforms) {
        this.platforms = platforms;
    }
}
