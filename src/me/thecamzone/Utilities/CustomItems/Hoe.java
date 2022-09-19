package me.thecamzone.Utilities.CustomItems;

public class Hoe implements CustomItem {

	public final double ATTACK_SPEED = 1.0D;
	public final double ATTACK_DAMAGE = 1D;
	
	@Override
	public double getAttackSpeed() {
		return ATTACK_SPEED;
	}
	
	@Override
	public double getAttackDamage() {
		return ATTACK_DAMAGE;
	}
	
}
