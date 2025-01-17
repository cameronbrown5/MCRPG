package me.thecamzone.utilities.files;

import me.thecamzone.MCRPG;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class DataFile {

	private static File file;
	private static FileConfiguration customFile;

	private static final String FILE_NAME = "data";

	// Generates file if not created.
	public static void setup()
	{
		file = new File(MCRPG.plugin.getDataFolder(), FILE_NAME + ".yml");
		
		if(!file.exists())
		{
			try
			{
				file.createNewFile();
			} catch (IOException e)
			{
				Bukkit.getServer().getConsoleSender().sendMessage("Could not create " + FILE_NAME + ".yml.");
			}
			
		}
		
		customFile = YamlConfiguration.loadConfiguration(file);
	}
	
	public static FileConfiguration get()
	{
		return customFile;
	}
	
	public static void save()
	{
		try
		{
			customFile.save(file);
		} catch (IOException e)
		{
			Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Could not save " + FILE_NAME + ".yml.");
		}
		
	}
	
	public static void reload()
	{
		customFile = YamlConfiguration.loadConfiguration(file);
	}
	
}
