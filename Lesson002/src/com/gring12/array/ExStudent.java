package com.gring12.array;

import java.util.ArrayList;

public class ExStudent {
	int studentID;
	String studentName;
	ArrayList<ExSubject> subjectList;	
	
	public ExStudent(int studentID, String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;
		subjectList = new ArrayList<ExSubject>();
	}
	
	public void addSubject(String subjectName, int subjectScore) {
		ExSubject subject = new ExSubject(subjectName, subjectScore);
		subjectList.add(subject);
	}
	
	public void showStudentInfo() {
		int total = 0;
		for(ExSubject s : subjectList) {
			total += s.getSubjectScore();
			System.out.println("학생 " + studentName + "의 " 
			           + s.getSubjectName() + " 과목의 성적은 "
			           + s.getSubjectScore() + "입니다.");
		}
		System.out.println("학생 " + studentName + "의 총점은 " 
				       + total + " 입니다.");
		System.out.println("-------------------");
	}
	
	
	
	
	
}
