package me.thecamzone.utilities;

import org.bukkit.ChatColor;

public class StringUtil {

    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

}
