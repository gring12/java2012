package com.gring12.oop;
/*
 * static 변수와 static 메서드를 이해하기
 */
public class Student187 {
	private static int serialNum = 1000;
	int studentID;
	
	public Student187() {
		serialNum++;
		this.studentID = serialNum;
	}

	public static int getSerialNum() {
		return serialNum;
	}

	public static void setSerialNum(int serialNum) {
		Student187.serialNum = serialNum;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
}
