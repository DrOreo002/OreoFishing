package me.droreo002.oreofishing;

import me.droreo002.oreofishing.manager.LangFileManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class OreoFishing extends JavaPlugin {

    private static OreoFishing INSTANCE;
    private LangFileManager langFileManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        INSTANCE = this;
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
}
