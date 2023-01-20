package dk.kraften.jail;

import dk.kraften.jail.Command.Admin.JailAdminCommand;
import dk.kraften.jail.Configs.Configs;
import dk.kraften.jail.Configs.DataConfig;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private Configs configs;


    @Override
    public void onEnable() {
        // Plugin startup logic
        configs = new Configs(this);
        loadCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void loadCommands() {
        getCommand("jailadmin").setExecutor(new JailAdminCommand(configs));
    }
}
