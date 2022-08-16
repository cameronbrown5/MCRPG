package me.thecamzone.Commands.Warp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.thecamzone.Warps.Warps;
import net.md_5.bungee.api.ChatColor;

public class Delwarp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("Delwarp")) {
			if(sender.hasPermission("MCRPG.Delwarp")) {
				if(args.length == 1) {
					if(Warps.delWarp(args[0])) {
						sender.sendMessage(ChatColor.GREEN + "Successfully removed warp " + args[0] + "!");
					} else {
						sender.sendMessage(ChatColor.RED + "The warp " + args[0] + " does not exist.");
					}
				}
				
				else {
					sender.sendMessage(ChatColor.RED + "Incorrect Syntax: /delwarp <warpname>");
				}
			}
		}
		
		return true;
	}
	
}
