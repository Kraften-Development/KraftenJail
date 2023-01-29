package dk.kraften.jail.CommandManagement;

import org.bukkit.command.CommandSender;

import java.util.List;

public interface CommandList {

    /**
     * @param sender      Tingen der aktivere kommandoen.
     * @param subCommands Liste af alle subcommands fra kommandoen.
     * @since
     */
    void displayCommandList(CommandSender sender, List<SubCommand> subCommands);
}
