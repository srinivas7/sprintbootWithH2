package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.model.Emp;
import com.example.repository.StudentJdbcRepository;
import com.example.service.EmpServiceImpl;

@RestController
public class HomeController {
	
//	@Autowired
//	StudentJdbcRepository repository;
	
	@Autowired
	EmpServiceImpl empServiceImpl;
	
	@GetMapping
	public String helloWorld() {
		// TODO Auto-generated method stub
		return "Srinivas";
	}
	
	

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Emp> getEmpById(@PathVariable("id") int id) {
        System.out.println("Fetching Emp with id " + id);
        Emp emp = empServiceImpl.findById(id);
        if (emp == null) {
            return new ResponseEntity<Emp>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Emp>(emp, HttpStatus.OK);
    }
    
	 @PostMapping(value="/create",headers="Accept=application/json")
	 public ResponseEntity<Void> createEmp(@RequestBody Emp emp, UriComponentsBuilder ucBuilder){
	     System.out.println("Creating Emp "+emp.getName());
	     empServiceImpl.createEmp(emp);
	     HttpHeaders headers = new HttpHeaders();
	     headers.setLocation(ucBuilder.path("/emp/{id}").buildAndExpand(emp.getId()).toUri());
	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }

//	 @GetMapping(value="/get", headers="Accept=application/json")
//	 public List<Emp> getAllEmp() {	 
//	  List<Emp> tasks=empService.getEmp();
//	  return tasks;
//	
//	 }

	@PutMapping(value="/update", headers="Accept=application/json")
	public ResponseEntity<String> updateEmp(@RequestBody Emp currentEmp)
	{
		System.out.println("sd");
	Emp emp = empServiceImpl.findById(currentEmp.getId());
	if (emp==null) {
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	empServiceImpl.update(currentEmp, currentEmp.getId());
	return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", headers ="Accept=application/json")
	public ResponseEntity<Emp> deleteEmp(@PathVariable("id") int id){
		Emp emp = empServiceImpl.findById(id);
		if (emp == null) {
			return new ResponseEntity<Emp>(HttpStatus.NOT_FOUND);
		}
		empServiceImpl.deleteUserById(id);
		return new ResponseEntity<Emp>(HttpStatus.NO_CONTENT);
	}
	
	@PatchMapping(value="/{id}", headers="Accept=application/json")
	public ResponseEntity<Emp> updateEmpPartially(@PathVariable("id") int id, @RequestBody Emp currentEmp){
		Emp emp = empServiceImpl.findById(id);
		if(emp ==null){
			return new ResponseEntity<Emp>(HttpStatus.NOT_FOUND);
		}
		Emp usr =	empServiceImpl.update(currentEmp, id);
		return new ResponseEntity<Emp>(usr, HttpStatus.OK);
	}
	  
}
