package com.bridgelabz.employeepayrollapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Day5EmployeePayrollAppProgramApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day5EmployeePayrollAppProgramApplication.class, args);
		log.info("EmployeePayRoll App  started");
	}

}
