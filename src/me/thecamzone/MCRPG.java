package me.thecamzone;

import co.aikar.commands.PaperCommandManager;
import me.thecamzone.commands.MCRPGCommand;
import me.thecamzone.events.*;
import me.thecamzone.utilities.files.DataFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import me.thecamzone.commands.warp.Delwarp;
import me.thecamzone.commands.warp.Setwarp;
import me.thecamzone.commands.warp.Warp;
import me.thecamzone.commands.warp.WarpTC;
import me.thecamzone.utilities.files.WarpsFile;
import me.thecamzone.warps.Warps;

public class MCRPG extends JavaPlugin {

	public static MCRPG plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		
		makeDir();
		
		registerCommands();
		registerEvents();
		loadFiles();
		
		loadAfterWorlds();
	}
	
	@Override
	public void onDisable() {
		Warps.save();
	}
	
	private void registerCommands() {
		getCommand("warp").setExecutor(new Warp());
		getCommand("setwarp").setExecutor(new Setwarp());
		getCommand("delwarp").setExecutor(new Delwarp());

		getCommand("warp").setTabCompleter(new WarpTC());
		getCommand("delwarp").setTabCompleter(new WarpTC());

		PaperCommandManager manager = new PaperCommandManager(this);

		manager.registerCommand(new MCRPGCommand());
	}
	
	private void registerEvents() {
		getServer().getPluginManager().registerEvents(new OnBlockPlace(), this);
		getServer().getPluginManager().registerEvents(new OnPlayerInteractEntity(), this);
		getServer().getPluginManager().registerEvents(new OnPlayerInteract(), this);
		getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
		getServer().getPluginManager().registerEvents(new OnEntityRegainHealth(), this);
		getServer().getPluginManager().registerEvents(new OnPrepareCraftItem(), this);
		getServer().getPluginManager().registerEvents(new OnBlockIgnite(), this);
		getServer().getPluginManager().registerEvents(new OnBlockBreak(), this);
	}

	private void loadFiles() {
		DataFile.setup();
		WarpsFile.setup();
	}

	private void loadAfterWorlds() {
		BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
        		Warps.load();
            }
        }, 1L);
	}
	
	private Boolean makeDir() {
		if(!getDataFolder().exists()) {
			getDataFolder().mkdir();
			return true;
		}
		return false;
	}
	
}
