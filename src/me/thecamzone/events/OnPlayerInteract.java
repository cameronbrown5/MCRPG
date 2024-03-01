package me.thecamzone.events;

import me.thecamzone.utilities.DirectionUtil;
import me.thecamzone.portals.PortalUtil;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class OnPlayerInteract implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		ItemStack item = e.getItem();
		Block clickedBlock = e.getClickedBlock();
		BlockFace direction = e.getBlockFace();

		if(item == null) { return; }

		if(clickedBlock == null) { return; }

		if(item.getType() == Material.STICK) {
			if(clickedBlock.getType() != Material.OBSIDIAN) {
				return;
			}

			Block ignitionBlock = clickedBlock.getRelative(direction);

			player.sendMessage("Starting..");

			PortalUtil.createPortal(ignitionBlock, DirectionUtil.yawToAxis(player.getLocation().getYaw()), true, true);
		}
	}
	
}
