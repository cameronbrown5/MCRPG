package me.thecamzone.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.PlayerInventory;

public class OnEntityDamage implements Listener {

	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		
		if(!(e.getEntity() instanceof Player)) { return; }
		
		Player player = (Player) e.getEntity();
		PlayerInventory inventory = player.getInventory();
		
		if(!(inventory.getItemInMainHand().getType() == Material.TOTEM_OF_UNDYING || inventory.getItemInOffHand().getType() == Material.TOTEM_OF_UNDYING)) { return; }
		
		Double damage = e.getDamage();
		if(damage > player.getHealth()) {
			
		}
		
		
		
	}
	
}
