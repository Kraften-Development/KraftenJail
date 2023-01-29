package dk.kraften.jail.CommandManagement;

import dk.kraften.jail.Utils.ColorTranslator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseCommand extends Command {

    private final ArrayList<SubCommand> subCommands;
    private final CommandList commandList;

    protected BaseCommand(@NotNull String name, @NotNull String description, @NotNull String usageMessage, @NotNull List<String> aliases, ArrayList<SubCommand> subCommands, CommandList commandList) {
        super(name, description, usageMessage, aliases);

        this.subCommands = subCommands;
        this.commandList = commandList;
    }

    public ArrayList<SubCommand> getSubCommands() {
        return subCommands;
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {

        if (args.length <= 0) {

            if (commandList != null) {
                commandList.displayCommandList(sender, subCommands);
                return true;
            }

            sender.sendMessage(ColorTranslator.string("&f&m----------------------------&r"));

            for (SubCommand subCommand : subCommands) {
                sender.sendMessage(ColorTranslator.string("&e" + subCommand.getSyntax() + " &f" + subCommand.getDescription()));
            }

            sender.sendMessage(ColorTranslator.string("&f&m----------------------------&r"));

            return true;
        }

        for (int i = 0; i < getSubCommands().size(); i++) {

            if (!args[0].equalsIgnoreCase(getSubCommands().get(i).getName()) || (getSubCommands().get(i).getAliases() == null || !getSubCommands().get(i).getAliases().contains(args[0])))
                continue;

            getSubCommands().get(i).perform(sender, args);
        }

        return true;
    }

    @Override
    public @NotNull List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, String[] args) throws IllegalArgumentException {
        if (args.length == 1) {
            ArrayList<String> subcommandsArguments = new ArrayList<>();

            for (int i = 0; i < getSubCommands().size(); i++) {
                subcommandsArguments.add(getSubCommands().get(i).getName());
            }
            return subcommandsArguments;
        } else if (args.length >= 2) {
            for (int i = 0; i < getSubCommands().size(); i++) {
                if (args[0].equalsIgnoreCase(getSubCommands().get(i).getName())) {
                    List<String> subCommandArgs = getSubCommands().get(i).getArguments(
                            (Player) sender, args
                    );

                    if (subCommandArgs != null)
                        return subCommandArgs;

                    return Collections.emptyList();
                }
            }
        }

        return Collections.emptyList();
    }
}
