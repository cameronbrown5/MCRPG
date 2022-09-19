package me.thecamzone.Utilities.CustomItems;

import java.util.Random;
import dev.lone.itemsadder.api.CustomStack;

public class ItemFactory {

	public static CustomStack rollItem(CustomItem base, String type) {
		Random r = new Random();
		
		CustomStack stack = CustomStack.getInstance(type);
		if(stack == null) return null;
		
		Integer random = r.nextInt(100) + 1;
		Double attackDamage = base.getAttackDamage();
		Double attackSpeed = base.getAttackSpeed();
		Integer changeBy = 0;
		
		if(random <= 16) {
			/* 
			 * Calculates percent decrease.
			 * A number between 0.01 and 0.25
			 */
			changeBy = 1 - ((r.nextInt(25) + 1) / 100);
		}
		
		else if(random <= 54) {
			/* 
			 * Calculates percent increase.
			 * A number between 0.01 and 0.05
			 */
			changeBy = 1 + ((r.nextInt(5) + 1) / 100);
		}
		
		else if(random <= 84) {
			/* 
			 * Calculates percent increase.
			 * A number between 0.10 and 0.15
			 */
			changeBy = 1 + ((r.nextInt(5) + 10) / 100);
		}
		
		else if(random <= 99) {
			/* 
			 * Calculates percent increase.
			 * A number between 0.20 and 0.25
			 */
			changeBy = 1 + ((r.nextInt(5) + 20) / 100);
		}
		
		else if(random == 100) {
			/* 
			 * Calculates percent increase.
			 * A number between 0.25 and 0.30
			 */
			changeBy = 1 + ((r.nextInt(5) + 25) / 100);
		}
		
		attackDamage = (double) Math.round((attackDamage * changeBy * 100)) / 100;
		attackSpeed = (double) Math.round((attackSpeed * changeBy * 100)) / 100;
		
		stack.setAttributeModifier("attackDamage", "mainhand", attackDamage);
		stack.setAttributeModifier("attackSpeed", "mainhand", attackSpeed);
		
		return stack;
	}
	
}
