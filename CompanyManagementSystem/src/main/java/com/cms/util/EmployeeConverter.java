package com.cms.util;

//import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.cms.dto.EmployeeDTO;
import com.cms.entity.Employee;


@Component
public class EmployeeConverter {

	public Employee convertToEmployee(EmployeeDTO employeeDTO)
	{
		Employee employee=new Employee();
		if (employeeDTO!=null)
		{
			BeanUtils.copyProperties(employeeDTO, employee);
		}
		return employee;
		
	}

	
	 public  EmployeeDTO convertToEmployeeDTO(Employee employee)
	{
		 EmployeeDTO employeeDTO= new EmployeeDTO();
		if (employee!=null)
		{
			BeanUtils.copyProperties(employee, employeeDTO);
		}
		return employeeDTO;
		
	}
}
