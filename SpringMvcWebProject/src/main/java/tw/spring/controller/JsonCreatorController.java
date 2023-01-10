package tw.spring.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.spring.model.House;


@Controller
public class JsonCreatorController {
	
	@GetMapping("/jsoncreator.controller")
	@ResponseBody
	public String processJsonAction() throws JsonProcessingException {
		House hBean1 = new House();
		hBean1.setHouseid(1001);
		hBean1.setHousename("happy house");
		
		ObjectMapper om1 = new ObjectMapper();
		String jsonStr = om1.writeValueAsString(hBean1);
		
		House resultBean = om1.readValue(jsonStr, House.class);
		System.out.println(resultBean.getHouseid() + ":" + resultBean.getHousename());
		
		return "jsonStr:" + jsonStr;
	}
	
	@GetMapping("/jsoncreator2.controller")
	@ResponseBody
	public House processJsonAction2() throws JsonProcessingException {
		House hBean1 = new House();
		hBean1.setHouseid(1001);
		hBean1.setHousename("happy house");		
		return hBean1;
	}
	
	@PostMapping("/jsoncreator4.controller")
	@ResponseBody
	public House processJsonAction4() throws JsonProcessingException {
		House hBean1 = new House();
		hBean1.setHouseid(1001);
		hBean1.setHousename("happy house");		
		return hBean1;
	}
	
	@GetMapping("/jsoncreator3.controller")
	@ResponseBody
	public ArrayList<House> processJsonAction3() throws JsonProcessingException {
		
		House hBean1 = new House();
		hBean1.setHouseid(1001);
		hBean1.setHousename("happy house");	
		
		House hBean2 = new House();
		hBean2.setHouseid(1002);
		hBean2.setHousename("fashion house");
		
		ArrayList<House> list = new ArrayList<House>();
		list.add(hBean1);
		list.add(hBean2);
		
		return list;
	}

}
