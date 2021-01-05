package com.gring12.oop;

//학생, 버스 객체 간의 협력을 보여주는 프로그램
public class TakeTrans {

	public static void main(String[] args) {
		Student175 studentJames = new Student175("제임스", 10000);
		Student175 studentTomas = new Student175("토마스", 20000);
		Student175 studentEdward = new Student175("에드워드", 15000);
		Bus bus823 = new Bus(823);
		Taxi taxi = new Taxi("청주운수");
		
		// 객체 생성 후, 버스 타기 전
		studentJames.showInfo();
		studentTomas.showInfo();
		studentEdward.showInfo();
		bus823.showInfo();
		taxi.showInfo();
		
		System.out.println("=== 교통 수단 이용 ===");
		
		// 버스 승차
		studentJames.takeBus(bus823);
		studentTomas.takeBus(bus823);
		// 택시 승차
		studentEdward.takeTaxi(taxi);
		
		// 버스 승차 후
		studentJames.showInfo();
		studentTomas.showInfo();
		bus823.showInfo();
		
		// Edward 택시 승차 후
		studentEdward.showInfo();
		taxi.showInfo();
		
		// James 버스 하차 후
		studentJames.takeoffBus(bus823);
		bus823.showInfo();
	}// end of main

}// end of class TakeTrans
