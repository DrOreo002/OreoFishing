package me.droreo002.oreofishing;

import me.droreo002.oreofishing.config.ConfigManager;
import me.droreo002.oreofishing.manager.LangFileManager;
import me.droreo002.oreofishing.objects.CustomSound;
import me.droreo002.oreofishing.objects.CustomTitle;
import me.droreo002.oreofishing.objects.FishingReward;
import org.bukkit.ChatColor;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

public class OreoFishing extends JavaPlugin {

    private static OreoFishing INSTANCE;
    private ConfigManager configManager;
    private LangFileManager langFileManager;

    @Override
    public void onEnable() {
        // Plugin startup logic (Important code)
        INSTANCE = this;
        configManager = ConfigManager.getInstance();
        configManager.setup();
        ConfigurationSerialization.registerClass(CustomSound.class, "CustomSound");
        ConfigurationSerialization.registerClass(CustomTitle.class , "CustomTitle");
        ConfigurationSerialization.registerClass(FishingReward.class, "FishingReward");
        langFileManager = LangFileManager.getInstance();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static OreoFishing get() {
        return INSTANCE;
    }

    public LangFileManager getLangFileManager() {
        return langFileManager;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
}
