package com.bridgelabz.employeepayrollapp.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmployeePayrollException extends RuntimeException {
	private int StatusCode;
	private String Statusmessage;

	public EmployeePayrollException(int statusCode, String statusmessage) {
		super(statusmessage);
		StatusCode = statusCode;
		Statusmessage = statusmessage;
	}
}
