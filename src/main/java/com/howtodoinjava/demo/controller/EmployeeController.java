package com.howtodoinjava.demo.controller;

import java.util.List;

import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET, 
                    produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeEntity>> getAll() {
    	return new ResponseEntity<List<EmployeeEntity>>(employeeService.getAll(), HttpStatus.OK);
    }  

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> get(@PathVariable(value = "id") Integer id) {
    	return new ResponseEntity<EmployeeEntity>(employeeService.get(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST, 
                    produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody EmployeeEntity todoEntity) {
    	return new ResponseEntity<EmployeeEntity>(employeeService.create(todoEntity), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT, 
                    produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable(value = "id") Integer id,
    								@RequestBody EmployeeEntity todoEntity) {
    	return new ResponseEntity<EmployeeEntity>(employeeService.update(id, todoEntity), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE, 
                    produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
    	employeeService.delete(id);
    	return new ResponseEntity<Void>(HttpStatus.OK);
    }
}