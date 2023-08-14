package com.cms.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.entity.Company;




	public interface CompanyRepository extends JpaRepository<Company,Integer> 
	{
		//List<Company> findByCompany(String Company);  //select * from where address = ?
		//List<Company> findByNameAndCompany(String name, String Company);


}
