package tw.spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(value = "aDao")
public class AnimalDao implements IAnimalDao{
	
	@Autowired
	private Animal animal;
	
	@Override
	public void showInfo() {
		System.out.println("ID:" + animal.getId());
		System.out.println("Name:" + animal.getName());
		System.out.println("Continent:" + animal.getContinent());
	}
	
}
