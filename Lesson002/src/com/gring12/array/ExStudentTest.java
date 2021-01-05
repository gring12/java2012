package com.gring12.array;

public class ExStudentTest {

	public static void main(String[] args) {

		ExStudent Lee = new ExStudent(1001, "Lee");
		ExStudent Kim = new ExStudent(1002, "Kim");

		Lee.addSubject("국어", 100);
		Lee.addSubject("수학", 50);

		Kim.addSubject("국어", 70);
		Kim.addSubject("수학", 85);
		Kim.addSubject("영어", 100);
		
		Lee.showStudentInfo();
		Kim.showStudentInfo();
		
	}

}
