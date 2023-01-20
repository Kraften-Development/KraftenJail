package dk.kraften.jail.Models;

import org.bukkit.Location;

public class JailLocation {
    private Location jailLocation;
    private Location spawnLocation;

    public JailLocation(Location jailLoc, Location spawnLoc) {
        this.jailLocation = jailLoc;
        this.spawnLocation = spawnLoc;
    }

    public JailLocation() {

    }

    public Location getJailLocation() {
        return jailLocation;
    }

    public Location getSpawnLocation() {
        return spawnLocation;
    }

    public void setJailLocation(Location jailLocation) {
        this.jailLocation = jailLocation;
    }

    public void setSpawnLocation(Location spawnLocation) {
        this.spawnLocation = spawnLocation;
    }
}
