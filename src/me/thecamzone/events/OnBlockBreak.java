package me.thecamzone.events;

import com.jeff_media.customblockdata.CustomBlockData;
import com.jeff_media.morepersistentdatatypes.DataType;
import me.thecamzone.MCRPG;
import me.thecamzone.portals.Portal;
import me.thecamzone.portals.PortalHandler;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class OnBlockBreak implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Block block = e.getBlock();

//        if(!PortalHandler.getFrameIgnition().containsKey(block)) {
//            return;
//        }

        PersistentDataContainer customBlockData = new CustomBlockData(block, MCRPG.plugin);
        Bukkit.getConsoleSender().sendMessage("Calling block break.");

        for(NamespacedKey key : customBlockData.getKeys()) {
            UUID uuid;
            try {
                uuid = UUID.fromString(key.getKey());
            } catch(IllegalArgumentException ignored) {
                Bukkit.getConsoleSender().sendMessage("Not a uuid.");
                continue;
            }

            Location[] locations = customBlockData.get(key, DataType.LOCATION_ARRAY);
            if(locations == null) {
                Bukkit.getConsoleSender().sendMessage("Found a uuid, but does not have a list of locations.");
                continue;
            }

            for(Location location : locations) {
                Collection<Entity> entities = location.getWorld().getNearbyEntities(location, 0.5, 0.5, 0.5);

                for(Entity entity : entities) {
                    if(!(entity instanceof BlockDisplay)) {
                        Bukkit.getConsoleSender().sendMessage("Found an entity at a portal position, but it was not a display block.");
                        continue;
                    }

                    BlockDisplay display = (BlockDisplay) entity;
                    display.remove();
                }
            }
        }
//        for(Portal portal : PortalHandler.getPortals().values()) {
//            if(!portal.getFrameBlocks().contains(block)) {
//                continue;
//            }
//
//            portal.destroy();
//        }
    }
}
