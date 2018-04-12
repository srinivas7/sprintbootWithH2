package com.example.service;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.model.Emp;


public class EmpServiceImpl {
	@Autowired
	EmpService empService;


	public List<Emp> getUser() {
		// TODO Auto-generated method stub
		return empService.getUser();
	}

	public Emp findById(int id) {
		// TODO Auto-generated method stub
		return empService.findById(id);
	}

	public void createEmp(Emp emp) {
		// TODO Auto-generated method stub
		empService.createEmp(emp);
	}

	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		empService.delete(id);
	}

	public Emp update(Emp emp,int id) {
		return empService.update(emp, id);
	}
}
