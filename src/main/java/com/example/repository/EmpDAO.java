package com.example.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.Emp;


public interface EmpDAO {
	public void addEmp(Emp emp);
	public List<Emp> getEmp();
	public Emp findById(int id);
	public Emp update(Emp emp, int id);
	public Emp updateCountry(Emp emp, int id);
	public void delete(int id);
}

