package com.customers.Service;

import java.util.List;

import com.customers.entity.Customer;

public interface CustomerService {

	List<Customer> getAllCustomers();
	Customer getSingleCustomer(int customerId);
}
