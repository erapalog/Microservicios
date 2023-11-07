package com.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orders.Service.OrdersService;
import com.orders.entity.Order;
import com.orders.utils.Autorizations;
import com.orders.utils.Params;


@RestController
public class OrdersController {
			
	@Autowired
	private OrdersService orderService;
	
	
	ResponseEntity<?> response = null;
	
	@GetMapping(value="/orders/getall", produces= MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<?> customerGetAll() {
	
		
		List<Order> getAllOrders=null;
		
		try {
			getAllOrders = orderService.getAllOrders();
			if(getAllOrders != null) {
				response = Autorizations.getResponseSuccess(getAllOrders, Params.MESSAGE_OK);
			}
			else {
				response = Autorizations.getResponseBadRequest(getAllOrders, Params.MESSAGE_BAD_REQUEST);
			}
		}catch(Exception ex){
			response = Autorizations.getResponseServerError(ex.getMessage());
        	
		}
		return response;
	}
	
	@GetMapping(value="/orders/single/{orderId}", produces= MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<?> customerGetAll(@PathVariable("orderId") int orderId) {
	
		
		Order order=null;
		
		try {
			order = orderService.getSingleOrder(orderId);
			if(order != null) {
				response = Autorizations.getResponseSuccess(order, Params.MESSAGE_OK);
			}
			else {
				response = Autorizations.getResponseBadRequest(order, Params.MESSAGE_BAD_REQUEST);
			}
		}catch(Exception ex){
			response = Autorizations.getResponseServerError(ex.getMessage());
        	
		}
		return response;
	}
	
	@PostMapping(value="/orders/add", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addNewOrder(@RequestBody Order newOrder){
		Order addNewOrderResponse=null;
		try {
			addNewOrderResponse = orderService.addNewOrder(newOrder);
			if(addNewOrderResponse != null) {
				response = Autorizations.getResponseSuccess(addNewOrderResponse, Params.MESSAGE_OK);			
			}
			else {
				response = Autorizations.getResponseBadRequest(null, Params.MESSAGE_BAD_REQUEST);
			}
		}catch(Exception ex){
			response = Autorizations.getResponseServerError(ex.getMessage());        	
        	
		}
		return response;
	}
	
	@PostMapping(value="/orders/payment", produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> payments(@RequestBody Order payments){
		try {

			if(payments.getProducts().size() >0) {
				response = Autorizations.getResponseSuccess(null, Params.MESSAGE_PAY);			
			}
			else {
				response = Autorizations.getResponseBadRequest(null, Params.MESSAGE_BAD_REQUEST);
			}
		}catch(Exception ex){
			response = Autorizations.getResponseServerError(ex.getMessage());        	
        	
		}
		return response;
	}

}
