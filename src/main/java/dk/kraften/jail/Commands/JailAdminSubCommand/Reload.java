package dk.kraften.jail.Commands.JailAdminSubCommand;

import dk.kraften.jail.CommandManagement.SubCommand;
import dk.kraften.jail.Configs.Configs;
import dk.kraften.jail.Configs.DataConfig;
import dk.kraften.jail.Jail;
import dk.kraften.jail.Managers.LocationManager;
import dk.kraften.jail.Utils.ColorUtils;
import dk.kraften.jail.Utils.MessageUtils;
import dk.kraften.jail.Utils.Placeholder;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class Reload extends SubCommand {

    private final LocationManager locationManager;
    private final DataConfig dataConfig;

    public Reload() {
        this.locationManager = Jail.getLocationManager();
        this.dataConfig = Jail.getDataConfig();
    }

    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public List<String> getAliases() {
        return null;
    }

    @Override
    public String getDescription() {
        return "Reload en specifik config";
    }

    @Override
    public String getSyntax() {
        return "/jailadmin reload (config navn)";
    }

    @Override
    public String getPermission() {
        return null;
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) return;

        Player player = (Player) sender;

        if (args.length < 2) {
            return;
        }

        boolean reloadStatus = false;
        String response = "";
        switch (args[1].toLowerCase()) {
            case "config":
                reloadStatus = Jail.getDataConfig().reloadConfig();
                break;
            case "locations":
                reloadStatus = locationManager.reload();
                break;
            default:
                response = "&7Kunne ikke finde en config med navnet &b<configName>";
                break;
        }
        if (response.isEmpty()) {
            try {
                response = reloadStatus ? dataConfig.getMessage("configReloadSuccess") : dataConfig.getMessage("configReloadError");
            } catch (Exception e) {
                response = "&7Noget gik galt.";
            }
        }
        player.sendMessage(MessageUtils.processPlaceholders(ColorUtils.prettify(dataConfig.getPrefix() + " " + response), new Placeholder("<configName>", args[1])));
    }

    @Override
    public List<String> getArguments(Player player, String[] args) {
        return null;
    }
}
