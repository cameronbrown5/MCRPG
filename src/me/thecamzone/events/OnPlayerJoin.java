package me.thecamzone.events;

import me.thecamzone.utilities.files.DataFile;
import me.thecamzone.campfires.HealthUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();

		if(!DataFile.get().contains("player-info." + player.getUniqueId())) {
			HealthUtil.setPlayerMaxHealth(player, 10D, true);
		}

		if(!player.hasPermission("mcrpg.motd.bypass")) {
			Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "cc open welcome " + player.getName());
		}
	}
	
}
