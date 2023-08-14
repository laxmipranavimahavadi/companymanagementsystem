package com.cms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.cms.dto.CompanyDTO;
import com.cms.entity.Company;

@Component
public class CompanyConverter {
	public Company convertToCompany(CompanyDTO companyDTO)
	{
		Company company=new Company();
		if (companyDTO!=null)
		{
			BeanUtils.copyProperties(companyDTO, company);
		}
		return company;
		
	}

	//converting entity to DTO
	public CompanyDTO convertToCompanyDTO(Company company)
	{
		CompanyDTO companyDTO=new CompanyDTO();
		if (company!=null)
		{
			BeanUtils.copyProperties(company, companyDTO);
		}
		return companyDTO;
		
	}
}
 