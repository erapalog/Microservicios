package com.customers.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class OrderPayment {
	private int id;
	private int idOrder;
	private int pay ;
	private Date paymentDate;
	
}
