package sharon.dao.impl;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import sharon.dao.face.JoinDao;
import sharon.dto.User;

public class JoinDaoImpl implements JoinDao {

	
	private PreparedStatement ps;
	private ResultSet rs;
	private Connection conn;
	
	public int selectCntMemberByUseridUserpw(Connection conn, User user) {
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM user_info";
		sql += " WHERE userid = ?";
		sql += "	AND userpw = ?";
		
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getUserpw());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		return cnt;
	}
	
	@Override
	public User selectMemberByUserid(Connection conn, User user) {

		String sql = "";
		sql += "SELECT userid, userpw, username FROM user_info";
		sql += " WHERE userid = ?";
		
		User result = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = new User();
				
				result.setUserid( rs.getString("userid") );
				result.setUserpw( rs.getString("userpw") );
				result.setUsername( rs.getString("username") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		return result;
		
	}
	
	@Override
	public int insert(Connection conn, User user) {
		
		String sql = "";
		sql += "INSERT INTO user_info ( userno, userid, userpw, username, gender, address, phone, birth, email, nick ,joinday,userupdate)";
		sql += " VALUES ( user_info_seq.nextval, ?, ?, ? ,? ,? ,?, ?, ?, ?, sysdate ,sysdate)";

		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getUserpw());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getAddress());
			ps.setString(6, user.getPhone());
			ps.setString(7, user.getBirth());
			ps.setString(8, user.getEmail());
			ps.setString(9, user.getNick());
			
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
			
	public int checkId(User user) {
		System.out.println("아이디중복 시작-daoimpl");
		
		String sql = "";
		sql += "SELECT * FROM user_info WHERE userid =?";
		
		conn =JDBCTemplate.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			rs=ps.executeQuery();
			
			if(rs.next()) {
				return 0; //중복ㅇ
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		return 1; //중복x
	}

}

