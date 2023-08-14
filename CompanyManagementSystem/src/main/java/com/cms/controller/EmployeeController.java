package com.cms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dto.EmployeeDTO;
import com.cms.entity.Employee;
import com.cms.exception.ResourceNotFoundException;
import com.cms.service.EmployeeService;
@RestController	
public class EmployeeController {
	@Autowired
	EmployeeService employeeService ;
	
	@PostMapping("/addEmployees")
	ResponseEntity<Employee> addEmployee(@RequestBody @Valid EmployeeDTO employeeDTO)
	{
		try
		{
		Employee employee=employeeService.addEmployee(employeeDTO);
		if(employee!=null)
		{
			return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
		}
		}
	
	catch(Exception e)
	{
		throw new ResourceNotFoundException("Employee data is not entered properly,check it");
	}
	return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
	}
}