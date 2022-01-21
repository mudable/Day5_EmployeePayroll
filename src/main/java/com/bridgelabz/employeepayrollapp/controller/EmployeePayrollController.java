package com.bridgelabz.employeepayrollapp.controller;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.IEmploeePayrollService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employeePayrollservice")
@Slf4j
/*
 * @RequestMapping:Used to set the class level URL.
 */
public class EmployeePayrollController {
	@Autowired
	private IEmploeePayrollService employeePayrollService;

	/*
	 * @RequestMapping:Used to take the URL for displaying message. return:message.
	 */
	@GetMapping("/getallcontact")
	ResponseEntity<List<?>> getallAllEmployee() {
		List<EmployeePayrollData> response = employeePayrollService.getallAllEmployee();
		return new ResponseEntity<List<?>>(response, HttpStatus.OK);
	}

	/*
	 * @PostMapping:used to pass the URL
	 * 
	 * @RequestBody:pass the object. return:created fields with the values.
	 */
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO) {
		log.debug("Employee DTO:" + empPayrollDTO.toString());
		ResponseDTO empData = null;
		empData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO(201, "Create Employee PayrollData:", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	/*
	 * @PutMapping:use to update the specified value. return:updated value.
	 */

	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO,
			@RequestHeader String token) {
		ResponseDTO respDTO = employeePayrollService.updateEmployeePayrollData(token, empPayrollDTO);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);

	}

	@DeleteMapping("/deletecontact")
	ResponseEntity<ResponseDTO> deleteEmployeeData(@RequestHeader String token) {
		ResponseDTO response = employeePayrollService.deleteEmployeeData(token);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@RequestHeader String token) {
		EmployeePayrollData employeePayrollData = employeePayrollService.getEmployeePayrollDataById( token);
		ResponseDTO respDTO = new ResponseDTO(200, "Get call for ID Successful:", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
//	@GetMapping("/Login")
//	public ResponseEntity<ResponseDTO> loginUser(@R) {
//		String userDetailUser = employeePayrollService.generateToken(loginData);
//		ResponseDTO responseDTO = new ResponseDTO("Create Call Success ", userDetailUser);
//		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
//
//	}

}