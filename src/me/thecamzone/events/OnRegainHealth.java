package me.thecamzone.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class OnRegainHealth implements Listener {
  @EventHandler
  public void onRegainHealthEvent(EntityRegainHealthEvent e) {
    if (!(e.getEntity() instanceof org.bukkit.entity.Player))
      return; 
    if (e.getRegainReason() == EntityRegainHealthEvent.RegainReason.SATIATED)
      e.setCancelled(true); 
  }
}
