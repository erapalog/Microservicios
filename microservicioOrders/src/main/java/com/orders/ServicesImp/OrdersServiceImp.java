package com.orders.ServicesImp;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orders.Service.OrdersService;
import com.orders.entity.Order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@Service
public class OrdersServiceImp implements OrdersService{

	private static final Logger logger = LoggerFactory.getLogger(OrdersServiceImp.class);
	private RestTemplate restTemplate;
	private Gson gson;
	
	@Value("${fakestoreapi.api.base.url}")
    private String baseUrl;
	
	@Value("${fakestoreapi.api.orders.path}")
    private String ordersPath;
	
	@Value("${fakestoreapi.api.orders.get.single}")
    private String getSingleOrderPath;
	
	private @PostConstruct void init() {
		restTemplate = new RestTemplate();
		gson = new Gson();
	}
	
	@Override
	public List<Order> getAllOrders() {
		String appPath = baseUrl+ordersPath;
		List<Order> response = null;
		try {
			HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            
            ResponseEntity<String> externalServiceResponse = restTemplate.exchange(appPath, HttpMethod.GET, null, String.class);
            
            if(externalServiceResponse.getStatusCode().is2xxSuccessful()) {
            	String json = externalServiceResponse.getBody();
            	response = gson.fromJson(json, new TypeToken<List<Order>>() {}.getType());
            }
		}catch(Exception ex) {
			logger.info(ex.getMessage());
        	
		}
		return response;
	}

	@Override
	public Order getSingleOrder(int orderId) {
		String singleCartsAddOrderIdPath = String.format(getSingleOrderPath, orderId);
		String appPath = baseUrl+singleCartsAddOrderIdPath;
		Order response = null;
		try {
			HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            
            ResponseEntity<String> externalServiceResponse = restTemplate.exchange(appPath, HttpMethod.GET, null, String.class);
            
            if(externalServiceResponse.getStatusCode().is2xxSuccessful()) {
            	String json = externalServiceResponse.getBody();
            	response = gson.fromJson(json, Order.class);
            }
		}catch(Exception ex) {
			logger.info(ex.getMessage());
        	
		}
		return response;
	}

	@Override
	public Order addNewOrder(Order newOrder) {
		String appPath = baseUrl+ordersPath;
		Order response = null;
		try {
			HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            
            String jsonRequest = gson.toJson(newOrder);
            HttpEntity<String> requestEntity = new HttpEntity<>(jsonRequest, headers);
            
            ResponseEntity<String> externalServiceResponse = restTemplate.exchange(appPath, HttpMethod.POST, requestEntity, String.class);
            
            if(externalServiceResponse.getStatusCode().is2xxSuccessful()) {
            	String json = externalServiceResponse.getBody();
            	response = gson.fromJson(json, Order.class);
            }
		}catch(Exception ex) {
			logger.info(ex.getMessage());
        	
		}
		return response;
	}
	
	


}
