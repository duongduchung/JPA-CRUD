package com.howtodoinjava.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
 
   /* @Autowired
    EmployeeDao dao;
*/  
	@Autowired
	EmployeeRepository employeeRepository;
	
    public List<EmployeeEntity> getAll() {
      
    	return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity get(Integer employeeId) {
        return employeeRepository.findOne(employeeId);
    }

    @Override
    public EmployeeEntity create(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity update(Integer id, EmployeeEntity employeeEntity) {
        EmployeeEntity oldEmployee = employeeRepository.findOne(id);
        oldEmployee.setFirstName(employeeEntity.getFirstName());
        oldEmployee.setLastName(employeeEntity.getLastName());
        oldEmployee.setEmail(employeeEntity.getEmail());
        oldEmployee.setDayOfBirth(employeeEntity.getDayOfBirth());
        oldEmployee.setSalary(employeeEntity.getSalary());
    
        return employeeRepository.save(oldEmployee);
    }

    @Override
    public void delete(Integer employeeId) {
        employeeRepository.delete(employeeId);
    }
 
}
