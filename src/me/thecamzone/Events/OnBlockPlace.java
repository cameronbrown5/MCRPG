package me.thecamzone.Events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OnBlockPlace implements Listener {

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		if(e.getItemInHand() == null) { return; }
		
		ItemStack item = e.getItemInHand();
		
		if(item.getItemMeta() == null) { return; }
		
		ItemMeta meta = item.getItemMeta();
		
		if(item.getType() == Material.CARVED_PUMPKIN && meta.hasCustomModelData()) {
			e.setCancelled(true);
		}
	}
	
}
