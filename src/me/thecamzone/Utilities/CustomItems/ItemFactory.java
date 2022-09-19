package me.thecamzone.Utilities.CustomItems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import dev.lone.itemsadder.api.CustomStack;
import me.thecamzone.Utilities.CustomItems.Items.Axe;
import me.thecamzone.Utilities.CustomItems.Items.BattleAxe;
import me.thecamzone.Utilities.CustomItems.Items.Bow;
import me.thecamzone.Utilities.CustomItems.Items.Broadsword;
import me.thecamzone.Utilities.CustomItems.Items.Cutlass;
import me.thecamzone.Utilities.CustomItems.Items.Dagger;
import me.thecamzone.Utilities.CustomItems.Items.Hammer;
import me.thecamzone.Utilities.CustomItems.Items.Hoe;
import me.thecamzone.Utilities.CustomItems.Items.Net;
import me.thecamzone.Utilities.CustomItems.Items.PickAxe;
import me.thecamzone.Utilities.CustomItems.Items.Scythe;
import me.thecamzone.Utilities.CustomItems.Items.Serrated;
import me.thecamzone.Utilities.CustomItems.Items.Shovel;
import me.thecamzone.Utilities.CustomItems.Items.SplitterAxe;
import me.thecamzone.Utilities.CustomItems.Items.Staff;
import me.thecamzone.Utilities.CustomItems.Items.Sword;
import net.md_5.bungee.api.ChatColor;

public class ItemFactory {

	private static HashMap<String, CustomItem> customItems = new HashMap<>();
	
	public static void setup() {
		customItems.put("axe", new Axe("mcrpg", "axe"));
		customItems.put("battleaxe", new BattleAxe("mcrpg", "battleaxe"));
		customItems.put("bow", new Bow("mcrpg", "bow"));
		customItems.put("broadsword", new Broadsword("mcrpg", "broadsword"));
		customItems.put("cutlass", new Cutlass("mcrpg", "cutlass"));
		customItems.put("dagger", new Dagger("mcrpg", "dagger"));
		customItems.put("hammer", new Hammer("mcrpg", "hammer"));
		customItems.put("hoe", new Hoe("mcrpg", "hoe"));
		customItems.put("net", new Net("mcrpg", "axe"));
		customItems.put("pickaxe", new PickAxe("mcrpg", "pickaxe"));
		customItems.put("scythe", new Scythe("mcrpg", "scythe"));
		customItems.put("serrated", new Serrated("mcrpg", "serrated"));
		customItems.put("shovel", new Shovel("mcrpg", "shovel"));
		customItems.put("splitteraxe", new SplitterAxe("mcrpg", "splitteraxe"));
		customItems.put("staff", new Staff("mcrpg", "staff"));
		customItems.put("sword", new Sword("mcrpg", "sword"));
	}
	
	public static ItemStack rollItem(String type, CustomStack stack) {
		Random r = new Random();
		
		Integer random = r.nextInt(100) + 1;
		Double attackDamage = customItems.get(type).getAttackDamage();
		Double attackSpeed = customItems.get(type).getAttackSpeed();
		Integer changeBy = 0;
		
		List<String> lore = null;
		
		Bukkit.getConsoleSender().sendMessage("Random number: " + random);
		
		if(random <= 16) {
			/* 
			 * Calculates percent decrease.
			 * A number between 0.01 and 0.25
			 */
			changeBy = 1 - ((r.nextInt(25) + 1) / 100);
			
			lore = Arrays.asList(ChatColor.GRAY + "Poor");
			Bukkit.getConsoleSender().sendMessage("Rolled poor");
		}
		
		else if(random <= 54) {
			/* 
			 * Calculates percent increase.
			 * A number between 0.01 and 0.05
			 */
			changeBy = 1 + ((r.nextInt(5) + 1) / 100);
			
			lore = Arrays.asList(ChatColor.GREEN + "Uncommon");
			Bukkit.getConsoleSender().sendMessage("Rolled uncommon");
		}
		
		else if(random <= 84) {
			/* 
			 * Calculates percent increase.
			 * A number between 0.10 and 0.15
			 */
			changeBy = 1 + ((r.nextInt(5) + 10) / 100);
			
			lore = Arrays.asList(ChatColor.BLUE + "Common");
			Bukkit.getConsoleSender().sendMessage("Rolled common");
		}
		
		else if(random <= 99) {
			/* 
			 * Calculates percent increase.
			 * A number between 0.20 and 0.25
			 */
			changeBy = 1 + ((r.nextInt(5) + 20) / 100);
			
			lore = Arrays.asList(ChatColor.LIGHT_PURPLE + "Rare");
			Bukkit.getConsoleSender().sendMessage("Rolled rare");
		}
		
		else if(random == 100) {
			/* 
			 * Calculates percent increase.
			 * A number between 0.25 and 0.30
			 */
			changeBy = 1 + ((r.nextInt(5) + 25) / 100);
			
			lore = Arrays.asList(ChatColor.GOLD + "Flawless");
			Bukkit.getConsoleSender().sendMessage("Rolled flawless");
		}
		
		attackDamage = (double) Math.round((attackDamage * changeBy * 100)) / 100;
		attackSpeed = (double) Math.round((attackSpeed * changeBy * 100)) / 100;
		
		stack.setAttributeModifier("attackDamage", "mainhand", attackDamage);
		stack.setAttributeModifier("attackSpeed", "mainhand", attackSpeed);
		
		ItemStack item = stack.getItemStack();
		ItemMeta itemMeta = item.getItemMeta();
		
		List<String> oldLore = itemMeta.getLore();
		for(String string : lore) {
			oldLore.add(0, string);
		}
		
		oldLore.add(oldLore.size() - 4, " ");
		
		item.setItemMeta(itemMeta);
		
		return item;
	}
	
}
