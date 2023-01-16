package tw.spring.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserProfilesService {
	
	@Autowired
	private UserProfilesRepository userRepo;
	
	public UserProfiles getByName(String name) {
		Optional<UserProfiles> op1 = userRepo.findByName(name);
		
		if(op1.isEmpty()) {
			throw new UserNotFoundException("Can't find user");
		}
		
		return op1.get();
	}
	
	public UserProfiles createUserProfiles(UserProfiles up1) {
		return userRepo.save(up1);
	}
}
