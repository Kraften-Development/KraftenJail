package dk.kraften.jail.CommandManagement;

import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CommandManager {

    @SafeVarargs
    public static void baseCommand(JavaPlugin plugin,
                                   String name,
                                   String description,
                                   String usage, List<String> aliases,
                                   @Nullable CommandList commandList,
                                   Class<? extends SubCommand>... subCommands) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<SubCommand> commands = new ArrayList<>();

        Arrays.stream(subCommands).map(subcommand -> {
            try {
                Constructor<? extends SubCommand> constructor = subcommand.getConstructor();
                return constructor.newInstance();
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        }).forEach(commands::add);

        Field commandField = plugin.getServer().getClass().getDeclaredField("commandMap");
        commandField.setAccessible(true);
        CommandMap commandMap = (CommandMap) commandField.get(plugin.getServer());
        commandMap.register(name, new BaseCommand(name, description, usage, aliases, commands, commandList));
    }

    @SafeVarargs
    public static void baseCommand(JavaPlugin plugin, String commandName,
                                   String commandDescription,
                                   String commandUsage,
                                   @Nullable CommandList commandList,
                                   Class<? extends SubCommand>... subcommands) throws NoSuchFieldException, IllegalAccessException {
        baseCommand(plugin, commandName, commandDescription, commandUsage, Collections.singletonList(""), commandList, subcommands);
    }
}
