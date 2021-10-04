package com.dhacbang;

public interface LivingThing {
	default void speak() {
		System.out.println("This Living Thing Is Speaking");
	}
	abstract void rest();
	
}
