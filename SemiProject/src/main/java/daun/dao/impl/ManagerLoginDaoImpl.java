package daun.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daun.dao.face.ManagerLoginDao;
import donghyun.dto.UserInfo;

public class ManagerLoginDaoImpl implements ManagerLoginDao {

	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public UserInfo selectOneUser(String userid, String userpw, Connection conn) {
		UserInfo userInfo = null;
		
		String sql = "SELECT * FROM user_info WHERE userid=? AND userpw=?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, userpw);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				userInfo = new UserInfo();
				
				userInfo.setUserno(rs.getInt("userno"));
				userInfo.setUserid(rs.getString("userid"));
				userInfo.setUserpw(rs.getString("userpw"));
				userInfo.setUsername(rs.getString("username"));
				userInfo.setGender(rs.getString("gender"));
				userInfo.setAddress(rs.getString("address"));
				userInfo.setPhone(rs.getString("phone"));
				userInfo.setBirth(rs.getDate("birth"));
				userInfo.setEmail(rs.getString("email"));
				userInfo.setNick(rs.getString("nick"));
				userInfo.setJoinday(rs.getDate("joinday"));
				userInfo.setUserupdate(rs.getDate("userupdate"));
				userInfo.setGradeno(rs.getInt("gradeno"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userInfo;
	}
}
