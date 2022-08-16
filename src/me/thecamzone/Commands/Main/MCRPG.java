package me.thecamzone.Commands.Main;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class MCRPG implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("mcrpg")) {
			if(sender.hasPermission("MCRPG.Admin")) {
				sender.sendMessage(ChatColor.WHITE + "-----------------");
				sender.sendMessage(ChatColor.GREEN + "MCRPG | Created by TheCamZone");
				sender.sendMessage(ChatColor.GRAY + "Commands:");
				sender.sendMessage(ChatColor.WHITE + "- " + ChatColor.GRAY + "/mcrpg");
				sender.sendMessage(ChatColor.WHITE + "- " + ChatColor.GRAY + "/warp [location]");
				sender.sendMessage(ChatColor.WHITE + "- " + ChatColor.GRAY + "/setwarp <location>");
				sender.sendMessage(ChatColor.WHITE + "- " + ChatColor.GRAY + "/delwarp <location>");
				sender.sendMessage(ChatColor.WHITE + "-----------------");
			}
		}
		
		return true;
	}

	
	
}
