package me.thecamzone.events;

import me.thecamzone.gravestones.GravestoneHolder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class OnInteract implements Listener {
  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent e) {
    Player player = e.getPlayer();
    Block block = e.getClickedBlock();
    Location blockLoc = block.getLocation();
    if (block.getType() == Material.AIR)
      return; 
    if (block.getType() == Material.CHEST) {
      if (GravestoneHolder.getGravestoneInventory(blockLoc) == null)
        return; 
      e.setCancelled(true);
      player.openInventory(GravestoneHolder.getGravestoneInventory(blockLoc));
    } 
  }
}
