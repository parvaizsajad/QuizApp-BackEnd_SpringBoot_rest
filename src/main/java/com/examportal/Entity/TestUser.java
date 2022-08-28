package com.examportal.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TestUser [id=" + id + ", name=" + name + "]";
	}

	public TestUser(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public TestUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
