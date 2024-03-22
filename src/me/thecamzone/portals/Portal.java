package me.thecamzone.portals;

import com.jeff_media.customblockdata.CustomBlockData;
import com.jeff_media.morepersistentdatatypes.DataType;
import me.thecamzone.MCRPG;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Portal {

    private final UUID uuid;
    private final Axis axis;
    private final Set<Location> insideLocations;
    private final Set<Block> frameBlocks;
    private final Set<Entity> portalEntities;

    public Portal(Axis axis, Set<Location> insideBlocks, Set<Block> frameBlocks) {
        this.axis = axis;
        this.uuid = UUID.randomUUID();
        this.insideLocations = insideBlocks;
        this.frameBlocks = frameBlocks;
        this.portalEntities = new HashSet<>();
    }

    public UUID getUuid() {
        return uuid;
    }

    public Set<Location> getInsideLocations() {
        return new HashSet<>(insideLocations);
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
        for(Location location : insideLocations) {
            Block b = location.getBlock();

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

        save();
    }

    public void save() {
        for(Block block : frameBlocks) {
            PersistentDataContainer customBlockData = new CustomBlockData(block, MCRPG.plugin);

            customBlockData.set(
                    new NamespacedKey(MCRPG.plugin, uuid.toString()),
                    DataType.LOCATION_ARRAY,
                    insideLocations.toArray(new Location[0])
            );
        }
    }


}
