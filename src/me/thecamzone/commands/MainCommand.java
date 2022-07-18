package me.thecamzone.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import net.md_5.bungee.api.ChatColor;

public class MainCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!command.getName().equalsIgnoreCase("mcrpg")) return true;
		
		if(args.length == 0) {
			sender.sendMessage(ChatColor.WHITE + "-----------------");
			sender.sendMessage(ChatColor.GREEN + "MCRPG | Created by TheCamZone");
			sender.sendMessage(ChatColor.GRAY + "Type '/mcrpg help' for help.");
			sender.sendMessage(ChatColor.WHITE + "-----------------");
		}
			
		if(args.length > 0) {
			if(args[0].equalsIgnoreCase("help")) {
				sender.sendMessage(ChatColor.GRAY + "Commands:");
				sender.sendMessage(ChatColor.WHITE + "- " + ChatColor.GRAY + "/mcrpg help");
			}
			
			
		}
		
		return true;
	}

}
