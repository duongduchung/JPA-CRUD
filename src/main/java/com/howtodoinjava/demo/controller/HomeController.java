package com.howtodoinjava.demo.controller;

import java.util.List;

import com.howtodoinjava.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
  @Autowired
  private EmployeeService employeeService;

  /**
     * Method will be called in initial page load at GET /employee-module
     * */
   @RequestMapping(value="/home", method = RequestMethod.GET)
   public ModelAndView setupForm() {
      ModelAndView model = new ModelAndView("listEmployeeView");
      model.addObject("lists", employeeService.getAll());
 		return model;
   }
 
}