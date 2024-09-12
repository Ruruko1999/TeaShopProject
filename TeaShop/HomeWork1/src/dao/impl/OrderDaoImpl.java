package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.OrderDao;
import model.Order;

public class OrderDaoImpl implements OrderDao {

	public static void main(String[] args) {
	new OrderDaoImpl().delete(27);
		
	}
	public void add(Order o) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into teashop.order (black,green,coffee,sum) values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			
			
			ps.setInt(1, o.getBlack());
			ps.setInt(2, o.getGreen());
			ps.setInt(3, o.getCoffee());
			ps.setInt(4, o.getSum());
			
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public List<Order> selectAll() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from teashop.order";
		List<Order> r=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Order o=new Order();
				o.setOrderno(rs.getInt("orderno"));
				o.setBlack(rs.getInt("black"));
				o.setGreen(rs.getInt("green"));
				o.setCoffee(rs.getInt("coffee"));
				o.setSum(rs.getInt("sum"));
				
				r.add(o);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return r;
	}
	@Override
	public List<Order> selectOrderno(int Orderno) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from teashop.order where orderno=?";
		List<Order> r=new ArrayList();
		try {
			PreparedStatement ps= conn.prepareStatement(SQL);
			ps.setInt(1, Orderno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Order o=new Order();
				o.setOrderno(rs.getInt("Orderno"));
				o.setBlack(rs.getInt("black"));
				o.setGreen(rs.getInt("green"));
				o.setCoffee(rs.getInt("coffee"));
				o.setSum(rs.getInt("sum"));
				r.add(o);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return r;
	}
	
	@Override
	public void update(Order o) {
		Connection conn=DbConnection.getDb();
		String SQL="update teashop.order set black=?,green=?,coffee=?,sum=? where orderno=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, o.getBlack());
			ps.setInt(2, o.getGreen());
			ps.setInt(3, o.getCoffee());
			ps.setInt(4, o.getSum());
			ps.setInt(5, o.getOrderno());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void delete(int orderno) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from teashop.order where orderno=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, orderno);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}

}
