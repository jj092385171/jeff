package tw.spring.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfilesRepository extends JpaRepository<UserProfiles, Integer> {
	
	public Optional<UserProfiles> findByName(String name);
	
}
