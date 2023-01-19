package dk.kraften.jail.Configs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

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

    protected String createFile(Plugin plugin) {
        file = new File(plugin.getDataFolder(), filePath);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            if (isResource) {
                plugin.saveResource(filePath, false);
            } else {
                try {
                    if(file.createNewFile()) {
                        return "fileCreateSuccess";
                    }
                } catch (IOException e) {
                    return "fileCreateError";
                }
            }
        }
        return "fileExists";
    }

    protected String deleteFile() {
        if(file.delete()) {
            return "fileDeleteSuccess";
        } else {
            return "fileDeleteError";
        }
    }

    protected String reload() {
        try {
            configuration = YamlConfiguration.loadConfiguration(file);
            return "configLoadSuccess";
        } catch (Exception e) {
            return "configLoadError";
        }
    }

    protected String getString(String keyPath) {
        return configuration.getString(keyPath);
    }

    protected int getInt(String keyPath) {
        return configuration.getInt(keyPath);
    }

}
