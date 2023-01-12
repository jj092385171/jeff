package tw.leonchen.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.leonchen.model.Animal;

@Controller
public class ReadAnimalController {
	private ArrayList<Animal> animals = new ArrayList<Animal>();

	public ReadAnimalController() {
		animals.add(new Animal(1,"monkey"));
		animals.add(new Animal(2,"rabbit"));
		animals.add(new Animal(3,"tiger"));
		animals.add(new Animal(4,"bird"));
		animals.add(new Animal(5,"elephant"));
		animals.add(new Animal(6,"cat"));
		animals.add(new Animal(7,"hipo"));
		animals.add(new Animal(8,"zebra"));
		animals.add(new Animal(9,"lion"));
	}
	
	@PostMapping("/readanimal.controller")
	@ResponseBody
	public List<Animal> processSearchAction(@RequestParam("keyword") String animalName){
		return searchAnimal(animalName);
	}

	private List<Animal> searchAnimal(String animalName) {
		ArrayList<Animal> results = new ArrayList<Animal>();
		
		for(Animal a:animals) {
			if(a.getAname().contains(animalName) && animalName.length()!=0) {
				results.add(a);
			}
		}
		
		return results;
	}

}
