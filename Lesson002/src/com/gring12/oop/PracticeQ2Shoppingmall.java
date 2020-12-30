package com.gring12.oop;

public class PracticeQ2Shoppingmall {
	long number;
	String ID;
	String date;
	String name;
	String numberOfProduct;
	String address;
	
	public static void main(String[] args) {
		PracticeQ2Shoppingmall Order = new PracticeQ2Shoppingmall ();
			Order.number = 201803120001L ;
			Order.ID = "abc123" ;
			Order.date = "2018년 03월 12일" ;
			Order.name = "홍길순" ;
			Order.numberOfProduct = "PD0345-12" ;
			Order.address = "서울시 영등포구 여의도동 20번지" ;
			
		System.out.println("주문 번호 : " + Order.number);
		System.out.println("주문자 아이디 : " + Order.ID);
		System.out.println("주문 날짜 : " + Order.date);
		System.out.println("주문자 이름 : " + Order.name);
		System.out.println("주문 상품 번호 : " + Order.numberOfProduct);
		System.out.println("배송 주소 : " + Order.address);
			
	}

}
