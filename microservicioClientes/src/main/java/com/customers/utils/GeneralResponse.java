package com.customers.utils;

import java.util.List;

import com.customers.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class GeneralResponse {

	
	private int status;
	private String message;
	private Object data;
	
	public GeneralResponse(Object data, int status, String message) {
		super();
		this.data = data;
		this.status = status;
		this.message = message;
	}
	
	public GeneralResponse() {}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
