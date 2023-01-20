package dk.kraften.jail.Command.Admin.SubCommands;

import dk.kraften.jail.Command.SubCommand;
import org.bukkit.entity.Player;

public class SetLoc implements SubCommand {
    @Override
    public String argument() {
        return "setloc";
    }

    @Override
    public String requiredPermission() {
        return "";
    }

    @Override
    public String syntax() {
        return "/jailadmin setloc <c/b/a> <spawn/jail>";
    }

    @Override
    public void perform(Player player, String[] args) {

    }
}
