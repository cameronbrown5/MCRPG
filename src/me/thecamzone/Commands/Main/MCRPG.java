package me.thecamzone.Commands.Main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import dev.lone.itemsadder.api.CustomStack;
import me.thecamzone.Engine.Main;
import me.thecamzone.Utilities.CustomItems.ItemFactory;
import net.md_5.bungee.api.ChatColor;

public class MCRPG implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("mcrpg")) {
			
			if(sender.hasPermission("MCRPG.Admin")) {
				if(args.length == 0) {
					sender.sendMessage(ChatColor.WHITE + "-----------------");
					sender.sendMessage(ChatColor.GREEN + "MCRPG | Created by TheCamZone");
					sender.sendMessage(ChatColor.GRAY + "Commands:");
					sender.sendMessage(ChatColor.WHITE + "- " + ChatColor.GRAY + "/mcrpg");
					sender.sendMessage(ChatColor.WHITE + "- " + ChatColor.GRAY + "/mcrpg deleteGravestones");
					sender.sendMessage(ChatColor.WHITE + "- " + ChatColor.GRAY + "/mcrpg rollItem");
					sender.sendMessage(ChatColor.WHITE + "- " + ChatColor.GRAY + "/warp [location]");
					sender.sendMessage(ChatColor.WHITE + "- " + ChatColor.GRAY + "/setwarp <location>");
					sender.sendMessage(ChatColor.WHITE + "- " + ChatColor.GRAY + "/delwarp <location>");
					sender.sendMessage(ChatColor.WHITE + "-----------------");
					return true;
				}
				
				else if(args.length == 1) {
					if(args[0].equalsIgnoreCase("rollitem")) {
						sender.sendMessage(ChatColor.RED + "Incorrect syntax: /mcrpg rollitem <itemType>");
						return true;
					}
					
					if(args[0].equalsIgnoreCase("deleteGravestones")) {
						int counter = 0;
						
						for(World world : Bukkit.getWorlds()) {
							for(Entity entity : world.getEntities()) {
								if(entity.getPersistentDataContainer().has(new NamespacedKey(Main.plugin, "mcrpg.gravestone"), PersistentDataType.STRING)) {
									entity.remove();
									counter++;
								}
							}
						}
						
						Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Successfully removed " + counter + " gravestone(s)");
						
						return true;
					}
				}
				
				else if(args.length == 2) {
					if(args[0].equalsIgnoreCase("rollitem")) {
						if(!(sender instanceof Player)) {
							sender.sendMessage(ChatColor.RED + "You must be a player to run this command.");
						}
						Player player = (Player) sender;
						
						String[] splitNamespace = args[1].split(":");
						String namespace = splitNamespace[0];
						String type = splitNamespace[1];
						
						ItemStack item;
						
						if(!namespace.equalsIgnoreCase("minecraft")) {
							CustomStack stack = CustomStack.getInstance(args[1]);
							if(stack == null) {
								sender.sendMessage(ChatColor.RED + "Could not find an item with the name of " + args[1]);
								return true;
							} 
							
							item = ItemFactory.rollItem(stack.getItemStack(), args[1]);
						} else {
							item = ItemFactory.rollItem(new ItemStack(Material.valueOf(type.toUpperCase())), args[1]);
						}
						
						if(item == null) {
							sender.sendMessage(ChatColor.RED + "Item is not an upgradable item");
							return true;
						}
						
						player.getInventory().addItem(item);
						
						return true;
					}
				}
				
			}
		}
		
		return true;
	}

	
	
}
