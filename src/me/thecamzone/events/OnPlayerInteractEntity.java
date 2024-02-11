package me.thecamzone.events;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import me.thecamzone.MCRPG;

public class OnPlayerInteractEntity implements Listener {

	@EventHandler
	public void onPlayerInteractEntity(PlayerInteractEntityEvent e) {
		Player player = e.getPlayer();
		Entity otherEntity = e.getRightClicked();
		
		if(player.getInventory().getItemInMainHand().getType() == Material.NETHER_STAR) {
			
			ItemStack item = new ItemStack(Material.PIG_SPAWN_EGG);
			ItemMeta meta = item.getItemMeta();
			
			String otherEntityName = otherEntity.getCustomName();
			
			if(otherEntityName != null) {
				meta.setDisplayName(otherEntityName);
				
				PersistentDataContainer data = meta.getPersistentDataContainer();
				
				data.set(new NamespacedKey(MCRPG.plugin, "mcrpg"), PersistentDataType.STRING, "lasso");
				
				item.setItemMeta(meta);
				
				if(!player.getInventory().contains(item)) {
					player.getInventory().addItem(item);
				}
			}
		}
	}
	
}
