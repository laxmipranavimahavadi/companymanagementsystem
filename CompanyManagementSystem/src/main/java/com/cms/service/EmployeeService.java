package com.cms.service;

import java.util.List;

import javax.validation.Valid;

import com.cms.dto.EmployeeDTO;
import com.cms.entity.Employee;

public interface EmployeeService {
	EmployeeDTO addEmployee(Employee employee);
	EmployeeDTO getEmployeeId(int id);
	List<EmployeeDTO>getAllEmployee();
	String deleteEmployee(int id);
	Employee addEmployee(EmployeeDTO employeeDTO);
	EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO);
}

