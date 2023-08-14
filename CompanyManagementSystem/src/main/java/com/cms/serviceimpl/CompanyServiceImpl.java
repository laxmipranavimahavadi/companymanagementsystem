package com.cms.serviceimpl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.dto.CompanyDTO;
import com.cms.entity.Company;
import com.cms.repository.CompanyRepository;
import com.cms.service.CompanyService;
import com.cms.util.CompanyConverter;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	CompanyConverter companyConverter;

	@Override
	public CompanyDTO addCompany(Company company) {
		Company c=companyRepository.save(company);
		return companyConverter.convertToCompanyDTO(c);
	}

	@Override
	public List<CompanyDTO> getAllCompany() {
	List<Company>company=companyRepository.findAll();
	
	//List of DTO type
	List<CompanyDTO> dtoList=new ArrayList<>();
	for(Company co:company)
	{
		dtoList.add(companyConverter.convertToCompanyDTO(co));
	}
		return dtoList;
	}

	@Override
	public CompanyDTO getCompanyById(int id) {
		Company company=companyRepository.findById(id).get();
		return companyConverter.convertToCompanyDTO(company);
	}

	@Override
	public CompanyDTO updateCompany(int id, Company company) {
		Company c=companyRepository.findById(id).get();
		c.setCompanyName(company.getCompanyName());
		c.setAddress(company.getAddress());
		c.setEmail(company.getEmail());
		Company co=companyRepository.save(c);
		return companyConverter.convertToCompanyDTO(co);
	}

	@Override
	public String deleteCompany(int id) {
		companyRepository.deleteById(id);
		
		return "Company details got deleted successfuly";
	}
	

}
