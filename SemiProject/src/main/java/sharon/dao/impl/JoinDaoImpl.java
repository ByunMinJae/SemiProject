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
			/*
			 * //10/14 ->회원목록 조회 ... public List<User> selectAll(Connection conn){
			 * 
			 * 
			 * //--- SQL 작성 --- String sql = ""; sql += "SELECT"; sql +=
			 * "	userno, userid, gender, birth"; sql += " FROM user_info"; sql +=
			 * " ORDER BY userno";
			 * 
			 * //--- 조회 결과 저장할 List 객체 --- List<User> list = new ArrayList<>();
			 * 
			 * try { //--- SQL 수행 객체 생성 --- ps = conn.prepareStatement(sql);
			 * 
			 * //--- SQL 수행 및 결과 저장 --- rs = ps.executeQuery();
			 * 
			 * //--- 조회 결과 처리 --- while( rs.next() ) { User user = new User();
			 * 
			 * user.setUserno( rs.getInt("userno") ); user.setUserid( rs.getString("userid")
			 * ); user.setGender( rs.getString("gender") ); user.setBirth(
			 * rs.getDate("birth") );
			 * 
			 * list.add(user); }
			 * 
			 * } catch (SQLException e) { e.printStackTrace(); } finally { //--- 자원 해제 ---
			 * JDBCTemplate.close(rs); JDBCTemplate.close(ps); }
			 * 
			 * return list;
			 * 
			 * 
			 * }
			 * 
			 * @Override public User selectByUserno(Connection conn, int userno) { // TODO
			 * Auto-generated method stub return null; }
			 */


}

