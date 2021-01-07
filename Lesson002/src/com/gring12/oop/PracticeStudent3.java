package com.gring12.oop;

public class PracticeStudent3 {
	private static int serialNum = 1000;
	int studentID;
	String studentName;
	int grade;
	String address;
	int cardNumber;
	
	public PracticeStudent3(){
		serialNum++;
		studentID = serialNum;
		cardNumber = studentID + 100;
	}

	public static int getSerialNum() {
		return serialNum;
	}

	public static void setSerialNum(int serialNum) {
		PracticeStudent3.serialNum = serialNum;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
	
}
