package com.example.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Emp;

public class EmpDAOImpl {
	@Autowired
	private SessionFactory sessionFactory;
	  
	public void addEmp(Emp emp) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		  session.save(emp); 
	}

	public List<Emp> getEmp() {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Emp> list= session.createCriteria(Emp.class).list();
		return list;
	}

	public Emp findById(int id) {
		// TODO Auto-generated method stub
		 Session session = sessionFactory.getCurrentSession();
		Emp emp=(Emp) session.get(Emp.class,id);
		return emp;
	}

	public Emp update(Emp val, int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Emp emp =(Emp)session.get(Emp.class, id);
		emp.setName(val.getName());
		session.update(emp);
		return emp;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Emp emp = findById(id);
		session.delete(emp);
	}
	
}
