package com.gring12.oop;
/*
 * p.175의 예제 클래스
 * 객체간 협력을 통한 객체 지향 프로그래밍 구현 방법을 설명한다.
 */
public class Student175 {
	//멤버 변수
	public String studentName;
	public int studentID;
	public int grade;
	public int money;
	//static 변수 추가와 활용
	public static int serialNum = 1000;
	
	//멤버 메서드
	//학생의 이름과 가진 돈을 인수로 받는 생성자
	public Student175(String studentName, int money) {
		this.studentName = studentName;
		this.money = money;
		this.studentID = serialNum++;
	}// end of constructor Student175()
	
	public void takeBus(Bus bus) {
		bus.take(1000);
		this.money -= 1000;
	}// end of takeBus()
	
	public void takeoffBus(Bus bus) {
		bus.takeoff();
	}// end of takeoffBus()
	
	public void showInfo( ) {
		System.out.println(studentID + "번 학생 " + studentName + "님의 남은 돈은 " + money + "입니다.");
	}// end of showInfo()
	
}// end of class Student175
