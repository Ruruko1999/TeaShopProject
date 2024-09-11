package service;

import java.util.List;

import model.Order;

public interface OrderService {
	//create
	void addOrder(Order o);
	//read
	List<Order> findAll();
	
	//update
	void updateOrder(int orderno,int black,int green,int coffee);
	//delete
	void deleteOrder(int orderno);

}
