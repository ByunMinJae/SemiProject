package changmin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import changmin.dao.face.PayDoDao;
import changmin.dto.OrderBefore;
import common.JDBCTemplate;
import sharon.dto.User;

public class PayDoDaoImpl implements PayDoDao{

	private PreparedStatement ps = null;
	private ResultSet rs;
	


	@Override
	public User getUserInfo(Connection conn, int userno) {
		System.out.println("UserDAO - 시작");
		
		String sql = "";
		
		sql+="SELECT";
		sql+="	userno, username, address, phone, email ";
		sql+="	FROM user_info";
		sql+="	WHERE userno=?";

		User user = new User();

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userno);
			 
			rs = ps.executeQuery();
			
			
			while( rs.next() ) {
				
				user.setUserno( rs.getInt("userno"));
				user.setUsername( rs.getString("username"));
				user.setAddress( rs.getString("address"));
				user.setPhone( rs.getString("phone"));
				user.setEmail( rs.getString("email"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("UserDAO - 끝");
		
		return user;
	}



//	@Override
//	public OrderBefore getOrderInfo(Connection conn, int orderno) {
//		System.out.println("OrderBeforeDao - Start");
//		
//		String sql = "";
//		
//		sql+= "SELECT";
//		sql+= " orderno, buyprodname, totalamount";
//		sql+= " FROM user_orderbefore";
//		sql+= " WHERE orderno=?";
//		 
//		OrderBefore order = new OrderBefore();
//		
//		try {
//			ps = conn.prepareStatement(sql);
//			
//			ps.setInt(1, orderno);
//			
//			rs = ps.executeQuery();
//			
//			while( rs.next()) {
//				
//				order.setOrderno(rs.getInt("orderno"));
//				order.setBuyprodname(rs.getString("buyprodname"));
//				order.setTotalamount(rs.getInt("totalamount"));
//				
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(ps);
//		}
//		
//		System.out.println("OrderBeforeDao - End");
//		
//		return order;
//	}

	@Override
	public OrderBefore getOrderInfo(Connection conn, int userno) {
		System.out.println("OrderBeforeDao - Start");
		
		String sql = "";
		
		sql+= "SELECT";
		sql+= " orderno, buyprodname, totalamount";
		sql+= " FROM user_orderbefore";
		sql+= " WHERE orderno=( SELECT";
		sql+= "		MAX(orderno) FROM user_orderbefore";
		sql+= "		WHERE userno=?)";
		 
		OrderBefore order = new OrderBefore();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userno);
			
			rs = ps.executeQuery();
			
			while( rs.next()) {
				
				order.setOrderno(rs.getInt("orderno"));
				order.setBuyprodname(rs.getString("buyprodname"));
				order.setTotalamount(rs.getInt("totalamount"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("OrderBeforeDao - End");
		
		return order;
	}



	@Override
	public User updateUser(Connection conn, int userno) {
		System.out.println("Update - Start");
		
		String sql = "";
		
		sql+="UPDATE user_info";
		sql+="SET address = ?";
		sql+="WHERE userno = ?";
		
		User user = new User();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getAddress());
			ps.setInt(2, userno);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		
		
		System.out.println("Update - End");
		return user;
	}


}
