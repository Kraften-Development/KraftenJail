package dk.kraften.jail.CommandManagement;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public abstract class SubCommand {

    /**
     * @return String (Navn)
     */
    public abstract String getName();

    /**
     * @return String list (Alias)
     */
    public abstract List<String> getAliases();

    /**
     * @return String (Beskrivelse)
     */
    public abstract String getDescription();

    /**
     * @return String (Syntax)
     */
    public abstract String getSyntax();

    /**
     * @return String (Permission)
     */
    public abstract String getPermission();

    /**
     * @param sender Tingen der aktivere kommandoen!
     * @param args   Argumenterne til kommandoen
     */
    public abstract void perform(CommandSender sender, String[] args);

    public abstract List<String> getArguments(Player player, String[] args);
}

