package com.cg.abstraction.abstraction;

public class Son implements Father1,Father2{

	@Override
	public void home() {
		Father2.super.home();
	}

}
