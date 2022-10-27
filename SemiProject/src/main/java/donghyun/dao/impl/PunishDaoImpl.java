package donghyun.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import donghyun.dao.face.PunishDao;
import donghyun.dto.Report;
import donghyun.dto.UserInfo;

public class PunishDaoImpl implements PunishDao {
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public int getPunish(Connection conn, int userno) {
		int res = 0;
		
		String sql = "UPDATE user_info SET gradeno=3 WHERE userno=?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userno);
			
			res=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return res;
	}
	
	
	
	
	

}
