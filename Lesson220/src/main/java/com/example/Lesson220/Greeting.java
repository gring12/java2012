package com.example.Lesson220;
/*
 * Step 2. Resource Representation 클래스 생성
 */
public class Greeting {

	private final long id;
	private final String content;
	
	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}// end of Greeting()
	
	public long getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}
}// end of class
/*
 * Step 3. Resource Controller인 GreetingController.java 를 생성하러
 */
