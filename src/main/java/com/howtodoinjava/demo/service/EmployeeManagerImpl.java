package com.howtodoinjava.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.dao.EmployeeJPARepository;
import com.howtodoinjava.demo.model.EmployeeEntity;



@Service
public class EmployeeManagerImpl implements EmployeeManager {
 
   /* @Autowired
    EmployeeDao dao;
*/  
	@Autowired
	EmployeeJPARepository employeeJPARepository;
	
    public List<EmployeeEntity> getAllEmployees() {
      
    	return employeeJPARepository.findAll();
    }
 
   
}
