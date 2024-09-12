package dao;

import java.util.List;

import model.Member;
import model.Order;

public interface OrderDao {
		//create
		void add(Order o);
		
		
		
		//read
		List<Order> selectAll();
		List<Order> selectOrderno(int Orderno);	
		
		
		
		//update
		void update(Order o);
		
		
		//delete
		void delete(int orderno);
}
