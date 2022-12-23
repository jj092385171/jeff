package tw.leonchen.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "aService")
public class AnimalService implements IAnimalService{
	
	@Autowired
	private AnimalDao aDao;
	
	@Override
	public void showInfo() {
		aDao.showInfo();
	}

}
