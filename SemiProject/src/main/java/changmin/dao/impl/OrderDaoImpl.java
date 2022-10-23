package changmin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import changmin.dao.face.OrderDao;
import changmin.dto.Order;

public class OrderDaoImpl implements OrderDao{

	private PreparedStatement ps;
	private ResultSet rs;
	

	@Override
	public Order orderinsert(Connection conn) {
		System.out.println("OrderDaoImpl - Start");
		
		String sql="";
		
		sql+="INSERT INTO VALUES";
		
		
		
		return null;
	}

}
