package me.thecamzone.Commands.Warp;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import me.thecamzone.Warps.Warps;

public class WarpTC implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if(command.getName().equalsIgnoreCase("Warp") || command.getName().equalsIgnoreCase("Delwarp")) {
			if(args.length == 0) {
				return Arrays.asList("");
			}
			
			if(args.length == 1) {
				return Warps.getWarps();
			}
		}
		return null;
	}
	
}
