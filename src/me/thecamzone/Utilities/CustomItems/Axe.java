package me.thecamzone.Utilities.CustomItems;

public class Axe implements CustomItem {

	public final double ATTACK_SPEED = 1.6D;
	public final double ATTACK_DAMAGE = 6D;
	
	@Override
	public double getAttackSpeed() {
		return ATTACK_SPEED;
	}
	
	@Override
	public double getAttackDamage() {
		return ATTACK_DAMAGE;
	}
	
}


