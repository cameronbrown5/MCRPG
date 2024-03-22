package me.thecamzone.portals;

import me.thecamzone.MCRPG;
import me.thecamzone.utilities.DirectionUtil;
import org.bukkit.*;
import org.bukkit.block.Block;

import java.util.*;

public class PortalUtil {

    private static void getPortalBlocks(int iteration, Block block, Axis axis, List<Block> visited, Set<Location> insideFrame, Set<Block> frame, boolean isFirst) {
        if(iteration >= 2000) {
            throw new RuntimeException("Portal is too big.");
        }

        List<Block> nearbyBlocks = new ArrayList<>();

        if(axis == Axis.X) {
            // Top
            nearbyBlocks.add(block.getRelative(0,1,0));

            // Left
            nearbyBlocks.add(block.getRelative(-1,0,0));

            // Right
            nearbyBlocks.add(block.getRelative(1,0,0));

            // Bottom
            nearbyBlocks.add(block.getRelative(0,-1,0));
        } else {
            // Top
            nearbyBlocks.add(block.getRelative(0,1,0));

            // Left
            nearbyBlocks.add(block.getRelative(0,0,-1));

            // Right
            nearbyBlocks.add(block.getRelative(0,0,1));

            // Bottom
            nearbyBlocks.add(block.getRelative(0,-1,0));
        }

        for(Block nearbyBlock : nearbyBlocks) {
            if(nearbyBlock.getType() != Material.OBSIDIAN && nearbyBlock.getType() != Material.AIR) {
                throw new RuntimeException("Block is not air or obsidian");
            }

            if(visited.contains(nearbyBlock)) {
                continue;
            }

            if(nearbyBlock.getType() == Material.OBSIDIAN) {
                frame.add(nearbyBlock);
                continue;
            }

            insideFrame.add(nearbyBlock.getLocation());

            visited.add(nearbyBlock);

            getPortalBlocks(++iteration, nearbyBlock, axis, visited, insideFrame, frame, false);
        }

    }

    public static void createPortal(Block block, Axis axis, boolean debug, boolean isFirst) {
        Bukkit.getScheduler().runTaskAsynchronously(MCRPG.plugin, () -> {
            for(Portal portal : PortalHandler.getPortals().values()) {
                if(portal.getInsideLocations().contains(block)) {
                    return;
                }
            }

            Set<Location> insideLocations = new HashSet<>();
            Set<Block> frameBlocks = new HashSet<>();

            try {
                PortalUtil.getPortalBlocks(
                        0,
                        block,
                        axis,
                        new ArrayList<>(),
                        insideLocations,
                        frameBlocks,
                        true
                );
            } catch (RuntimeException exception) {
                if(debug)
                    System.out.println("Not a valid portal in " + axis.name() + " direction: " + exception.getMessage());
                if(isFirst) {
                    createPortal(block, DirectionUtil.oppositeAxis(axis), debug, false);
                }
                return;
            }

            if(insideLocations.isEmpty() || frameBlocks.isEmpty()) {
                if(isFirst) {
                    createPortal(block, DirectionUtil.oppositeAxis(axis), debug, false);
                }
                return;
            }

            Portal portal = new Portal(axis, insideLocations, frameBlocks);

            Bukkit.getScheduler().runTaskLater(MCRPG.plugin, () -> {
                PortalHandler.addPortal(portal.getUuid(), portal);
                portal.ignite();
            }, 1);
        });
    }

}

