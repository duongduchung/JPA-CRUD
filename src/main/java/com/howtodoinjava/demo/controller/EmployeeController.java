package com.howtodoinjava.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.service.EmployeeManager;

@Controller
@RequestMapping("/")
public class EmployeeController
{
    @Autowired
    EmployeeManager manager;
     
  /**
     * Method will be called in initial page load at GET /employee-module
     * */
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public ModelAndView setupForm() 
    {
    	 List<EmployeeEntity> employees = manager.getAllEmployees();
    	 for (EmployeeEntity employ : employees) {
    		 System.out.println("First Name " + employ.getFirstName() + " Last Name " + employ.getLastName());
    	 }
    	//model.addObject("allEmployees",employees);
    	 ModelAndView model = new ModelAndView("listEmployeeView");
 		 model.addObject("lists", employees);

 		return model;
       // return "listEmployeeView";
    }
 
   
}