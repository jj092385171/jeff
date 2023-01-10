package tw.spring.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadAjaxController {
	
	@PostMapping("/upload2.controller")
	@ResponseBody
	public String processUploadFileAction(@RequestParam("myFile") MultipartFile mf) throws IllegalStateException, IOException {
		String fileName = mf.getOriginalFilename();
		System.out.println("fileName:" + fileName);
		
		String saveFileDir = "c:/temp/test/upload/";
		File saveFile = new File(saveFileDir);
		saveFile.mkdirs();
		
		File saveFilePath = new File(saveFile, fileName);
		mf.transferTo(saveFilePath);
		System.out.println("saveFilePath1:" + saveFilePath);
		return "saveFilePath:" + saveFilePath;
	}

}
