package com.gring12.oop;

public class PracticeQ1Person {
	int age;
	String name;
	boolean isMarried;
	int numberOfKids;

	public static void main(String[] args) {
		PracticeQ1Person person1 = new PracticeQ1Person();
		person1.age = 40;
		person1.name = "James";
		person1.isMarried = true;
		person1.numberOfKids = 3;

		System.out.println("<출력 결과>");
		System.out.println("이 사람의 나이 " + person1.age);
		System.out.println("이 사람의 이름 " + person1.name);
		System.out.println("이 사람의 결혼 여부 " + person1.isMarried);
		System.out.println("이 사람의 자녀 수 " + person1.numberOfKids);

	}// end of main

}// end of class
