package tw.spring.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRespository extends JpaRepository<Users, Integer> {
	
	@Query(value = "from Users where username like concat('%' ,?1, '%')")
	public List<Users> findAllusers(String name);
		
	public List<Users> findByUsernameLike(String username);
	
	@Query(value = "select * from Users",nativeQuery = true)
	public List<Users> findAll();
	
}
