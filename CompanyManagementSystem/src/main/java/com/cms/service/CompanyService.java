package com.cms.service;

import java.util.List;

//import org.springframework.stereotype.Service;

import com.cms.dto.CompanyDTO;
import com.cms.entity.Company;

public interface CompanyService {
	CompanyDTO addCompany(Company company);				// Adding Company Details
	
	List<CompanyDTO>getAllCompany();				// Display List Of All Company Details

	CompanyDTO getCompanyById(int id);			// Getting all company Details 

	CompanyDTO	updateCompany(int id, Company company);	// delete company details 

	String deleteCompany(int id);				//update company details

}
