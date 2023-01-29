package dk.kraften.jail.Commands.JailAdminSubCommand;

import dk.kraften.jail.CommandManagement.SubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class SetLoc extends SubCommand {
    @Override
    public String getName() {
        return "setloc";
    }

    @Override
    public List<String> getAliases() {
        return null;
    }

    @Override
    public String getDescription() {
        return "Set a location";
    }

    @Override
    public String getSyntax() {
        return "/jailadmin setloc <c/b/a> <spawn/jail>";
    }

    @Override
    public String getPermission() {
        return null;
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        return;
    }

    @Override
    public List<String> getArguments(Player player, String[] args) {
        return null;
    }
}
