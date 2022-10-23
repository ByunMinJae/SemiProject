package changmin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import changmin.dao.face.PayDoDao;
import common.JDBCTemplate;
import jeonghwa.dto.Product;
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



	@Override
	public Product getProdInfo(Connection conn, int prodno) {
		System.out.println("ProdDao - Start");
		
		String sql = "";
		
		sql+= "SELECT";
		sql+= " prodno, prodname, prodprice";
		sql+= " FROM product";
		sql+= " WHERE prodno=?";
		 
		Product prod = new Product();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, prodno);
			
			rs = ps.executeQuery();
			
			while( rs.next()) {
				
				prod.setProdno( rs.getInt("prodno"));
				prod.setProdname( rs.getString("prodname"));
				prod.setProdprice( rs.getInt("prodprice"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("ProdDao - End");
		
		return prod;
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
