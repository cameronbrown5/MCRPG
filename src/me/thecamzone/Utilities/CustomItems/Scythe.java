package me.thecamzone.Utilities.CustomItems;

public class Scythe implements CustomItem {

	public final double ATTACK_SPEED = 2D;
	public final double ATTACK_DAMAGE = 2D;
	
	@Override
	public double getAttackSpeed() {
		return ATTACK_SPEED;
	}
	
	@Override
	public double getAttackDamage() {
		return ATTACK_DAMAGE;
	}
	
}
