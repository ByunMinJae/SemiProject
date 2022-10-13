package minjae.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import minjae.dao.face.FindUserDao;
import minjae.dto.UserInfo;

public class FindUserDaoImpl implements FindUserDao {
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public UserInfo selectEmail(Connection conn, String email) {
		
		String sql = "";
		sql += "SELECT userid, email FROM user_test";
		sql += " WHERE email = ?";
		
		UserInfo user = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			
			rs = ps.executeQuery();
			
			
			while( rs.next() ) {
				user = new UserInfo();
				
				user.setUserid(rs.getString("userid"));
				user.setEmail(rs.getString("email"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return user;
	}

}
