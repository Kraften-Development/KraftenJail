package dk.kraften.jail.Managers;

import dk.kraften.jail.Configs.Configs;
import dk.kraften.jail.Configs.LocationConfig;
import dk.kraften.jail.Models.JailLocation;

import java.util.HashMap;

public class LocationManager {

    private final LocationConfig locationConfig;
    private static HashMap<String, JailLocation> jailLocations = new HashMap<>();

    public LocationManager(LocationConfig locationConfig) {
        this.locationConfig = locationConfig;
    }

    public boolean reload() {
        return locationConfig.reloadConfig();
        //Reload data
    }




}
