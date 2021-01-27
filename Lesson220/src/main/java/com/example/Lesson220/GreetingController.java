package com.example.Lesson220;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * Step 3. Resource Controller 생성하기
 */
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong(); //Auto_increment와 같은 역할
	
	@GetMapping("/greeting") // 웹에서 "/greeting"이 요청될 때 RequestParameter 하여 name 받고 template 형식으로 return
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
/*
 * view 파일 생성하지 않고, project를 spring boot app으로 run 한 후에 localhost:8080/greeting에 접속하면
 * {"id":1, "content":"Hello, World!"} 로 출력됨.
 * greeting 뒤에 ?name=네임값 넣어주면 id값은 증가하면서 default 였던 World 부분이 네임값으로 출력됨.
 */