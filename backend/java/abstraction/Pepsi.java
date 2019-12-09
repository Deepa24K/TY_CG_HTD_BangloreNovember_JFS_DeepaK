package com.cg.abstraction.abstraction;

public class Pepsi implements Bottle{

	@Override
	public void open() {
System.out.println("opening bottle");		
	}

	@Override
	public void close() {
System.out.println("closing bottle");		
	}
	
	public void drink() {
		System.out.println("drinking water with sugar");
	}
	
}
