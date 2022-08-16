package me.thecamzone.Warps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Nullable;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import me.thecamzone.Utilities.Files.WarpsFile;

public class Warps {
	
	private static Map<String, Location> warps = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
	
	public static void addWarp(String string, Location location) {
		location = roundLocation(location);
		
		warps.put(string, location);
		
		FileConfiguration warpFile = WarpsFile.get();
		warpFile.set("warps." + string + ".location", location.getX() + ", " + location.getY() + ", " + location.getZ());
		warpFile.set("warps." + string + ".direction", location.getPitch() + ", " + location.getYaw());
		warpFile.set("warps." + string + ".worldname", location.getWorld().getName());
		
		WarpsFile.save();
	}
	
	public static Boolean delWarp(String string) {
		if(warps.get(string) == null) {
			return false;
		} else {
			warps.remove(string);
			
			FileConfiguration warpFile = WarpsFile.get();
			warpFile.set("warps." + string, null);
			WarpsFile.save();
			return true;
		}
	}
	
	@Nullable
	public static Location getWarp(String string) {
		return warps.get(string);
	}
	
	public static List<String> getWarps() {
		ArrayList<String> warpNames = new ArrayList<>();
		
		for(String string : warps.keySet()) {
			warpNames.add(string);
		}
		
		return warpNames;
	}
	
	public static void load() {
		FileConfiguration warpFile = WarpsFile.get();
		
		if(warpFile.getConfigurationSection("warps") == null) {
			Bukkit.getConsoleSender().sendMessage("[MCRPG] No warps to load.");
			return;
		}
		
		ConfigurationSection warpSection = warpFile.getConfigurationSection("warps");
		
		for(String string : warpSection.getKeys(false)) {
			String location = warpSection.getString(string + ".location");
			String direction = warpSection.getString(string + ".direction");
			String worldName = warpSection.getString(string + ".worldname");
			
			Location loc = convertLocation(location, direction, worldName);
			addWarp(string, loc);
		}
	}
	
	public static void save() {
		FileConfiguration warpFile = WarpsFile.get();
		
		for(String warp : warps.keySet()) {
			Location warpLoc = warps.get(warp);
			
			warpFile.set("warps." + warp + ".location", warpLoc.getX() + ", " + warpLoc.getY() + ", " + warpLoc.getZ());
			warpFile.set("warps." + warp + ".direction", warpLoc.getPitch() + ", " + warpLoc.getYaw());
			warpFile.set("warps." + warp + ".worldname", warpLoc.getWorld().getName());
		}
		
		WarpsFile.save();
	}
	
	private static Location roundLocation(Location loc) {
		Double x = loc.getX();
		x = ((Math.round(x * 100)) / 100D);
		
		Double y = loc.getY();
		y = ((Math.round(y * 100)) / 100D);
		
		Double z = loc.getZ();
		z = ((Math.round(z * 100)) / 100D);
		
		float yaw = loc.getYaw();
		yaw = ((Math.round(yaw * 100)) / 100F);
		
		float pitch = loc.getPitch();
		pitch = ((Math.round(pitch * 100)) / 100F);
		
		return new Location(loc.getWorld(), x, y, z, yaw, pitch);
	}
	
	private static Location convertLocation(String location, String direction, String worldName) {
		String locationDirection = location + ", " + direction;
		
		String[] stringCoordinates = locationDirection.split(", ");
		
		ArrayList<Float> coordinates = new ArrayList<>();
		for(String coordinate : stringCoordinates) {
			coordinates.add(Float.parseFloat(coordinate));
		}
		
		return new Location(Bukkit.getWorld(worldName), coordinates.get(0), coordinates.get(1), coordinates.get(2), coordinates.get(4), coordinates.get(3));
	}
	
}
