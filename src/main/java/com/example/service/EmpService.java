package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Emp;


public interface EmpService {
	public void createEmp(Emp emp);
	public List<Emp> getUser();
	public Emp findById(int id);
	public Emp update(Emp emp, int id);
	public void delete(int id);
	public Emp updatePartially(Emp emp, int id);
}