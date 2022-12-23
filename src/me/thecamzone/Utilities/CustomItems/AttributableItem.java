package me.thecamzone.Utilities.CustomItems;

public class AttributableItem {
	
	private String namespace;
	private String id;
	
	private Double attackDamage;
	private Double attackSpeed;
	
	public AttributableItem(String namespace, String id, Double attackDamage, Double attackSpeed) {
		this.namespace = namespace;
		this.id = id;
		this.attackDamage = attackDamage;
		this.attackSpeed = attackSpeed;
	}
	
	public String getNamespace() {
		return namespace;
	}
	
	public String getId() {
		return id;
	}
	
	public Double getAttackDamage() {
		return attackDamage;
	}
	
	public Double getAttackSpeed() {
		return attackSpeed;
	}
	
}
