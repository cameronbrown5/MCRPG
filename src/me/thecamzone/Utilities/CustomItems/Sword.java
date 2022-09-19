package me.thecamzone.Utilities.CustomItems;

public class Sword implements CustomItem {

	public final double ATTACK_SPEED = 5D;
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
