package com.cg.finalkeyword.variables;

public class StaticInitializer 
{
	final int MAXIMUM;
	static final double PI;
	StaticInitializer(){
		System.out.println("constructor is called");
	}
	StaticInitializer(int a){
		System.out.println("constructor overloaded");
    }
	 {
		 System.out.println("instance initiatizer block executed");
		 this.MAXIMUM=30000;
	 }
	static {
		 System.out.println("static initiatizer block executed");
		 PI=3.142;
	 }

}
