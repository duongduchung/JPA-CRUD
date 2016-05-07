package com.howtodoinjava.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.howtodoinjava.demo.model.EmployeeEntity;


public interface EmployeeJPARepositoryCustom extends JpaRepository<EmployeeEntity, Integer>   {

	public List<EmployeeEntity> findByFirstNameContaining(String email);
}
