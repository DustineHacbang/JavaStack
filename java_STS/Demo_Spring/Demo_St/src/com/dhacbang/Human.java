package com.dhacbang;

public class Human implements LivingThing {
	protected int strength;
	protected int dexterity;
	protected int intelligence;
	protected int health;
	
	public Human() {
		this.strength = 10;
		this.dexterity = 10;
		this.intelligence = 10;
		this.health = 100;
	}
	
	public void attack(Human target) {
		target.health -= this.strength;
	}
	
	public void rest() {
		this.health += 10;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

}
