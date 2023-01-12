package tw.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {
	
	@GetMapping("/members/{mid}")
	public String processAction(@PathVariable("mid") String memberId) {
		return memberId;
	}
}
