package me.thecamzone.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		
		if(!player.hasPermission("mcrpg.motd.bypass")) {
			
			Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "cc open welcome " + player.getName());
			
		}
	}
	
}
