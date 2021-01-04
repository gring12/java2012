package com.gring12.oop;

//학생, 버스 객체 간의 협력을 보여주는 프로그램
public class TakeTrans {

	public static void main(String[] args) {
		Student175 studentJames = new Student175("제임스", 10000);
		Student175 studentTomas = new Student175("토마스", 20000);
		Bus bus823 = new Bus(823);
		// 객체 생성 후, 버스 타기 전
		studentJames.showInfo();
		studentTomas.showInfo();
		bus823.showInfo();
		
		// 버스 승차
		studentJames.takeBus(bus823);
		studentTomas.takeBus(bus823);
		// 버스 승차 후
		studentJames.showInfo();
		bus823.showInfo();
		// James 버스 하차 후
		studentJames.takeoffBus(bus823);
		bus823.showInfo();
	}// end of main

}// end of class TakeTrans
