package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Student;

@Repository
@Transactional
public class EmpDAO {
//	@Autowired
//	private SessionFactory sf;
//	
//	private Session getSessionFactory() {
//		return sf.getCurrentSession();
//	}
//	
//	public void save(Student student) {
//		getSessionFactory().save(student);
//	}
//	
//	public void delete(Student student) {
//		getSessionFactory().delete(student);
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<Student> getAllUsers(){
//		return getSessionFactory().createQuery("from student")
//				.list();
//	}
//	
//	public void update(Student student) {
//		getSessionFactory().update(student);
//	    return;
//	  }
}
