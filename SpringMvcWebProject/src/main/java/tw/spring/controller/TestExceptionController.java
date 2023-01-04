package tw.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestExceptionController {
	
	@GetMapping("/exceptionhandle.controller")
	public void processAction() throws Exception {
		throw new Exception();
	}
}
