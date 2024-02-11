package me.thecamzone.events;

import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Campfire;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockDataMeta;

public class OnPrepareCraftItem implements Listener {
    @EventHandler
    public void onPrepareCraftItem(PrepareItemCraftEvent e) {
        if(e.getRecipe() == null)
            return;

        ItemStack item = e.getRecipe().getResult();

        if(item.getType() != Material.CAMPFIRE) {
            return;
        }

        BlockDataMeta meta = (BlockDataMeta) item.getItemMeta();
        BlockData data = Material.CAMPFIRE.createBlockData();
        ((Campfire) data).setLit(false);
        meta.setBlockData(data);
        item.setItemMeta(meta);

        e.getInventory().setResult(item);
    }

}
