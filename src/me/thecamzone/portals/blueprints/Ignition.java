package me.thecamzone.portals.blueprints;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Ignition {
    private final IgnitionCause cause;
    private final Material block;
    private final ItemStack item;

    public Ignition(IgnitionCause cause, Material block, ItemStack item) {
        this.cause = cause;
        this.block = block;
        this.item = item;
    }

    public IgnitionCause getCause() {
        return cause;
    }

    public Material getBlock() {
        if(cause == IgnitionCause.BLOCK_PLACE) {
            return block;
        }

        return null;
    }

    public ItemStack getItem() {
        if(cause == IgnitionCause.ITEM_RIGHT_CLICK) {
            return item;
        }

        return null;
    }
}
