package tw.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.spring.model.Members;

@Controller
public class MembersController {
	
	@RequestMapping(path = "/members.controller",method = RequestMethod.GET)
	public String processMainAcrion(Model m) {
//		Members mem1 = new Members();
		Members mem1 = new Members("gloo","female",18);
		m.addAttribute("members",mem1);
		return "members";
	}
	
	@RequestMapping(path = "/addMembers",method = RequestMethod.POST)
	public String processAction(@ModelAttribute("members") Members mem2,BindingResult result,Model m2) {
		if(result.hasErrors()) {
			return "membersError";
		}
		
		m2.addAttribute("mName",mem2.getMemberName());
		m2.addAttribute("mGender", mem2.getGender());
		m2.addAttribute("mAge", mem2.getAge());
		
		return "membersResult";
	}
	
}
