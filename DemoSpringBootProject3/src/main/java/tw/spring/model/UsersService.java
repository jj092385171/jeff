package tw.spring.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersService {

	@Autowired
	private UsersRespository uRepo;
	
	public List<Users> findAllusers(String name){
		return uRepo.findAllusers(name);
	}
	
	public List<Users> findByUsernameLike(String name){
		return uRepo.findByUsernameLike(name);
	}
	
	public List<Users> findAll(){
		return uRepo.findAll();
	}

	
}
