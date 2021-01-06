package com.gring12.realoop;

public class IntfCustomer implements IntfBuy, IntfSell {

	@Override
	public void sell() {
		System.out.println("구매하기");
	}

	@Override
	public void buy() {
		System.out.println("판매하기");
	}

}
