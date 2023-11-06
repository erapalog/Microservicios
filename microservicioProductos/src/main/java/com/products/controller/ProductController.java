package com.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.products.Service.ProductService;
import com.products.entity.Product;
import com.products.utils.Autorizations;
import com.products.utils.Params;


@RestController
public class ProductController {
			
	@Autowired
	private ProductService productService;
	
	
	ResponseEntity<?> response = null;
	
	@GetMapping(value="/products/getall", produces= MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<?> customerGetAll() {
	
		
		List<Product> getAllProducts=null;
		
		try {
			getAllProducts = productService.getAllProducts();
			if(getAllProducts != null) {
				response = Autorizations.getResponseSuccess(getAllProducts, Params.MESSAGE_OK);
			}
			else {
				response = Autorizations.getResponseBadRequest(getAllProducts, Params.MESSAGE_BAD_REQUEST);
			}
		}catch(Exception ex){
			response = Autorizations.getResponseServerError(ex.getMessage());
        	
		}
		return response;
	}
	
	@GetMapping(value="/products/single/{productId}", produces= MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<?> customerGetAll(@PathVariable("productId") int productId) {
	
		
		Product product=null;
		
		try {
			product = productService.getSingleProduct(productId);
			if(product != null) {
				response = Autorizations.getResponseSuccess(product, Params.MESSAGE_OK);
			}
			else {
				response = Autorizations.getResponseBadRequest(product, Params.MESSAGE_BAD_REQUEST);
			}
		}catch(Exception ex){
			response = Autorizations.getResponseServerError(ex.getMessage());
        	
		}
		return response;
	}
	

}
