package com.jyoti.hibernate.model;

public class Employee {
	
	   private long id;
	   private String name;   
	   private String email;
	   private Address address;
	   

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	 
}
