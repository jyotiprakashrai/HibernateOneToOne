package com.jyoti.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="EMPLOYEEANNO")
public class EmployeeAnno {
	
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name="emp_id")
	    private long id;
	    
	    @Column(name="emp_name")
	    private String name;   
	    
	    @Column(name="emp_email")
	    private String email;
	    
	    @OneToOne(mappedBy="employeeAnno")
		@Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	    private AddressAnno addressAnno;
	    
	    
	    @Override
		public String toString() {
			return "EmployeeAnno [id=" + id + ", name=" + name + ", email=" + email + ", addressAnno=" + addressAnno
					+ "]";
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
		public AddressAnno getAddressAnno() {
			return addressAnno;
		}
		public void setAddressAnno(AddressAnno addressAnno) {
			this.addressAnno = addressAnno;
		}
		

}
