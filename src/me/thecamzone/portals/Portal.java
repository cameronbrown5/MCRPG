package me.thecamzone.portals;

import org.bukkit.Axis;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Portal {

    private final UUID uuid;
    private final Axis axis;
    private final Set<Block> insideBlocks;
    private final Set<Block> frameBlocks;
    private final Set<Entity> portalEntities;

    public Portal(Axis axis, Set<Block> insideBlocks, Set<Block> frameBlocks) {
        this.axis = axis;
        this.uuid = UUID.randomUUID();
        this.insideBlocks = insideBlocks;
        this.frameBlocks = frameBlocks;
        this.portalEntities = new HashSet<>();
    }

    public UUID getUuid() {
        return uuid;
    }

    public Set<Block> getInsideBlocks() {
        return new HashSet<>(insideBlocks);
    }

    public Set<Block> getFrameBlocks() {
        return new HashSet<>(frameBlocks);
    }

    public Set<Entity> getPortalEntities() {
        return new HashSet<>(portalEntities);
    }

    public void destroy() {
        for(Entity e : portalEntities) {
            e.remove();
        }

        PortalHandler.removePortal(uuid);
    }

    public void ignite() {
        for(Block b : insideBlocks) {
            Location location = b.getLocation();

            if(axis == Axis.Z) {
                location = location.add(0, 0, 0.999);
            }

            World world = location.getWorld();

            assert world != null;
            BlockDisplay display = (BlockDisplay) world.spawnEntity(location, EntityType.BLOCK_DISPLAY);
            display.setBlock(Material.NETHER_PORTAL.createBlockData());

            if(axis == Axis.Z) {
                display.setRotation(-90, 0);
            }

            portalEntities.add(display);
        }
    }

    public void save() {

    }


}
