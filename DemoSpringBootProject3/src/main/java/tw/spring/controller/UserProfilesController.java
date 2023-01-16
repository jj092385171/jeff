package tw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.spring.model.UserProfiles;
import tw.spring.model.UserProfilesService;

@RestController
public class UserProfilesController {

	@Autowired
	private UserProfilesService userService;
	
	@PostMapping("/userprofilescreate.controller")
	public UserProfiles processVreateUserProfilesAction(@RequestBody UserProfiles uProfiles) {
		String encodePwd = new BCryptPasswordEncoder().encode(uProfiles.getPassword());
		uProfiles.setPassword(encodePwd);
		return userService.createUserProfiles(uProfiles);
	}
}
