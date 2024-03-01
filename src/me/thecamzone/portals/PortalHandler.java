package me.thecamzone.portals;

import org.bukkit.block.Block;
import java.util.HashMap;
import java.util.UUID;

public class PortalHandler {

    private static final HashMap<UUID, Portal> portals = new HashMap<>();
    private static final HashMap<Block, Block> frameIgnition = new HashMap<>();

    public static void addPortal(UUID uuid, Portal portal) {
        portals.put(uuid, portal);
    }

    public static void removePortal(UUID uuid) {
        portals.remove(uuid);
    }

    public static HashMap<UUID, Portal> getPortals() {
        return new HashMap<>(portals);
    }

    public static HashMap<Block, Block> getFrameIgnition() {
        return new HashMap<>(frameIgnition);
    }

    public void loadPortalTypes() {

    }
}
