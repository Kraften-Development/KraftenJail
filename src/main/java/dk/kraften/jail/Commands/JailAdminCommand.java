package dk.kraften.jail.Commands;

import dk.kraften.jail.CommandManagement.CommandManager;
import dk.kraften.jail.CommandManagement.SubCommand;
import dk.kraften.jail.Commands.JailAdminSubCommand.Reload;
import dk.kraften.jail.Commands.JailAdminSubCommand.SetLoc;
import dk.kraften.jail.Jail;
import dk.kraften.jail.Utils.ColorTranslator;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class JailAdminCommand {

    private Jail plugin = Jail.getInstance();

    public JailAdminCommand() {
        try {
            CommandManager.baseCommand(plugin, "jailadmin",
                    "JailAdmin Kommando", "/jailadmin",
                    Arrays.asList("jadm", "jailadm"), (sender, subCommands) -> {
                if (!(sender instanceof Player)) return;

                Player player = (Player) sender;

                player.sendMessage(ColorTranslator.string(" "));
                player.sendMessage(ColorTranslator.string("&8▏"));
                player.sendMessage(ColorTranslator.string("&f▏ &4&lJail Kommandoer"));
                player.sendMessage(ColorTranslator.string("&8▏"));

                for (SubCommand subCommand : subCommands) {
                    player.sendMessage(ColorTranslator.string("&f▏ &c" + subCommand.getSyntax()));
                    player.sendMessage(ColorTranslator.string("&f▏ &f▶ &7" + subCommand.getDescription()));
                }

                player.sendMessage(ColorTranslator.string("&8▏ &f"));
                player.sendMessage(ColorTranslator.string(" "));
            }, Reload.class, SetLoc.class);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
