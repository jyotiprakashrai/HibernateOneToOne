package com.jyoti.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="ADDRESSANNO")
public class AddressAnno {
	
	
	   @Id
	   @Column(name="txn_id", unique=true, nullable=false)
	   @GeneratedValue(generator="gen")
	   @GenericGenerator(name="gen", strategy="foreign", parameters={@Parameter(name="property", value="employeeAnno")})
	   private long id; 
	   
	   @Column(name="emp_city")
	   private String city;  
	   
	   @Column(name="emp_state")
	   private String state; 
	   
	   @OneToOne
	   @PrimaryKeyJoinColumn
	   private EmployeeAnno employeeAnno;
	   
	   
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public EmployeeAnno getEmployeeAnno() {
		return employeeAnno;
	}
	public void setEmployeeAnno(EmployeeAnno employeeAnno) {
		this.employeeAnno = employeeAnno;
	}
	

}
