package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity	
public class Sample {
	
	@Id
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
