package tw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.spring.model.Profiles;
import tw.spring.model.ProfilesService;

@Controller
public class RestCrudController {
	
	@Autowired
	private ProfilesService pService;
	
	@PostMapping("/profiles1")
	@ResponseBody
	public Profiles processInsertAction2(@RequestBody Profiles p) {
		return pService.insert(p);
	}
	
	@PostMapping("/profiles")
	@ResponseBody
	public String processInsertAction(@RequestParam("userName") String userName,
			@RequestParam("userAddress") String userAddress, @RequestParam("userPhone") String userPhone){
		
		Profiles p1 = new Profiles();
		p1.setName(userName);
		p1.setAddress(userAddress);
		p1.setPhone(userPhone);
		pService.insert(p1);
		
		return "Insert OK";
	}
	
	@GetMapping("/profiles/{pid}")
	@ResponseBody
	public String processQueryByIdAction(@PathVariable("pid") int pid) {
		Profiles resultBean = pService.findById(pid);
		
		if(resultBean != null) {
			return "Result:" + resultBean.getId() + " " + resultBean.getName() + " " + resultBean.getAddress() + " " + resultBean.getPhone();
		}
		
		return "no Result";
	}
	
	@PutMapping("/profiles/{pid}")
	@ResponseBody
	public String processUpdateAction(@PathVariable("pid") int pid,@RequestParam("userName") String userName,
			@RequestParam("userAddress") String userAddress, @RequestParam("userPhone") String userPhone ) {
		Profiles p2 = new Profiles(pid,userName,userAddress,userPhone);
		pService.update(p2);
		
		return "Update OK";
	}
	
	@DeleteMapping("/profiles/{pid}")
	@ResponseBody
	public String peocessDeleteAction(@PathVariable("pid") int pid,@RequestParam("userName") String userName,
			@RequestParam("userAddress") String userAddress, @RequestParam(name = "userPhone", required = false)@Nullable String userPhone ) {
		Profiles p3 = new Profiles(pid,userName,userAddress,userPhone);
		pService.delete(p3);
		
		return "Delete OK";
	}
	
}
