package changmin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		sql += "	(orderafterno, pay_method, merchant_uid, prodname, amount, buyer_email, buyer_name, buyer_tel, buyer_addr, orderno, orderprocess, orderdate)";
		sql += "	VALUES";
		sql += "	(user_orderafter_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, '결제완료', trim(to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss')))";
		
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
			ps.setInt(9, order.getOrderno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println(order.getOrderprocess());
		return res;
	}


	@Override
	public List<Order> orderList(Connection conn) {
		String sql = "";
		sql+="SELECT orderafterno, pay_method, prodname, amount, buyer_email, buyer_name, buyer_addr, orderdate";
		sql+="	FROM user_orderafter";
		sql+="	ORDER BY orderafterno desc";
		
		List<Order> orderList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Order o = new Order();
				o.setOrderafterno(rs.getInt("orderafterno"));
				o.setPaymethod(rs.getString("pay_method"));
				o.setProdname(rs.getString("prodname"));
				o.setAmount(rs.getInt("amount"));
				o.setBuyeremail(rs.getString("buyer_name"));
				o.setBuyeraddr(rs.getString("buyer_addr"));
				o.setOrderdate(rs.getString("orderdate"));
				System.out.println("OrderDaoImpl orderdate : " + rs.getString("orderdate"));
//				o.setOrderdate(rs.getDate("orderdate"));
				
				orderList.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderList;
	}
}
