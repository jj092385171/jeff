package tw.spring.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseController {
	
	@GetMapping(path = "/response1.controller")
	@ResponseBody
	public String processResponseAction1() {
		return "hi, how are u? 你好";
	}
	
	@GetMapping(path = "/response2.controller",produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String processResponseAction2() {
		return "hi, how are u? 你好好";
	}
	
	@GetMapping(path = "/responsestatus.controller")
	public ResponseEntity<String> processStatusAction() {
		return new ResponseEntity<String>("custom status code(403 forbidden)",HttpStatus.FORBIDDEN);
	}
	
	@GetMapping(path = "/responseimage.controller",produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public byte[] processByArrayUmageAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		InputStream in = request.getServletContext().getResourceAsStream("/WEB-INF/resources/images/1.jpg");
		return IOUtils.toByteArray(in);
	}
	
}
