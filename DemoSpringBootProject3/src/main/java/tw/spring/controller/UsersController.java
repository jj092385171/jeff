package tw.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.spring.model.Users;
import tw.spring.model.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private UsersService uService;
	
	@GetMapping("/findusers1.controller")
	public List<Users> processFindAllUsersAction1(){
		return uService.findAllusers("ma");
	}
	
	@GetMapping("/findusers2.controller")
	public List<Users> processFindAllUsersAction2(){
		return uService.findByUsernameLike("%rr%");
	}
	
	@GetMapping("findallusers.controller")
	public List<Users> processFindAllAction(){
		return uService.findAll();
	}
}
