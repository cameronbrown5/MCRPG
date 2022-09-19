package me.thecamzone.Utilities.CustomItems.Items;

import me.thecamzone.Utilities.CustomItems.CustomItem;

public class Bow implements CustomItem {
	
	public final double ATTACK_SPEED = 0D;
	public final double ATTACK_DAMAGE = 0D;
	
	public String namespace, id;
	
	public Bow(String namespace, String id) {
		this.namespace = namespace;
		this.id = id;
	}
	
	@Override
	public double getAttackSpeed() {
		// TODO Auto-generated method stub
		return ATTACK_SPEED;
	}
	@Override
	public double getAttackDamage() {
		// TODO Auto-generated method stub
		return ATTACK_DAMAGE;
	}
	@Override
	public String getItemID() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public String getNamespacedID() {
		// TODO Auto-generated method stub
		return namespace + ":" + id;
	}
	
}
