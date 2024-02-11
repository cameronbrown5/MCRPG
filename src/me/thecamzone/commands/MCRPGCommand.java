package me.thecamzone.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import me.thecamzone.campfires.HealthUtil;
import me.thecamzone.utilities.StringUtil;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;

@CommandAlias("mcrpg")
public class MCRPGCommand extends BaseCommand {

    @Default
    @Subcommand("default")
    public void onDefault(CommandSender sender) {
        sender.sendMessage(StringUtil.color("&aMCRPG &7- Created by TheCamZone"));
    }

    @Subcommand("help")
    public void onHelp(CommandSender sender) {
        sender.sendMessage(StringUtil.color("-----------------"));
        sender.sendMessage(StringUtil.color("&aCommands:"));
        sender.sendMessage(StringUtil.color("&f- /mcrpg help &7- Shows this message"));
        sender.sendMessage(StringUtil.color("&f- /mcrpg help &7- Shows this message"));
        sender.sendMessage(StringUtil.color("&f- /warp [location] &7- Warps to a location"));
        sender.sendMessage(StringUtil.color("&f- /setwarp <location> &7- Adds a location to warp to."));
        sender.sendMessage(StringUtil.color("&f- /delwarp <location> &7- Deletes a warp location"));
        sender.sendMessage(ChatColor.WHITE + "-----------------");
    }

    @Subcommand("setmaxhealth")
    public void onSetHealth(CommandSender sender, OnlinePlayer player, Double amount) {
        HealthUtil.setPlayerMaxHealth(player.getPlayer(), amount, true);
        sender.sendMessage(StringUtil.color("&aSet " + player.getPlayer().getName() + "'s health to " + amount));
    }

}
