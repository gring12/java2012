package com.gring12.realoop;

public class VIPCustomer extends Customer {
	private int agentID;
	double saleRatio;
	
	public VIPCustomer() {
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
	}
	
	
	@Override
	public int calcPrice(int price) {
		// return super.calcPrice(price);
		bonusPoint += price * bonusRatio;
		return price - (int)(price * saleRatio);
	} // 상속받은 메서드를 하위 클래스에서 재정의해서 사용하는 것 = Override



	public int getAgentID() {
		return agentID;
	}
}
