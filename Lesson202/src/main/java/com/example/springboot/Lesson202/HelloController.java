package com.example.springboot.Lesson202;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Step2. web application을 만듦
// HelloController class가 @RestController로 플래그가 지정되어 SpringMVC에서 웹 요청을 처리할 준비가 되었음을 의미 
@RestController
public class HelloController {
	
	// '/'를 index() 메서드에 매핑
	@RequestMapping("/")
	public String index() {
		return "Hi, Nice to meet you from spring boot....";
	}
}
