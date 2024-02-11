package me.thecamzone.events;

import me.thecamzone.campfires.HealthUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class OnEntityRegainHealth implements Listener {
    @EventHandler
    public void onEntityChangeHealth(EntityRegainHealthEvent e) {
        if(!(e.getEntity() instanceof Player)) {
            return;
        }

        Player player = (Player) e.getEntity();
        EntityRegainHealthEvent.RegainReason reason = e.getRegainReason();

        if(reason == EntityRegainHealthEvent.RegainReason.REGEN || reason == EntityRegainHealthEvent.RegainReason.SATIATED) {
            if(player.getHealth() >= HealthUtil.getDefaultRegenMax()) {
                e.setCancelled(true);
            }
        }
    }
}
