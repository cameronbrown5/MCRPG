package me.thecamzone.Utilities.InventoryGUIs;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class InventoryGUIHolder implements InventoryHolder {

	private InventoryGUI gui;
	
	public InventoryGUIHolder (InventoryGUI guiType) {
		gui = guiType;
	}
	
	public InventoryGUI getInventoryType() {
		return gui;
	}
	
	@Override
	public Inventory getInventory() {
		return null;
	}

}
