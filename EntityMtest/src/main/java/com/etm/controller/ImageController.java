package com.etm.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.etm.model.ImageModel;
import com.etm.repository.ImageRepository;

@RestController
public class ImageController {

	@Autowired
	ImageRepository imageRepository;
	
	@PostMapping("/upload")
	public ResponseEntity<?> saveImage(@RequestPart MultipartFile[] upload ) throws IOException {
		byte[] byteArr = upload[0].getBytes();
		ImageModel image = new ImageModel();
		image.setPic(byteArr);
		image.setType(upload[0].getContentType());
		image.setId((long) 5);
		String base64encd = Base64.getEncoder().encodeToString(byteArr);
//		String filename = upload[0].getOriginalFilename();
//		String fileLocation = new File("/static/image") + "\\"+filename;
//		FileOutputStream fos = new FileOutputStream(fileLocation);
//		fos.write(byteArr);
//		fos.close();
		imageRepository.save(image);
		return ResponseEntity.ok(base64encd);
	}
	
	
	
}
