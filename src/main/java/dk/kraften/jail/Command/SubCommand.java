package dk.kraften.jail.Command;

import org.bukkit.entity.Player;

public interface SubCommand {
    String argument();
    String permission();
    String syntax();
    void perform(Player player, String[] args);
}
