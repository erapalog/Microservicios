package com.customers.entity;

import java.util.ArrayList;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Orders {
	private int id;
	private int idCustomer;
	private Date date; 
	private ArrayList<OrderDetails> products;
}
