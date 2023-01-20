package dk.kraften.jail.Command.Admin;

import dk.kraften.jail.Command.Admin.SubCommands.Reload;
import dk.kraften.jail.Command.SubCommand;
import dk.kraften.jail.Configs.Configs;
import dk.kraften.jail.Utils.ColorUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class JailAdminCommand implements CommandExecutor {

    private final ArrayList<SubCommand> subCommands = new ArrayList<>();
    private final Configs configs;

    public JailAdminCommand(Configs configs) {
        this.configs = configs;
        subCommands.add(new Reload(this.configs));
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {return true;}
        Player player = (Player)sender;

        if (!player.isOp()) {
            player.sendMessage(ColorUtils.prettify("&7Du har ikke adgang til jail admin kommandoer."));
            return true;
        }

        if (args.length == 0) {
            return true;
        }

        for (SubCommand subCommand : subCommands) {
            if (subCommand.argument().equalsIgnoreCase(args[0])) {
                subCommand.perform(player, args);
                return true;
            }
        }



        return true;
    }
}
