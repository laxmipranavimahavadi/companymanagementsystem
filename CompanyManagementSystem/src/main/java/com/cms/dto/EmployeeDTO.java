package com.cms.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.Builder;
//import lombok.NoArgsConstructor;

@Data
//@Builder

public class EmployeeDTO {
	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}
	private int id;
	@NotBlank(message = "empty not allowed")
	@NotNull(message = "name is null")
	@Size(min = 3, max = 10, message = "Name must be within 3-10 characters")
	private String empName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Pattern(regexp="\\d{10}",message="Invalid MobileNumber")
	private String mobileNumber;
	@Email(message = "Invalid email format")

	private String email;
	@NotBlank(message = "Address Mandatory")
	private String address;
}

