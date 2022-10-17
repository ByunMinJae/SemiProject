package changmin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import changmin.dao.face.PayDoDao;
import changmin.dto.User;
import common.JDBCTemplate;

public class PayDoDaoImpl implements PayDoDao{

	private PreparedStatement ps = null;
	private ResultSet rs;
	
	@Override
	public List<User> selectUser(Connection conn) {
		System.out.println("DAO - 시작");
		
		String sql = "";
		
		sql+="SELECT";
		sql+="	userno, username, address, phone, email ";
		sql+="	FROM user_info";

		List<User> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				User user = new User();
				
				user.setUserno( rs.getInt("userno"));
				user.setUsername( rs.getString("username"));
				user.setAddress( rs.getString("address"));
				user.setPhone( rs.getString("phone"));
				user.setEmail( rs.getString("email"));
				
				list.add(user);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("DAO - 끝");
		return list;
	}

}
