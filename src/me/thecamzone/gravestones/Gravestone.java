package me.thecamzone.gravestones;

import java.util.UUID;
import org.bukkit.inventory.Inventory;

public class Gravestone {
  private UUID uuid;
  
  private Inventory inventory;
  
  public Gravestone(UUID uuid, Inventory inventory) {
    this.uuid = uuid;
    this.inventory = inventory;
  }
  
  public UUID getUniqueID() {
    return this.uuid;
  }
  
  public Inventory getInventory() {
    return this.inventory;
  }
}
