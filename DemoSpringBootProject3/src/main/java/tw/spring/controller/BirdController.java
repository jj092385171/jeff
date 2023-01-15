package tw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.spring.model.Bird;
import tw.spring.model.BirdService;

@RestController
public class BirdController {
	
	@Autowired
	private BirdService bService;
	
	@GetMapping("/birdinsert.controller")
	public Bird processAction() {
		Bird b1 = new Bird("mockingjay","orange","L",10);
		return bService.insert(b1);
	}
	
	@PostMapping("/birdinsert2.controller")
	public Bird processAction2(@RequestBody Bird b3) {
		return bService.insert(b3);
	}
	
	@GetMapping("birddelete.controller")
	public String processDeleteByIdAction() {
		bService.deleteById(102);
		return "OK";
	}
	
	@GetMapping("/birdqueryByid.controller")
	public Bird processFindByIdAction() {
		return bService.findById(100);
	}
	
	@GetMapping("/birdupdate.controller")
	public Bird processUpdateAction() {
		Bird b2 = new Bird("mockingjay","red","M",11);
		return bService.update(b2);
	}
}
