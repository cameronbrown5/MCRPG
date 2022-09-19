package me.thecamzone.Events;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import me.thecamzone.Engine.Main;

public class OnPlayerInteract implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		ItemStack item = e.getItem();
		
		if(item == null) { return; }
		
		ItemMeta meta = item.getItemMeta();
		PersistentDataContainer data = meta.getPersistentDataContainer();
		
		if(data.has(new NamespacedKey(Main.plugin, "mcrpg"), PersistentDataType.STRING)) {
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				e.setCancelled(true);
				player.sendMessage("This is a custom item");
			}
		}
	}
	
}
