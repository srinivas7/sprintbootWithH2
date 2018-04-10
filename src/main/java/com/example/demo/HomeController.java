package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.repository.StudentJdbcRepository;

@RestController
public class HomeController {
	
	@Autowired
	StudentJdbcRepository repository;
	
//	@GetMapping
//	public String helloWorld() {
//		// TODO Auto-generated method stub
//		return "Srinivas";
//	}
	
	@RequestMapping("/some")
	@ResponseBody
	public void index() {
		repository.insert(new Student(10010, "John"));
	}
	  
}
