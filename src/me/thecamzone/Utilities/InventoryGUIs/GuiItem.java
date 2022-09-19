package me.thecamzone.Utilities.InventoryGUIs;

import org.bukkit.inventory.ItemStack;

public class GuiItem extends ItemStack {

	private ItemStack item;
	private Integer position;
	
	public GuiItem(ItemStack item, Integer position) {
		this.item = item;
		this.position = position;
	}

	public ItemStack getItem() {
		return item;
	}

	public Integer getPosition() {
		return position;
	}
		

	
}
