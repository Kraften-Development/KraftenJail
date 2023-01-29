package dk.kraften.jail;

import dk.kraften.jail.Commands.JailAdminCommand;
import dk.kraften.jail.Configs.Configs;
import dk.kraften.jail.Configs.DataConfig;
import dk.kraften.jail.Configs.LocationConfig;
import dk.kraften.jail.Managers.LocationManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Jail extends JavaPlugin {

    private static DataConfig dataConfig;
    private static LocationConfig locationConfig;
    private static LocationManager locationManager;
    private static Jail instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        loadConfigs();
        locationManager = new LocationManager(locationConfig);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Jail getInstance() {
        return instance;
    }

    public static LocationManager getLocationManager() {
        return locationManager;
    }

    public static DataConfig getDataConfig() {
        return dataConfig;
    }

    private void loadConfigs() {
        dataConfig = new DataConfig();
        locationConfig = new LocationConfig();
    }

    private void loadCommands() {
        new JailAdminCommand();
    }
}
