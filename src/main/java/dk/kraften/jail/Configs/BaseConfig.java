package dk.kraften.jail.Configs;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public abstract class BaseConfig {
    private String filePath;
    private String fileName;
    private boolean isResource;
    private File file;
    private FileConfiguration configuration;

    public BaseConfig(String fileName, String filePath, boolean isResource) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.isResource = isResource;
    }

    protected boolean createFile(Plugin plugin) {
        file = new File(plugin.getDataFolder(), filePath);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            if (isResource) {
                plugin.saveResource(filePath, false);
            } else {
                try {
                    if(file.createNewFile()) {
                        return true;
                    }
                } catch (IOException e) {
                    return false;
                }
            }
        }
        return false;
    }

    protected String deleteFile() {
        if(file.delete()) {
            return "fileDeleteSuccess";
        } else {
            return "fileDeleteError";
        }
    }

    protected boolean reload() {
        try {
            configuration = YamlConfiguration.loadConfiguration(file);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean save() {
        try {
            configuration.save(file);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean fileExists() {
        return file.exists();
    }

    protected FileConfiguration getConfiguration() {
        return this.configuration;
    }

    protected void set(String path, Object value) {
        configuration.set(path, value);
    }

    protected String getString(String keyPath) {
        return configuration.getString(keyPath);
    }

    protected int getInt(String keyPath) {
        return configuration.getInt(keyPath);
    }

    protected HashMap<String, String> getStringHashMap(String keyPath) {
        HashMap<String, String> map = new HashMap<>();
        for (String key : configuration.getConfigurationSection(keyPath).getKeys(false)) {
            String value = configuration.getString(keyPath + "." + key);
            map.put(key, value);
        }
        return map;
    }

    protected List<String> getStringList(String keyPath) {
        return configuration.getStringList(keyPath);
    }

}
