package com.customers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class OrderDetails {
	private int id;
	private int idProduct;
	private int idOrders;
	private int state;
}
