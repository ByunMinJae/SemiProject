package donghyun.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import donghyun.dao.face.LoginDao;
import donghyun.dto.UserInfo;

public class LoginDaoImpl implements LoginDao {
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
	
	
	//--------------------------------------------------------------------------------------------------------------------------
//	@Override
//	public int selectCntUserByUseridUserpw(Connection conn, UserInfo user) {
//		
//		String sql = "";
//		sql += "SELECT count(*) cnt FROM user_info";
//		sql += " WHERE userid = ? AND userpw = ?";
//		
//		int cnt = 0;
//		
//		try {
//			ps= conn.prepareStatement(sql);
//			ps.setString(1, user.getUserid());
//			ps.setString(2, user.getUserpw());
//			
//			rs=ps.executeQuery();
//			
//			while(rs.next()) {
//				cnt = rs.getInt("cnt");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return cnt;
//	}
//	@Override
//	public UserInfo selectUserByUserid(Connection conn, UserInfo user) {
//		
//		String sql = "";
//		sql += "SELECT userid, userpw, nick FROM user_info";
//		sql += " WHERE userid=?";
//		
//		UserInfo result = null;
//		
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, user.getUserid());
//			
//			rs=ps.executeQuery();
//			
//			while(rs.next()) {
//				result = new UserInfo();
//				
//				result.setUserid(rs.getString("userid"));
//				result.setUserpw(rs.getString("userpw"));
//
//			}
//					
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;
//	}
//	
//	

}
