package com.customers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customers.Service.CustomerService;
import com.customers.entity.Customer;
import com.customers.utils.Autorizations;
import com.customers.utils.Params;


@RestController
public class CustomerController {
			
	@Autowired
	private CustomerService customerService;
	
	
	ResponseEntity<?> response = null;
	
	@GetMapping(value="/customer/getall", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> customerGetAll() {
	
		
		List<Customer> getAllCustomersResponse=null;
		
		try {
			getAllCustomersResponse = customerService.getAllCustomers();
			if(getAllCustomersResponse != null) {
				response = Autorizations.getResponseSuccess(getAllCustomersResponse, Params.MESSAGE_OK);
			}
			else {
				response = Autorizations.getResponseBadRequest(getAllCustomersResponse, Params.MESSAGE_BAD_REQUEST);
			}
		}catch(Exception ex){
			response = Autorizations.getResponseServerError(ex.getMessage());
        	
		}
		return response;
	}

}
