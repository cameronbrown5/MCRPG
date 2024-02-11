package me.thecamzone.events;

import me.thecamzone.campfires.CampfireHandler;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Campfire;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;

public class OnBlockIgnite implements Listener {
    @EventHandler
    public void onBlockIgnite(BlockIgniteEvent e) {
        Block block = e.getBlock();

        if(block.getType() == Material.CAMPFIRE) {
            Campfire campfire = (Campfire) block.getState();
            CampfireHandler.handleIgnition(campfire);
        }
    }

}
