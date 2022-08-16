package me.thecamzone.Commands.Warp;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.thecamzone.Warps.Warps;
import net.md_5.bungee.api.ChatColor;

public class Setwarp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("setwarp")) {
			if(sender.hasPermission("MCRPG.Setwarp")) {
				if(!(sender instanceof Player)) { Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "This command must be run by a player."); return true; }
				
				Player player = (Player) sender;
				
				if(args.length == 1) {
					Warps.addWarp(args[0], player.getLocation());
					
					sender.sendMessage(ChatColor.GREEN + "Warp " + args[0] + " has been set!");
				}
				
				else {
					sender.sendMessage(ChatColor.RED + "Incorrect Syntax: /setwarp <warpname>");
				}
			}
		}
		
		return true;
	}

}
