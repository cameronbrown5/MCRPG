package me.thecamzone.portals;

import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.LivingEntity;
import org.bukkit.craftbukkit.v1_20_R3.CraftServer;
import org.bukkit.craftbukkit.v1_20_R3.entity.CraftBlockDisplay;
import org.bukkit.craftbukkit.v1_20_R3.entity.CraftLivingEntity;

public class PortalEntity extends CraftBlockDisplay {

    public PortalEntity(CraftServer server, Display.BlockDisplay entity) {
        super(server, entity);
    }
}
