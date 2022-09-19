package me.thecamzone.Utilities.InventoryGUIs;

import org.bukkit.inventory.ItemStack;

public interface InventoryGUI {

	public String getTitle();
	public Integer getSize();
	public GuiItem[] getItems();
	public ItemStack backgroundItem();
	
}
