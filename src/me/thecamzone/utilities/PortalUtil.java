package me.thecamzone.utilities;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.*;

public class PortalUtil {

    private static final BlockFace[] axis = { BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST };

    public static BlockFace yawToFacing(float yaw) {
        return axis[Math.round(yaw / 90f) & 0x3].getOppositeFace();
    }

    public static boolean isValidPortal(Block block, Block starting, Axis axis, Set<Block> alreadyFound, boolean isFirst) {
        if(alreadyFound == null) alreadyFound = new HashSet<>();
        
        if(block.getLocation().equals(starting.getLocation()) && !isFirst) return true;

        final Set<Block> checked = alreadyFound;

        if(axis == Axis.X) {
            final Block[] nearbyBlocks = Arrays.stream(new Block[]{
                    block.getLocation().add(1,0,0).getBlock(),
                    block.getLocation().add(1,1,0).getBlock(),
                    block.getLocation().add(1,-1,0).getBlock(),
                    block.getLocation().add(0,1,0).getBlock(),
                    block.getLocation().add(0,-1,0).getBlock(),
                    block.getLocation().add(-1,0,0).getBlock(),
                    block.getLocation().add(-1,1,0).getBlock(),
                    block.getLocation().add(-1,-1,0).getBlock()
            }).filter(b -> !checked.contains(b)).toArray(Block[]::new);

            for(Block nearbyBlock : nearbyBlocks) {
                if(nearbyBlock.getType() == Material.OBSIDIAN && !alreadyFound.contains(nearbyBlock)) {
                    alreadyFound.add(nearbyBlock);
                    return isValidPortal(nearbyBlock, starting, axis, alreadyFound,false);
                }
            }

            return false;
        } else if(axis == Axis.Z) {
            final Block[] nearbyBlocks = Arrays.stream(new Block[]{
                    block.getLocation().add(0,0,1).getBlock(),
                    block.getLocation().add(0,1,1).getBlock(),
                    block.getLocation().add(0,-1,1).getBlock(),
                    block.getLocation().add(0,1,0).getBlock(),
                    block.getLocation().add(0,-1,0).getBlock(),
                    block.getLocation().add(0,0,-1).getBlock(),
                    block.getLocation().add(0,1,-1).getBlock(),
                    block.getLocation().add(0,-1,-1).getBlock()
            }).filter(b -> !checked.contains(b)).toArray(Block[]::new);

            for(Block nearbyBlock : nearbyBlocks) {
                if(nearbyBlock.getType() == Material.OBSIDIAN && !alreadyFound.contains(nearbyBlock)) {
                    alreadyFound.add(nearbyBlock);
                    return isValidPortal(nearbyBlock, starting, axis, alreadyFound,false);
                }
            }

            return false;
        } else throw new IllegalArgumentException("Axis cannot be Y");
    }

    private static boolean fillPortal(Block block, Axis axis) {
        Set<Block> insideBlocks = findInsidePortalBlocks(0, block.getRelative(BlockFace.UP), axis, null);

        if(insideBlocks.isEmpty()) {
            return false;
        }

        for(Block b : insideBlocks) {
            b.setType(Material.LIME_WOOL);
        }

        return true;
    }

    private static Set<Block> findInsidePortalBlocks(int iteration, Block block, Axis axis, Set<Block> alreadyFound) {
        if(iteration > 100) {
            Bukkit.broadcastMessage("Too big");
            return new HashSet<>();
        }

        if(alreadyFound == null) alreadyFound = new HashSet<>();

        final Set<Block> checked = alreadyFound;

        Block[] nearbyBlocks = null;

        if(axis == Axis.X) {
            nearbyBlocks = Arrays.stream(new Block[] {
                    block.getLocation().add(-1,0,0).getBlock(),
                    block.getLocation().add(1,0,0).getBlock(),
                    block.getLocation().add(0,-1,0).getBlock(),
                    block.getLocation().add(0,1,0).getBlock(),
            }).filter(b -> !checked.contains(b)).toArray(Block[]::new);
        } else {
            nearbyBlocks = Arrays.stream(new Block[] {
                    block.getLocation().add(0,0,-1).getBlock(),
                    block.getLocation().add(0,0,1).getBlock(),
                    block.getLocation().add(0,-1,0).getBlock(),
                    block.getLocation().add(0,1,0).getBlock(),
            }).filter(b -> !checked.contains(b)).toArray(Block[]::new);
        }

        for(Block nearbyBlock : nearbyBlocks) {
            if(nearbyBlock.getType() == Material.AIR && !alreadyFound.contains(nearbyBlock)) {
                alreadyFound.add(nearbyBlock);
                return findInsidePortalBlocks(++iteration, nearbyBlock, axis, alreadyFound);
            }
        }

        return alreadyFound;

    }

    public static void testPortal(Player player, Block block) {
        boolean x = isValidPortal(block, block, Axis.X, new HashSet<>(), true);
        boolean z = isValidPortal(block, block, Axis.Z, new HashSet<>(), true);

        Block upBlock = block.getRelative(BlockFace.UP);
        Axis axis = null;

        Bukkit.broadcastMessage(" ");
        if(x && ! z) {
            Bukkit.broadcastMessage("Valid X portal");
            axis = Axis.X;
        } else if(z && !x) {
            Bukkit.broadcastMessage("Valid Z portal");
            axis = Axis.Z;
        } else {
            if(yawToFacing(player.getLocation().getYaw()) == BlockFace.NORTH || yawToFacing(player.getLocation().getYaw()) == BlockFace.SOUTH) {
                axis = Axis.X;
            } else {
                axis = Axis.Z;
            }
            Bukkit.broadcastMessage("Both valid, chose " + axis.name());
        }
    }

    public static void ignitePortal(Player player, Block block) {
        boolean x = isValidPortal(block, block, Axis.X, new HashSet<>(), true);
        boolean z = isValidPortal(block, block, Axis.Z, new HashSet<>(), true);

        Block upBlock = block.getRelative(BlockFace.UP);
        Axis axis = null;

        Bukkit.broadcastMessage(" ");
        if(x && ! z) {
            Bukkit.broadcastMessage("Valid X portal");
            axis = Axis.X;
        } else if(z && !x) {
            Bukkit.broadcastMessage("Valid Z portal");
            axis = Axis.Z;
        } else {
            if(yawToFacing(player.getLocation().getYaw()) == BlockFace.NORTH || yawToFacing(player.getLocation().getYaw()) == BlockFace.SOUTH) {
                axis = Axis.X;
            } else {
                axis = Axis.Z;
            }
            Bukkit.broadcastMessage("Both valid, chose " + axis.name());
        }

        fillPortal(block, axis);
    }
}

