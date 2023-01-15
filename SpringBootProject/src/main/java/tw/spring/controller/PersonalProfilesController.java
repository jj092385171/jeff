package tw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.spring.model.PersonalProfiles;


@RestController
public class PersonalProfilesController {
	
	@Autowired
	private PersonalProfiles pp1;
	
	@GetMapping("/personalprofiles.controller")
	public PersonalProfiles processAction() {
		return pp1;
	}

}
