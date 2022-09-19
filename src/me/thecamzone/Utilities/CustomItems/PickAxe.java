package me.thecamzone.Utilities.CustomItems;

public class PickAxe implements CustomItem {

	public final double ATTACK_SPEED = 1.2D;
	public final double ATTACK_DAMAGE = 4D;
	
	@Override
	public double getAttackSpeed() {
		return ATTACK_SPEED;
	}
	
	@Override
	public double getAttackDamage() {
		return ATTACK_DAMAGE;
	}
	
}
