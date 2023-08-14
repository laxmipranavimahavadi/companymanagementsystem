package com.cms.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dto.CompanyDTO;
import com.cms.entity.Company;
import com.cms.service.CompanyService;
import com.cms.util.CompanyConverter;

@RestController

public class CompanyController 
{
	@Autowired
	CompanyService companyService ;
	
	@Autowired
	CompanyConverter companyConverter;
	
	@PostMapping("/addcompany")
	ResponseEntity<CompanyDTO> addCompany(@RequestBody @Valid CompanyDTO companyDTO)
	{ 
		
		Company company=companyConverter.convertToCompany(companyDTO);
		return new ResponseEntity<CompanyDTO>(companyService.addCompany(company),HttpStatus.CREATED);
	}
	@GetMapping("/getCompanyById/{id}")
	ResponseEntity<CompanyDTO> getCompanyById(@PathVariable int id)
	{
		return new ResponseEntity<CompanyDTO>(companyService.getCompanyById(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/getAllCompanies")
	ResponseEntity<List<CompanyDTO>> getCompanies()
	{
		return new ResponseEntity<List<CompanyDTO>>(companyService.getAllCompany(),HttpStatus.FOUND);
	}
	@PutMapping("/updateBook/{id}")
	ResponseEntity<CompanyDTO> updateBook(@PathVariable int id,@RequestBody CompanyDTO companyDTO)
	{
		Company company=companyConverter.convertToCompany(companyDTO);
		return new ResponseEntity<CompanyDTO>(companyService.updateCompany(id, company),HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/deleteCompanyById/{id}")
	ResponseEntity<String> deleteById(@PathVariable int id)
	{
		return new ResponseEntity<String>(companyService.deleteCompany(id),HttpStatus.OK);
	}
	
}


