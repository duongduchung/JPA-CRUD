package com.howtodoinjava.demo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.howtodoinjava.demo.model.EmployeeEntity;
 
@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDao 
{
    @PersistenceContext
    private EntityManager manager;
     
    public List<EmployeeEntity> getAllEmployees() 
    {
        List<EmployeeEntity> employees = manager.createQuery("Select a From EmployeeEntity a", EmployeeEntity.class).getResultList();
        return employees;
    }
}
