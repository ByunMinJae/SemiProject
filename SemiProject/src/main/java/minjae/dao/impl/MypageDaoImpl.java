package minjae.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import minjae.dao.face.MypageDao;
import minjae.dto.MpMain;

public class MypageDaoImpl implements MypageDao {
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public MpMain selectUserInfo(Connection conn, int userno) {
		
		String sql = "";
		sql += "SELECT a.*, b.gradename FROM user_info a";
		sql += " INNER JOIN user_level b";
		sql += " ON a.gradeno = b.gradeno";
		sql += " WHERE userno = ?";
		
		MpMain mpMain = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userno);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				mpMain = new MpMain();
				
				mpMain.setUserno(rs.getInt("userno"));
				mpMain.setUserid(rs.getString("userid"));
				mpMain.setUserpw(rs.getString("userpw"));
				mpMain.setUsername(rs.getString("username"));
				mpMain.setGender(rs.getString("gender"));
				mpMain.setAddress(rs.getString("address"));
				mpMain.setPhone(rs.getString("phone"));
				mpMain.setBirth(rs.getDate("birth"));
				mpMain.setEmail(rs.getString("email"));
				mpMain.setNick(rs.getString("nick"));
				mpMain.setJoinday(rs.getDate("joinday"));
				mpMain.setUserupdate(rs.getDate("userupdate"));
				mpMain.setGradeno(rs.getInt("gradeno"));
				mpMain.setGradename(rs.getString("gradename"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return mpMain;
	}
	
}
















