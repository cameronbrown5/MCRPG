package me.thecamzone.Utilities.CustomItems;

public class Staff implements CustomItem {

	public final double ATTACK_SPEED = 0D;
	public final double ATTACK_DAMAGE = 0D;
	
	@Override
	public double getAttackSpeed() {
		return ATTACK_SPEED;
	}
	
	@Override
	public double getAttackDamage() {
		return ATTACK_DAMAGE;
	}
	
}
