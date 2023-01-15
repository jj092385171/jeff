package tw.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello.controller")
	public String processAction() {
		return "hello,mary";
	}
}
