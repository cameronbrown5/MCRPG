package me.thecamzone.Commands.Warp;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thecamzone.Warps.Warps;
import net.md_5.bungee.api.ChatColor;

public class Warp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("warp")) {
			if(sender.hasPermission("MCRPG.Warp")) {
				if(!(sender instanceof Player)) { Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "This command must be run by a player."); return true; }
				
				Player player = (Player) sender;
				
				if(args.length == 0) {
					if(Warps.getWarps().size() == 0) {
						sender.sendMessage(ChatColor.WHITE + "No available warps.");
						return true;
					}
					
					sender.sendMessage(ChatColor.GREEN + "List of available warps:");
					
					for(String string : Warps.getWarps()) {
						sender.sendMessage(ChatColor.WHITE + "  - " + ChatColor.GRAY + string);
					}
					
					return true;
				}
				
				else if(args.length == 1) {
					if(Warps.getWarp(args[0]) == null) {
						player.sendMessage(ChatColor.RED + "The warp " + args[0] + " does not exist.");
					} else {
						player.sendMessage(ChatColor.GREEN + "Warping to " + args[0] + "!");
						player.teleport(Warps.getWarp(args[0]));
					}
					
					return true;
				}
				
				else {
					sender.sendMessage(ChatColor.RED + "Incorrect Syntax: /warp <warpname>");
					return true;
				}
			}
		}
		
		return true;
	}
	
}
