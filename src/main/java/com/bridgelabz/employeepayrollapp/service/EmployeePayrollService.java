package com.bridgelabz.employeepayrollapp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollExceptionHandler;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import com.bridgelabz.employeepayrollapp.utility.TokenUtil;
import org.modelmapper.ModelMapper;
import lombok.extern.slf4j.Slf4j;

@Service
public class EmployeePayrollService implements IEmploeePayrollService {
	@Autowired
	private EmployeePayrollRepository employeePayrollRepository;
	@Autowired
	private TokenUtil tokenutil;
	@Autowired
	ModelMapper modelmapper;

	@Override
	public List<EmployeePayrollData> getallAllEmployee() {
		//int employeeId = tokenutil.decodeToken();
		//Optional<EmployeePayrollData> isContactPresent = employeePayrollRepository.findById(employeeId);
//		if (isContactPresent.isPresent()) {
//			List<EmployeePayrollData> getallcontacts = employeePayrollRepository.findAll();
//			return getallcontacts;
//		} else {
//			throw new EmployeePayrollException(400, "Token is not valid!!");
//		}
		return employeePayrollRepository.findAll();
	}
	@Override
	public EmployeePayrollData getEmployeePayrollDataById( String token) {
		int id = tokenutil.decodeToken(token);
		Optional<EmployeePayrollData> isEmployeePresent = employeePayrollRepository.findById(id);
		if (isEmployeePresent.isPresent()) {
			return employeePayrollRepository.findById(id)
					.orElseThrow(() -> new EmployeePayrollException(200,"employee ID Not Found"));
		} else
			throw new EmployeePayrollException(400,"Not Valid Token");
	}

//	@Override
//	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
//		EmployeePayrollData empData = null;
//		empData = new EmployeePayrollData(empPayrollDTO);
//		log.debug("Employee Data: " + empData.toString());
//		return employeePayrollRepository.save(empData);
//	}
	public ResponseDTO createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		Optional<EmployeePayrollData> isPresent = employeePayrollRepository.findByEmailId(empPayrollDTO.getEmailId());
		if (isPresent.isPresent()) {
			throw new EmployeePayrollException(400, "Contact Already Added");
		} else {
			EmployeePayrollData contact = modelmapper.map(empPayrollDTO, EmployeePayrollData.class);
			employeePayrollRepository.save(contact);
			String token = tokenutil.createToken(contact.getEmployeeId());
			return new ResponseDTO(200, "Contact Succefully Added", token);
		}

	}

	@Override
	public ResponseDTO updateEmployeePayrollData(String token, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(token);
		int id = tokenutil.decodeToken(token);
		Optional<EmployeePayrollData> isEmployeePresent = employeePayrollRepository.findById(id);
		if (isEmployeePresent.isPresent()) {
			empData.updateEmployeePayollData(empPayrollDTO);
			employeePayrollRepository.save(isEmployeePresent.get());
			return new ResponseDTO(200,"Contact Succefully Updated", empData);
		} else {
			throw new EmployeePayrollException(400, "Token is not valid!!");
		}

	}

	@Override
	public ResponseDTO deleteEmployeeData(String token) {
		int employeeId = tokenutil.decodeToken(token);
		Optional<EmployeePayrollData> isContactPresent = employeePayrollRepository.findById(employeeId);
		if (isContactPresent.isPresent()) {
			employeePayrollRepository.delete(isContactPresent.get());
			return new ResponseDTO(200, "Contact Succefully deleted",employeeId);

		} else {
			throw new EmployeePayrollException(400, "Contact is not preset!!");
		}
	}

//	@Override
//	public List<EmployeePayrollData> getEmployeesPayrollDataByDepartment(String department) {
//		return employeePayrollRepository.findEmployeesByDepartment(department);
//	}
}