package me.thecamzone.gravestones;

import java.util.HashMap;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

public class GravestoneHolder {
  private static HashMap<Location, Gravestone> gravestoneLocations = new HashMap<>();
  
  public static void addGravestone(UUID uuid, Inventory inventory, Location location) {
    gravestoneLocations.put(location, new Gravestone(uuid, inventory));
  }
  
  public static Gravestone getGravestone(Location location) {
    return gravestoneLocations.get(location);
  }
  
  public static Inventory getGravestoneInventory(Location location) {
    return ((Gravestone)gravestoneLocations.get(location)).getInventory();
  }
}
