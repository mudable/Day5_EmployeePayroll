package com.bridgelabz.employeepayrollapp.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@Service
public interface IEmploeePayrollService {

//	List<EmployeePayrollData> getEmployeesPayrollDataByDepartment(String department);

	ResponseDTO createEmployeePayrollData(@Valid EmployeePayrollDTO empPayrollDTO);

	ResponseDTO deleteEmployeeData(String token);

	EmployeePayrollData getEmployeePayrollDataById(String token);

	ResponseDTO updateEmployeePayrollData(String token, EmployeePayrollDTO empPayrollDTO);

	List<EmployeePayrollData> getallAllEmployee();

}
