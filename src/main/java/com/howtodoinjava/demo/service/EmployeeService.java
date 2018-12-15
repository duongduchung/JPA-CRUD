package com.howtodoinjava.demo.service;

import java.util.List;

import com.howtodoinjava.demo.model.EmployeeEntity;

public interface EmployeeService {

	public List<EmployeeEntity> getAll();
	
	public EmployeeEntity get(Integer employeeId);

	public EmployeeEntity create(EmployeeEntity employeeEntity);

	public EmployeeEntity update(Integer id, EmployeeEntity employeeEntity);

	public void delete(Integer employeeId);
}
