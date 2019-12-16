package com.cg.finalkeyword.variables;

public class TestStaticInitializer {
	public static void main(String[] args) {
		StaticInitializer i1=new StaticInitializer();
		System.out.println(i1.MAXIMUM);

		StaticInitializer i2=new StaticInitializer(23);
		System.out.println(i2.MAXIMUM);
		System.out.println(StaticInitializer.PI);

		
		
	}

}
