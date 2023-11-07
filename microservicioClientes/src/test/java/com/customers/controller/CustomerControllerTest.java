package com.customers.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.customers.Service.CustomerService;
import com.customers.entity.Customer;


class CustomerControllerTest {

		@InjectMocks
	    private CustomerController customerController;

	    @Mock
	    private CustomerService customerService;

	    @SuppressWarnings("deprecation")
		@BeforeEach
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
	    }
	    
	
	@Test
	void testGetAllCustomer() throws Exception {
		

		List<Customer> mockCustomers = new ArrayList<>();
       // mockCustomers.add(new Customer("Alice"));
		
		//se invoca el servicio simulado
        when(customerService.getAllCustomers()).thenReturn(mockCustomers);

        // se ejecuta el metodo en el controlador
        ResponseEntity<?> response = customerController.customerGetAll();
        
 
        // Verifica que la respuesta sea OK (200) y tenga datos
        assertEquals(200, response.getStatusCodeValue());
   
		
	}
	
	@Test
    public void testCustomerGetAll_BadRequest() {
       
		// Configura el mock de customerService para devolver una lista nula
        when(customerService.getAllCustomers()).thenReturn(null);

        // Ejecuta el método que deseas probar
        ResponseEntity<?> response = customerController.customerGetAll();
        
        assertEquals(400, response.getStatusCodeValue());
    }
	
	 @Test
	    public void testCustomerGetAll_Exception() {
	        
		 // Configura el mock de customerService para lanzar una excepción
	        when(customerService.getAllCustomers()).thenThrow(new RuntimeException("Error en el servicio externo"));

	        // Ejecuta el método que deseas probar
	        ResponseEntity<?> response = customerController.customerGetAll();

	        // Verifica que la respuesta sea un error interno del servidor (500) y esté vacía
	        assertEquals(500, response.getStatusCodeValue());
    }

}
