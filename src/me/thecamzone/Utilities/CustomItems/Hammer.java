package me.thecamzone.Utilities.CustomItems;

public class Hammer implements CustomItem {

	public final double ATTACK_SPEED = 1.2D;
	public final double ATTACK_DAMAGE = 5D;
	
	@Override
	public double getAttackSpeed() {
		return ATTACK_SPEED;
	}
	
	@Override
	public double getAttackDamage() {
		return ATTACK_DAMAGE;
	}
	
}
