package com.gring12.array;

import java.util.ArrayList;

public class StudentArrayList {

	public static void main(String[] args) {
		Student[] student = new Student[3];
		
		student[0] = new Student(1001,"James");
		student[1] = new Student(1002,"Tomas");
		student[2] = new Student(1003,"Edward");
		
		for(int i = 0; i < student.length; i++) {
			student[i].showStudentInfo();
		}// 객체 배열 만들어서 출력
		
		System.out.println("====================");
		
		ArrayList<Student> studentAL = new ArrayList<Student>();
		
		studentAL.add(new Student(1001, "James"));
		studentAL.add(new Student(1002, "Tomas"));
		studentAL.add(new Student(1003, "Edward"));
		
		for(Student studentOfAL : studentAL) {
			studentOfAL.showStudentInfo();
			
		}// ArrayList 활용해서 출력
		
	}// end of main

}// end of class
