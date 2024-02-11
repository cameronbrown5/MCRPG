package me.thecamzone.events;

import me.thecamzone.utilities.PortalUtil;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import me.thecamzone.MCRPG;

public class OnPlayerInteract implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		ItemStack item = e.getItem();
		Block clickedBlock = e.getClickedBlock();

		if(item == null) { return; }

		if(clickedBlock == null) { return; }

		if(item.getType() == Material.STICK) {
			PortalUtil.testPortal(player, clickedBlock);
		}

		if(item.getType() == Material.BLAZE_ROD) {
			PortalUtil.ignitePortal(player, clickedBlock);
		}
	}
	
}
