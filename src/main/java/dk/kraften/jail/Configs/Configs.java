package dk.kraften.jail.Configs;

import org.bukkit.plugin.Plugin;

public class Configs {
    private DataConfig dataConfig;
    private LocationConfig locationConfig;


    public Configs(Plugin plugin) {
        dataConfig = new DataConfig();
        dataConfig.initConfig(plugin);
        locationConfig = new LocationConfig();
        locationConfig.initConfig(plugin);
    }

    public DataConfig getDataConfig() {
        return dataConfig;
    }

    public LocationConfig getLocationConfig() {
        return locationConfig;
    }
}
