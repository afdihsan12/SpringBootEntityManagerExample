package com.etm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.etm.dao.StudentsDao;
import com.etm.model.Students;

@Service("studentService")
public class ServiceStudent {
	@Autowired
	StudentsDao stud;
	
	public Students findById(String id) {
		Students model = stud.findbyId(id);
		return model;
	}
	
	public Students findByname(String id) {
		Students model = stud.findbyname(id);
		return model;
	}
	
	public List<Students> findAll(){
		return stud.findAll();
	}
	
	public void insertModel(Students model) {
		stud.saveModel(model);
	}
	
	public void updateModel(Students model){
		stud.saveModel(model);
	}
	
	public void deleteModel(String id) {
		stud.deleteStudents(id);
	}
}
