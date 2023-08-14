package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	//List<Employee> findByAddress(String address);  //select * from where address = ?
	//List<Employee> findByNameAndAddress(String name, String Address);

}
