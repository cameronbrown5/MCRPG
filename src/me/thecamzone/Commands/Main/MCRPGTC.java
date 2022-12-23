package me.thecamzone.Commands.Main;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import me.thecamzone.Utilities.CustomItems.ItemFactory;

public class MCRPGTC implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		
		if(command.getName().equalsIgnoreCase("mcrpg")) {
			if(args.length == 1) {
				return Arrays.asList("help", "deleteGravestones", "rollitem");
			}
			
			if(args.length == 2) {
				if(args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("deleteGravestones")) {
					return Arrays.asList("");
				}
				
				else if(args[0].equalsIgnoreCase("rollitem")) {
					return ItemFactory.getAttributableItems();
				}
			}
		}
		return null;
	}

}
