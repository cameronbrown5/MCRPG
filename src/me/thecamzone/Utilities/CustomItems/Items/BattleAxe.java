package me.thecamzone.Utilities.CustomItems.Items;

import me.thecamzone.Utilities.CustomItems.CustomItem;

public class BattleAxe implements CustomItem {
	
	public final double ATTACK_SPEED = 1.6D;
	public final double ATTACK_DAMAGE = 12D;
	
public String namespace, id;
	
	public BattleAxe(String namespace, String id) {
		this.namespace = namespace;
		this.id = id;
	}
	
	@Override
	public double getAttackSpeed() {
		return ATTACK_SPEED;
	}
	
	@Override
	public double getAttackDamage() {
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