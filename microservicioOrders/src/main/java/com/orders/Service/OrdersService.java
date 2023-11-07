package com.orders.Service;

import java.util.List;

import com.orders.entity.Order;

public interface OrdersService {

	List<Order> getAllOrders();
	Order getSingleOrder(int orderId);
	Order addNewOrder(Order newOrder);
}
