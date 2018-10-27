package me.droreo002.oreofishing.config;

import me.droreo002.oreofishing.OreoFishing;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;

public class Config {

    private final Map<String, Object>
              DEFAULT_FISHING = new HashMap<>()
            , DEFAULT_TITLE = new HashMap<>()
            , DEFAULT_SOUND = new HashMap<>();

    public Config() {
        FileConfiguration config = OreoFishing.get().getConfigManager().getConfig();

    }

    public Map<String, Object> getDefaultFishing() {
        return DEFAULT_FISHING;
    }

    public Map<String, Object> getDefaultSound() {
        return DEFAULT_SOUND;
    }

    public Map<String, Object> getDefaultTitle() {
        return DEFAULT_TITLE;
    }
}
