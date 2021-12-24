package com.bridgelabz.employeepayrollapp.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@Service
class EmployeePayrollService implements IEmploeePayrollService {

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		List<EmployeePayrollData> empDataList = new ArrayList<>();
		empDataList.add(new EmployeePayrollData(1, new EmployeePayrollDTO("Sakshi", 5000)));
		return empDataList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1, new EmployeePayrollDTO("Reshma", 40000));
		return empData;
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1, empPayrollDTO);
		return empData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(1, empPayrollDTO);
		return empData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {

	}
}