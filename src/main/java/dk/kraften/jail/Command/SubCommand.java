package dk.kraften.jail.Command;

import org.bukkit.entity.Player;

public interface SubCommand {
    String argument();
    String requiredPermission();
    String syntax();
    void perform(Player player, String[] args);
}
