package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

public @Data class ResponseDTO {
	private String message;
	private Object data;
	private int status;

	public ResponseDTO(int status, String message, Object data) {
		this.message = message;
		this.data = data;
		this.status=status;
	}

}