package com.customers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Product {
	private int id;
	private String title;
	private String description;
	private double price;
	private int category;
	private int state;
}
