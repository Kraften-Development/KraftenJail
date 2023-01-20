package dk.kraften.jail.Command.Admin.SubCommands;

import dk.kraften.jail.Command.SubCommand;
import dk.kraften.jail.Configs.Configs;
import dk.kraften.jail.Configs.DataConfig;
import dk.kraften.jail.Utils.ColorUtils;
import dk.kraften.jail.Utils.MessageUtils;
import dk.kraften.jail.Utils.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Reload implements SubCommand {

    private final Configs configs;

    public Reload(Configs configs) {
        this.configs = configs;
    }

    @Override
    public String argument() {
        return "reload";
    }

    @Override
    public String requiredPermission() {
        return "";
    }

    @Override
    public String syntax() {
        return "/jailadmin reload";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (args.length < 2) {
            return;
        }

        boolean reloadStatus = false;
        String response = "";
        switch (args[1].toLowerCase()) {
            case "config":
                reloadStatus = configs.getDataConfig().reloadConfig();
                break;
            case "locations":
                reloadStatus = configs.getLocationConfig().reloadConfig();
                break;
            default:
                response = "&7Kunne ikke finde en config med navnet &b<configName>";
                break;
        }
        if (response.isEmpty()) {
            try {
                response = reloadStatus ? configs.getDataConfig().getMessage("configReloadSuccess") : configs.getDataConfig().getMessage("configReloadError");
            } catch (Exception e) {
                response = "&7Noget gik galt.";
            }
        }
        player.sendMessage(MessageUtils.processPlaceholders(ColorUtils.prettify(configs.getDataConfig().getPrefix() + " " + response), new Placeholder("<configName>", args[1])));
    }
}
