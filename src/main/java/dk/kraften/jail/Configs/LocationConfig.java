package dk.kraften.jail.Configs;

import dk.kraften.jail.Models.JailLocation;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class LocationConfig extends BaseConfig {

    private HashMap<String, JailLocation> jailLocations = new HashMap<>();

    public LocationConfig() {
        super("jailLocations", "jailLocations.yml", true);
    }

    public void initConfig(Plugin plugin) {
        if(createFile(plugin)) {
            reloadConfig();
        } else if (fileExists()) {
            reloadConfig();
        }
    }

    public void setLoc(String jail, String option, Location location) {
        set("locations." + jail + "." + option, location);
        save();
    }

    public boolean reloadConfig() {
        if (reload()) {
            try {
                jailLocations = getJailLocationsFromFile();
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    private HashMap<String, JailLocation> getJailLocationsFromFile() {
        HashMap<String, JailLocation> temp = new HashMap<>();
        FileConfiguration configuration = getConfiguration();
        if (configuration.isConfigurationSection("locations") || configuration.getConfigurationSection("locations") != null) {
            configuration.getConfigurationSection("locations").getKeys(false).forEach(key -> {
                Location jailLoc = (Location)configuration.get("locations." + key + ".jailLocation");
                Location spawnLoc = (Location)configuration.get("locations." + key + ".spawnLocation");
                temp.put(key, new JailLocation(jailLoc, spawnLoc));
            });
        }
        return temp;
    }
}
