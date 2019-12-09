package com.cg.abstraction.abstraction;

public interface Bottle 
{
	void open();
	
	void close();
	
	static void juice() {
		System.out.println("juice is available");
	}
	default void drink() {
		System.out.println("drinking water");
	}
	
	
}
