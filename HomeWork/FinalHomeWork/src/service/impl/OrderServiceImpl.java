package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.impl.OrderDaoImpl;
import model.Order;
import service.OrderService;

public class OrderServiceImpl implements OrderService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static OrderDaoImpl odi=new OrderDaoImpl();
	//新增
	public void addOrder(Order o) {
		odi.add(o);
	}
	//查詢
	public List<Order> findAll(){
		return odi.selectAll();
		
	}
	//更新
	public void updateOrder(int orderno,int black,int green,int coffee)
	{
		
		Order o=new Order(black,green,coffee);
		
		
		o.setOrderno(orderno);
		o.getSum();
		
		
		
		odi.update(o);
		
		
		
		
		
	}
	//刪除
	@Override
	public void deleteOrder(int orderno) {
		
		odi.delete(orderno);
		
	}
	
	

}
