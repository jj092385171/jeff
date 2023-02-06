package com.campingmapping.team4.spring.t436mall.controller.web;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

@Controller
public class GCSController {
	private final Storage storage = StorageOptions.getDefaultInstance()
			.getService();

	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message",
					"Please select a file to upload.");
			return "redirect:/";
		}

		Bucket bucket = storage.get("my-bucket");
		try {
			bucket.create("data.txt", file.getBytes(), "text/plain");
		} catch (IOException e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message",
					"An error occurred while uploading the file.");
			return "redirect:/";
		}

		redirectAttributes.addFlashAttribute("message",
				"File uploaded successfully.");
		return "redirect:/";
	}
}
