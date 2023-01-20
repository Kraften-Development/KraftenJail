package dk.kraften.jail.Configs;

import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataConfig extends BaseConfig {

    private String prefix = "";
    private HashMap<String, String> messages = new HashMap<>();
    private HashMap<String, String> announces = new HashMap<>();
    private List<String> blockedCommands = new ArrayList<>();

    public DataConfig() {
        super("config.yml", "config.yml", true);
    }

    public void initConfig(Plugin plugin) {
        if(createFile(plugin)) {
            reloadConfig();
        } else if (fileExists()) {
            reloadConfig();
        }
    }

    public boolean reloadConfig() {
        if (reload()) {
            try {
                prefix = getString("Prefix");
                messages = getStringHashMap("Messages");
                announces = getStringHashMap("Announces");
                blockedCommands = getStringList("BlockedCommands");
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public String getPrefix() {
        return prefix;
    }

    public String getMessage(String key) {
        return messages.get(key);
    }

    public HashMap<String, String> getMessages() {
        return messages;
    }
}
