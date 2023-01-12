package tw.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tw.spring.model.Account;
import tw.spring.model.AccountService;

@Controller
public class LoginSystemController {
	
	@Autowired
	private AccountService aService;
	
	@RequestMapping(path = "/loginsystemmain.controller", method = RequestMethod.GET)
	public String processMainAction() {
		return "loginSystem";
	}
	
	@RequestMapping(path = "/checklogin.controller", method = RequestMethod.POST)
	public String processAction(@RequestParam("userName") String user, @RequestParam("userPwd") String pwd, Model m) {
		Map<String, String> errors = new HashMap<String, String>();
		m.addAttribute("errors", errors);
		
		if (user==null || user.length()==0) {
			errors.put("name", "name is required");
		}
		
		if(pwd==null || pwd.length()==0) {
			errors.put("pwd", "password is required");
		}
		
		if(errors!=null && !errors.isEmpty()) {
			return "loginSystem";
		}
		
		boolean status = aService.checkLogin(new Account(user,pwd));
		if(status) {
			m.addAttribute("user",user);
			m.addAttribute("pwd", pwd);
			return "loginSuccess";
		}
		
		errors.put("msg", "please input correct username or password");
		
		return "loginSystem";
	}
	
}
