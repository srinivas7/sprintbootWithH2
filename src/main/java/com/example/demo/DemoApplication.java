package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.repository.StudentJdbcRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
@EntityScan("com")
@EnableJpaRepositories("com")
public class DemoApplication {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentJdbcRepository repository;
		
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
//	public void run(String... args) throws Exception {
//
//		System.out.println("before...");
//		logger.info("Inserting -> {}", repository.insert(new Student(10010, "John")));
//		System.out.println("after...");
//
////		logger.info("Update 10003 -> {}", repository.update()));
//		
//		logger.info("update data.....{}", repository.update(new Student(1000,"asdf")));
//
//		//repository.deleteById(10002L);
//
//		//logger.info("All users -> {}", repository.findAll());
//	}
}
