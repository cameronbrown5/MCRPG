package me.thecamzone.Utilities.CustomItems.Items;

import me.thecamzone.Utilities.CustomItems.CustomItem;

public class Broadsword implements CustomItem {
	
	public final double ATTACK_SPEED = 5D;
	public final double ATTACK_DAMAGE = 5D;
	
	public String namespace, id;
	
	public Broadsword(String namespace, String id) {
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
