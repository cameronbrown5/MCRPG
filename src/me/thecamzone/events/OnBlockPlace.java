package me.thecamzone.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Campfire;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OnBlockPlace implements Listener {

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		handleHats(e);
		handleCampfire(e);
	}

	private void handleCampfire(BlockPlaceEvent e) {
		Block block = e.getBlockPlaced();

		if(!(block.getType() == Material.CAMPFIRE || block.getType() == Material.SOUL_CAMPFIRE)) {
			return;
		}

		Campfire campfire = (Campfire) block.getBlockData();
		campfire.setLit(false);
		block.setBlockData(campfire);
	}

	private void handleHats(BlockPlaceEvent e) {
		ItemStack item = e.getItemInHand();

		if(item.getItemMeta() == null) { return; }

		ItemMeta meta = item.getItemMeta();

		if(item.getType() == Material.CARVED_PUMPKIN && meta.hasCustomModelData()) {
			e.setCancelled(true);
		}
	}
	
}
