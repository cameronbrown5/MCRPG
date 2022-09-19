package me.thecamzone.Utilities.InventoryGUIs;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryHandler {

	public static void openInventory(InventoryGUI inventory, final HumanEntity ent) {
		Inventory inv = Bukkit.createInventory(new InventoryGUIHolder(inventory), inventory.getSize(), inventory.getTitle());
		
		for(GuiItem gi : inventory.getItems()) {
			inv.setItem(gi.getPosition(), gi.getItem());
		}
		
		for(int i = 0; i < inv.getSize(); i++) {
			if(inv.getItem(i) == null || inv.getItem(i).getType() == Material.AIR) {
				inv.setItem(i, inventory.backgroundItem());
			}
		}
		
		ent.openInventory(inv);
	}
	
	public static GuiItem createGuiItem(Integer position, Material material, Integer customModelData, String name, String... lore) {
		ItemStack item = new ItemStack(material, 1);
		ItemMeta meta = item.getItemMeta();
		
		if(customModelData != 0) {
			meta.setCustomModelData(customModelData);
		}
		
		meta.setDisplayName(name);
		
		meta.setLore(Arrays.asList(lore));
		
		item.setItemMeta(meta);
		
		return new GuiItem(item, position);
	}
	
}
