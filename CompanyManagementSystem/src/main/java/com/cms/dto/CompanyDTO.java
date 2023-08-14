package com.cms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Builder
@NoArgsConstructor
public class CompanyDTO {

	private int id;
	
	//@NotBlank(message="Empty Not Allowed")
	@NotBlank(message = "Name Of the Company Is Not Null")
	@Size(min = 3, max = 10, message = "Name must be within 3-10 characters")
	private String companyName;
	
	@NotBlank(message = "Empty Not Allowed")
	private String address;
	
	@NotBlank(message = "Empty Not Allowed")
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}