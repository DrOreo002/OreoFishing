package me.droreo002.oreofishing.manager;

import me.droreo002.oreofishing.OreoFishing;
import org.apache.commons.lang.NullArgumentException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class LangFileManager {

    private OreoFishing plugin = OreoFishing.get();
    private File file;
    private FileConfiguration config;
    private static LangFileManager instance;

    private LangFileManager() {
        setup();
    }

    public static LangFileManager getInstance() {
        if (instance == null) {
            instance = new LangFileManager();
            return instance;
        }
        return instance;
    }

    private void setup() {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }
        File enFile = new File(plugin.getDataFolder(), "lang.yml");
        if (!enFile.exists()) {
            try {
                enFile.createNewFile();
                plugin.saveResource("lang.yml", true);
            } catch (IOException e) {
                // Ignore
            }
        }
        file = enFile;
        config = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getLangFile()
    {
        if (config == null) {
            reloadLangFile();
        }
        return config;
    }

    public void saveLangFile()
    {
        if (config == null) {
            throw new NullArgumentException("Cannot save a non-existant file!");
        }
        try
        {
            config.save(file);
        }
        catch (IOException e)
        {
            Bukkit.getServer().getLogger().log(Level.SEVERE, "Could not save " + file + ".", e);
        }
    }

    public void reloadLangFile() {
        file = new File(plugin.getDataFolder(), "lang.yml");
        config = YamlConfiguration.loadConfiguration(file);
        InputStream configData = plugin.getResource("lang.yml");
        if (configData != null) {
            config.setDefaults(YamlConfiguration.loadConfiguration(new InputStreamReader(configData)));
        }
    }
}
