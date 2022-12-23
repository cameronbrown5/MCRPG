package me.thecamzone.Utilities.CustomItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class ItemFactory {

	private static HashMap<String, AttributableItem> attributableItems = new HashMap<>();
	
	public static List<String> getAttributableItems() {
		List<String> strings = new ArrayList<String>();
		
		for(String string : attributableItems.keySet()) {
			strings.add(string);
		}
		
		return strings;
	}
	
	public static void setup() {
		
		attributableItems.put("minecraft:wooden_sword", new AttributableItem("minecraft", "wooden_sword", 4d, 1.6d));
		attributableItems.put("minecraft:wooden_shovel", new AttributableItem("minecraft", "wooden_shovel", 2.5d, 1d));
		attributableItems.put("minecraft:wooden_pickaxe", new AttributableItem("minecraft", "wooden_pickaxe", 2d, 1.2d));
		attributableItems.put("minecraft:wooden_axe", new AttributableItem("minecraft", "wooden_axe", 7d, 0.8d));
		attributableItems.put("minecraft:wooden_hoe", new AttributableItem("minecraft", "wooden_hoe", 1d, 1d));
		
		attributableItems.put("minecraft:stone_sword", new AttributableItem("minecraft", "stone_sword", 5d, 1.6d));
		attributableItems.put("minecraft:stone_shovel", new AttributableItem("minecraft", "stone_shovel", 3.5d, 1d));
		attributableItems.put("minecraft:stone_pickaxe", new AttributableItem("minecraft", "stone_pickaxe", 3d, 1.2d));
		attributableItems.put("minecraft:stone_axe", new AttributableItem("minecraft", "stone_axe", 9d, 0.8d));
		attributableItems.put("minecraft:stone_hoe", new AttributableItem("minecraft", "stone_hoe", 1d, 2d));
		
		attributableItems.put("minecraft:gold_sword", new AttributableItem("minecraft", "gold_sword", 4d, 1.6d));
		attributableItems.put("minecraft:gold_shovel", new AttributableItem("minecraft", "gold_shovel", 2.5d, 1d));
		attributableItems.put("minecraft:gold_pickaxe", new AttributableItem("minecraft", "gold_pickaxe", 2d, 1.2d));
		attributableItems.put("minecraft:gold_axe", new AttributableItem("minecraft", "gold_axe", 7d, 1d));
		attributableItems.put("minecraft:gold_hoe", new AttributableItem("minecraft", "gold_hoe", 1d, 1d));
		
		attributableItems.put("minecraft:iron_sword", new AttributableItem("minecraft", "iron_sword", 6d, 1.6d));
		attributableItems.put("minecraft:iron_shovel", new AttributableItem("minecraft", "iron_shovel", 4.5d, 1d));
		attributableItems.put("minecraft:iron_pickaxe", new AttributableItem("minecraft", "iron_pickaxe", 4d, 1.2d));
		attributableItems.put("minecraft:iron_axe", new AttributableItem("minecraft", "iron_axe", 9d, 0.9d));
		attributableItems.put("minecraft:iron_hoe", new AttributableItem("minecraft", "iron_hoe", 1d, 3d));
		
		attributableItems.put("minecraft:diamond_sword", new AttributableItem("minecraft", "diamond_sword", 7d, 1.6d));
		attributableItems.put("minecraft:diamond_shovel", new AttributableItem("minecraft", "diamond_shovel", 5.5d, 1d));
		attributableItems.put("minecraft:diamond_pickaxe", new AttributableItem("minecraft", "diamond_pickaxe", 5d, 1.2d));
		attributableItems.put("minecraft:diamond_axe", new AttributableItem("minecraft", "diamond_axe", 9d, 1d));
		attributableItems.put("minecraft:diamond_hoe", new AttributableItem("minecraft", "diamond_hoe", 1d, 4d));
		
		attributableItems.put("minecraft:netherite_sword", new AttributableItem("minecraft", "netherite_sword", 8d, 1.6d));
		attributableItems.put("minecraft:netherite_shovel", new AttributableItem("minecraft", "netherite_shovel", 6.5d, 1d));
		attributableItems.put("minecraft:netherite_pickaxe", new AttributableItem("minecraft", "netherite_pickaxe", 6d, 1.2d));
		attributableItems.put("minecraft:netherite_axe", new AttributableItem("minecraft", "netherite_axe", 10d, 1d));
		attributableItems.put("minecraft:netherite_hoe", new AttributableItem("minecraft", "netherite_hoe", 1d, 4d));
		
		attributableItems.put("mcrpg:opal_scythe", new AttributableItem("mcrpg", "opal_scythe", 2d, 2d));
		attributableItems.put("mcrpg:opal_serrated", new AttributableItem("mcrpg", "opal_serrated", 6.5d, 1.6d));
		attributableItems.put("mcrpg:opal_dagger", new AttributableItem("mcrpg", "opal_dagger", 4.5d, 2.4d));
		attributableItems.put("mcrpg:opal_cutlass", new AttributableItem("mcrpg", "opal_cutlass", 5d, 1.4d));
		attributableItems.put("mcrpg:opal_broadsword", new AttributableItem("mcrpg", "opal_broadsword", 3.5d, 2.4d));
		attributableItems.put("mcrpg:opal_shovel", new AttributableItem("mcrpg", "opal_shovel", 4.5d, 1d));
		attributableItems.put("mcrpg:opal_battleaxe", new AttributableItem("mcrpg", "opal_battleaxe", 14d, 0.6d));
		attributableItems.put("mcrpg:opal_hammer", new AttributableItem("mcrpg", "opal_hammer", 4d, 1.2d));
		attributableItems.put("mcrpg:opal_pickaxe", new AttributableItem("mcrpg", "opal_scythe", 4d, 1.2d));
		attributableItems.put("mcrpg:opal_splitteraxe", new AttributableItem("mcrpg", "opal_splitteraxe", 12d, 0.6d));
		
		attributableItems.put("mcrpg:sunset_scythe", new AttributableItem("mcrpg", "sunset_scythe", 2d, 2d));
		attributableItems.put("mcrpg:sunset_serrated", new AttributableItem("mcrpg", "sunset_serrated", 6.5d, 1.6d));
		attributableItems.put("mcrpg:sunset_dagger", new AttributableItem("mcrpg", "sunset_dagger", 4.5d, 2.4d));
		attributableItems.put("mcrpg:sunset_cutlass", new AttributableItem("mcrpg", "sunset_cutlass", 5d, 1.4d));
		attributableItems.put("mcrpg:sunset_broadsword", new AttributableItem("mcrpg", "sunset_broadsword", 3.5d, 2.4d));
		attributableItems.put("mcrpg:sunset_shovel", new AttributableItem("mcrpg", "sunset_shovel", 4.5d, 1d));
		attributableItems.put("mcrpg:sunset_battleaxe", new AttributableItem("mcrpg", "sunset_battleaxe", 14d, 0.6d));
		attributableItems.put("mcrpg:sunset_hammer", new AttributableItem("mcrpg", "sunset_hammer", 4d, 1.2d));
		attributableItems.put("mcrpg:sunset_pickaxe", new AttributableItem("mcrpg", "sunset_scythe", 4d, 1.2d));
		attributableItems.put("mcrpg:sunset_splitteraxe", new AttributableItem("mcrpg", "sunset_splitteraxe", 12d, 0.6d));
		
	}
	
	public static ItemStack rollItem(ItemStack item, String namespacedID) {
		Random r = new Random();
		
		Integer random = r.nextInt(100) + 1;
		
		ItemMeta itemMeta = item.getItemMeta();
		
		Double attackDamage = 1D;
		Double attackSpeed = 1D;
		
		if(attributableItems.containsKey(namespacedID)) {
			attackDamage = attributableItems.get(namespacedID).getAttackDamage();
			attackSpeed = attributableItems.get(namespacedID).getAttackSpeed();
		}

		Double changeBy = 0D;
		
		List<String> lore = new ArrayList<>();
		
		if(random <= 16) {
			/* 
			 * Calculates percent decrease.
			 * A number between 0.01 and 0.25
			 */
			changeBy = 1 - ((r.nextInt(25) + 1) / 100D);
			
			lore = Arrays.asList(ChatColor.GRAY + "Poor");
		}
		
		else if(random <= 54) {
			/* 
			 * Calculates percent increase.
			 * A number between 0.01 and 0.05
			 */
			changeBy = 1 + ((r.nextInt(5) + 1) / 100D);
			
			lore = Arrays.asList(ChatColor.GREEN + "Common");
		}
		
		else if(random <= 84) {
			/* 
			 * Calculates percent increase.
			 * A number between 0.10 and 0.15
			 */
			changeBy = 1 + ((r.nextInt(5) + 10) / 100D);
			
			lore = Arrays.asList(ChatColor.BLUE + "Uncommon");
		}
		
		else if(random <= 99) {
			/* 
			 * Calculates percent increase.
			 * A number between 0.20 and 0.25
			 */
			changeBy = 1 + ((r.nextInt(5) + 20) / 100D);
			
			lore = Arrays.asList(ChatColor.LIGHT_PURPLE + "Rare");
		}
		
		else if(random == 100) {
			/* 
			 * Calculates percent increase.
			 * A number between 0.25 and 0.30
			 */
			changeBy = 1 + ((r.nextInt(5) + 25) / 100D);
			
			lore = Arrays.asList(ChatColor.GOLD + "Flawless");
		}
		
		attackDamage = (attackDamage * changeBy);
		attackSpeed = (attackSpeed * changeBy);
		
//		stack.setAttributeModifier("attack_damage", "mainhand", attackDamage);
//		stack.setAttributeModifier("attack_speed", "mainhand", attackSpeed);
//		stack.updateAttackDamageLore("mainhand");
//		stack.updateAttackSpeedLore("mainhand");
		
		itemMeta.removeAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE);
		itemMeta.removeAttributeModifier(Attribute.GENERIC_ATTACK_SPEED);
		
		AttributeModifier newAttackDamageModifier = new AttributeModifier(UUID.randomUUID(), "generic.attack_damage", attackDamage, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
		AttributeModifier newAttackSpeedModifier = new AttributeModifier(UUID.randomUUID(), "generic.attack_speed", attackSpeed, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);

		itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, newAttackDamageModifier);
		itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, newAttackSpeedModifier);
		
		List<String> oldLore = itemMeta.getLore();
		
		if(oldLore == null) {
			oldLore = new ArrayList<String>();
		}
		
		for(String string : lore) {
			oldLore.add(0, string);
		}
		
		itemMeta.setLore(null);
		itemMeta.setLore(oldLore);
		item.setItemMeta(itemMeta);
		
		return item;
	}
	
}
