package tw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tw.spring.model.Users;
import tw.spring.model.UsersService;


@Controller
public class UsersCheckController {
	
	@Autowired
	private UsersService uService;
	
	@PostMapping("/userscheck.controller")
	public ResponseEntity<String> processAction(@RequestBody Users users){
		boolean status = uService.checkLogin(users);
		
		if(status) {
			return new ResponseEntity<String>("Y",HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("N", HttpStatus.OK);
	}

}
