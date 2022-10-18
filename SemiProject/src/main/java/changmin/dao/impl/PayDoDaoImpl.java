package changmin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import changmin.dao.face.PayDoDao;
import changmin.dto.User;
import common.JDBCTemplate;

public class PayDoDaoImpl implements PayDoDao{

	private PreparedStatement ps = null;
	private ResultSet rs;
	


	@Override
	public User getUserInfo(Connection conn, int userno) {
		System.out.println("DAO - 시작");
		
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
		
		System.out.println("DAO - 끝");
		
		return user;
	}

}
