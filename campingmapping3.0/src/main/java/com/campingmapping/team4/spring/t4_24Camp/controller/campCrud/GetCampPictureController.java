package com.campingmapping.team4.spring.t4_24Camp.controller.campCrud;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campingmapping.team4.spring.t4_24Camp.model.model.Camp;
import com.campingmapping.team4.spring.t4_24Camp.model.service.CampService;

@Controller
public class GetCampPictureController {
	
	@Autowired
	private CampService campService;

	@GetMapping(path = "/getCampPicture/{campID}", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public byte[] processByteArrayImageAction(HttpServletRequest request, HttpServletResponse response, @PathVariable("campID") int campID) throws IOException {
		Camp camp = campService.findCampByID(campID);
		String fileName = camp.getCampPicturesPath();
		
		InputStream in = request.getServletContext().getResourceAsStream("/WEB-INF/resources/images/" + fileName);
		return IOUtils.toByteArray(in);
	}
	
}
