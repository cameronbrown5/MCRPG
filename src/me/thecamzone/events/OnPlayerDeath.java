package me.thecamzone.events;

import java.util.UUID;
import me.thecamzone.gravestones.GravestoneHolder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;

public class OnPlayerDeath implements Listener {
  @EventHandler
  public void onPlayerDeath(PlayerDeathEvent e) {
    Player player = e.getEntity();
    UUID playerUUID = player.getUniqueId();
    Location playerLoc = player.getLocation();
    PlayerInventory playerInventory = player.getInventory();
    if ((playerInventory.getContents()).length < 9)
      GravestoneHolder.addGravestone(playerUUID, (Inventory)playerInventory, playerLoc); 
    if (playerLoc.getBlock().getType() == Material.AIR) {
      Block block = playerLoc.getBlock();
      block.setType(Material.CHEST);
    } 
  }
}
