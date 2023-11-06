package com.customers.ServicesImp;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.customers.Service.CustomerService;
import com.customers.entity.Customer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@Service
public class CustomerServiceImp implements CustomerService{

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImp.class);
	private RestTemplate restTemplate;
	private Gson gson;
	
	@Value("${fakestoreapi.api.base.url}")
    private String baseUrl;
	
	@Value("${fakestoreapi.api.customers.get.all}")
    private String getAllCustomers;
	
	
	private @PostConstruct void init() {
		restTemplate = new RestTemplate();
		gson = new Gson();
	}
	
	
	
	@Override
	public List<Customer> getAllCustomers() {
		
		String appPath = baseUrl+getAllCustomers;
		List<Customer> response = null;
		try {
			HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            ResponseEntity<String> externalServiceResponse = restTemplate.exchange(appPath, HttpMethod.GET, null, String.class);
            
            if(externalServiceResponse.getStatusCode().is2xxSuccessful()) {
            	String json = externalServiceResponse.getBody();
            	response = gson.fromJson(json, new TypeToken<List<Customer>>() {}.getType());
            }
		}catch(Exception ex) {
			logger.info(ex.getMessage());
        	
		}
		return response;
	}

	@Override
	public Customer getSingleCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	


}
