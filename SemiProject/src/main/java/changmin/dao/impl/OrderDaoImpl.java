package changmin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import changmin.dao.face.OrderDao;
import changmin.dto.Order;
import common.JDBCTemplate;

public class OrderDaoImpl implements OrderDao{
 
	private PreparedStatement ps;
	private ResultSet rs;
	

	@Override
	public int insertOrder(Connection conn, Order order) {
		System.out.println(order.getPaymethod());
		String sql = "";
		sql += "INSERT INTO user_orderafter";
		sql += "	(orderafterno, pay_method, merchant_uid, prodname, amount, buyer_email, buyer_name, buyer_tel, buyer_addr, payno)";
		sql += "	VALUES";
		sql += "	(user_orderafter_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, order.getOrderafterno());
			ps.setString(1, order.getPaymethod());
			ps.setString(2, order.getMerchant_uid());
			ps.setString(3, order.getProdname());
			ps.setInt(4, order.getAmount());
			ps.setString(5, order.getBuyeremail());
			ps.setString(6, order.getBuyername());
			ps.setString(7, order.getBuyertel());
			ps.setString(8, order.getBuyeraddr());
			ps.setInt(9, order.getPayno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println(order.getOrderprocess());
		return res;
	}
}
