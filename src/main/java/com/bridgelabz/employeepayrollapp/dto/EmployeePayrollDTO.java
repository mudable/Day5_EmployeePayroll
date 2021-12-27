package com.bridgelabz.employeepayrollapp.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class EmployeePayrollDTO {
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$", message = "Invalid Employee name")
	@NotEmpty(message = "Employee name cannot null")
	public String name;
	@Min(value = 500, message = "min wage should be more than 500")
	public long salary;

	public EmployeePayrollDTO(String name, long salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeePayrollDTO [name=" + name + ", salary=" + salary + "]";
	}

}
