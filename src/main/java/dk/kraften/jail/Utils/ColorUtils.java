package dk.kraften.jail.Utils;

import net.md_5.bungee.api.ChatColor;

import java.awt.*;

@SuppressWarnings("deprecation")
public class ColorUtils {


    public static String prettify(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }

    public static String applyCustomColor(String str, int a, int b, int c) {
        return ChatColor.of(new Color(a,b,c)) + str;
    }
}
