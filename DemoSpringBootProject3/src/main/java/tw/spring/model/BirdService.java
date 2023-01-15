package tw.spring.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BirdService {
	
	@Autowired
	private BirdRepository bRepo;
	
	public Bird insert(Bird bird) {
		return bRepo.save(bird);
	}
	
	public Bird update(Bird bird) {
		return bRepo.save(bird);
	}
	
	public void deleteById(Integer id) {
		bRepo.deleteById(id);
	}
	
	public Bird findById(Integer id) {
		Optional<Bird> op = bRepo.findById(id);
		Bird b1 = null;
		
		if(op.isPresent()) {
			b1 = op.get();
		}
		
		return b1;
	}
	
}
