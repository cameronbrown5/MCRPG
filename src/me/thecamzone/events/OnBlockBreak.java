package me.thecamzone.events;

import me.thecamzone.portals.Portal;
import me.thecamzone.portals.PortalHandler;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class OnBlockBreak implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Block block = e.getBlock();

//        if(!PortalHandler.getFrameIgnition().containsKey(block)) {
//            return;
//        }

        for(Portal portal : PortalHandler.getPortals().values()) {
            if(!portal.getFrameBlocks().contains(block)) {
                continue;
            }

            portal.destroy();
        }
    }
}
