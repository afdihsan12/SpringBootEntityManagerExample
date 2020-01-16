package com.etm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.etm.model.Students;
import com.etm.service.ServiceStudent;

@RestController
@Controller
public class StudentsController {
	
	
	public StudentsController(ServiceStudent serviceStudent) {
		super();
		this.serviceStudent = serviceStudent;
	}

	final private ServiceStudent serviceStudent;
	
	
	
	@PostMapping("/students") 
	public ResponseEntity<?> insert(@RequestBody Students model) {
		String password =model.getAlamat();
		String encodedPassword = new BCryptPasswordEncoder().encode(password);
		model.setAlamat(encodedPassword);
		try {
			serviceStudent.insertModel(model);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("Model Berhasil Ditambah");
	}
	
	@GetMapping("/students") 
	public ResponseEntity<?> getALl() {
		try {
			serviceStudent.findAll();
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceStudent.findAll());
	}
	
	@GetMapping("/students/{name}") 
	public ResponseEntity<?> getALl(@PathVariable String name) {
		try {
			serviceStudent.findByname(name);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceStudent.findByname(name));
	}
	

}
