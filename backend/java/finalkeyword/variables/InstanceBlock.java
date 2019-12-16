package com.cg.finalkeyword.variables;

public class InstanceBlock {
	 final int MAXIMUM;
	InstanceBlock(){
		System.out.println("constructor is called");
	}
	 InstanceBlock(int a){
		System.out.println("constructor overloaded");
    }
	 {
		 System.out.println("instance initiatizer block executed");
		 this.MAXIMUM=30000;
	 }
	
	

}
