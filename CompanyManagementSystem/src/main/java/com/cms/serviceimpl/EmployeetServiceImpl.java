package com.cms.serviceimpl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dto.EmployeeDTO;
import com.cms.entity.Employee;
import com.cms.repository.EmployeeRepository;
import com.cms.service.EmployeeService;
import com.cms.util.EmployeeConverter;

@Service
public class EmployeetServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EmployeeConverter employeeConverter;
	
	@Override
	public EmployeeDTO addEmployee(Employee employee) {
		Employee e= employeeRepository.save(employee);
		return employeeConverter.convertToEmployeeDTO(e);
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {
		List<Employee>Employees=employeeRepository.findAll();
		List<EmployeeDTO> dtoList=new ArrayList<>();
		for(Employee e:Employees)
		{
			dtoList.add(employeeConverter.convertToEmployeeDTO(e));
		}
return dtoList;
	}

	@Override
	public EmployeeDTO getEmployeeId(int id) {
		Employee employee=employeeRepository.findById(id).get();
		return employeeConverter.convertToEmployeeDTO(employee);
	}

	
	@Override
	public EmployeeDTO updateEmployee(int id, EmployeeDTO employeeDTO) {
		Employee e=employeeRepository.findById(id).get();
				e.setEmpName(employeeDTO.getEmpName());
				e.setMobileNumber(employeeDTO.getMobileNumber());
				e.setAddress(employeeDTO.getAddress());
				e.setEmail(employeeDTO.getEmail());
		return employeeConverter.convertToEmployeeDTO(e);
		
	}

	@Override
	public String deleteEmployee(int id) {
		employeeRepository.deleteById(id);	
		return "Sucessfullu Deleted Employeerecord";
	}

	@Override
	public Employee addEmployee(EmployeeDTO employeeDTO) {
		Employee employee=Employee.builder()
				.id(employeeDTO.getId())
				.empName(employeeDTO.getEmpName())
				//.employeeName(employeeDTO.getEmployeeName())
				.mobileNumber(employeeDTO.getMobileNumber())
				.email(employeeDTO.getEmail())
				.address(employeeDTO.getAddress())
				.build();
		
		return employeeRepository.save(employee);
	}

	
}
