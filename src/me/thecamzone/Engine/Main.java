package me.thecamzone.Engine;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import me.thecamzone.Commands.Main.MCRPG;
import me.thecamzone.Commands.Warp.Delwarp;
import me.thecamzone.Commands.Warp.Setwarp;
import me.thecamzone.Commands.Warp.Warp;
import me.thecamzone.Commands.Warp.WarpTC;
import me.thecamzone.Events.OnBlockPlace;
import me.thecamzone.Events.OnPlayerInteract;
import me.thecamzone.Events.OnPlayerInteractEntity;
import me.thecamzone.Events.OnPlayerJoin;
import me.thecamzone.Utilities.CustomItems.ItemFactory;
import me.thecamzone.Utilities.Files.WarpsFile;
import me.thecamzone.Warps.Warps;

public class Main extends JavaPlugin {

	public static Main plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		
		makeDir();
		
		registerCommands();
		registerEvents();
	
		ItemFactory.setup();
		
		load();
	}
	
	@Override
	public void onDisable() {
		Warps.save();
	}
	
	private void registerCommands() {
		getCommand("mcrpg").setExecutor(new MCRPG());
		getCommand("warp").setExecutor(new Warp());
		getCommand("setwarp").setExecutor(new Setwarp());
		getCommand("delwarp").setExecutor(new Delwarp());
		
		getCommand("warp").setTabCompleter(new WarpTC());
		getCommand("delwarp").setTabCompleter(new WarpTC());
	}
	
	private void registerEvents() {
		getServer().getPluginManager().registerEvents(new OnBlockPlace(), this);
		getServer().getPluginManager().registerEvents(new OnPlayerInteractEntity(), this);
		getServer().getPluginManager().registerEvents(new OnPlayerInteract(), this);
		getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
	}
	
	private void load() {
		BukkitScheduler scheduler = getServer().getScheduler();
        scheduler.scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
            	WarpsFile.setup();
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
