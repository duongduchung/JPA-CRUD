package com.howtodoinjava.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table (name="employee")
public class EmployeeEntity
{ 
    @Id
    @GeneratedValue
    private Integer id;
     
    @NotEmpty
    private String firstName;
    private String lastName;
    private String email;
    private Integer salary;
    private String dayOfBirth;
    
    public EmployeeEntity() {}
       
    public EmployeeEntity(String name) {
        this.firstName = name;
    }
 
    @Override
    public String toString() {
        return "EmployeeVO [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", email=" + email
                + ", department="  + "]";
    }
    
    public Integer getId() {
    	return id;
    }
    
    public void setId(Integer id) {
    	this.id = id;
    }
    
    public String getFirstName() {
		return firstName;
	}
    
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }
    
    public String getLastName() {
		return lastName;
	}
    
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    
    public String getEmail() {
		return email;
	}
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public Integer getSalary() {
    	return salary;
    }
    
    public void setSalary(Integer salary) {
    	this.salary = salary;
    }
    
    public String getDayOfBirth() {
    	return dayOfBirth;
    }
    
    public void setDayOfBirth(String dayOfBirth) {
    	this.dayOfBirth = dayOfBirth;
    }
}
