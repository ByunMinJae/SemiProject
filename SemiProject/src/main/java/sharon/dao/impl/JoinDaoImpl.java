package sharon.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import sharon.dao.face.JoinDao;
import sharon.dto.User;

public class JoinDaoImpl implements JoinDao {
	
	private PreparedStatement ps =null;
	private ResultSet rs=null;
	
	
	public int selectNextUserno(Connection conn) {
	
		String sql = "SELECT cmc_seq.nextval FROM dual";
	
		int nextval = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
			
			nextval = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return nextval;
	}

	public int insert(Connection conn, User user) {
		
		String sql = "";
		sql += "INSERT INTO user ( userno, userid, ,userpw, gender,address,phone,birth, email, nick, joinday,userupdate,gradeno)";
		sql += " VALUES( ?, ?, ?, ? ?,?,?,?,?,?,?,?)";
		
		
		
		//INSERT 수행 결과 변수
		int result = 0;
				
		try {
			ps = conn.prepareStatement(sql);
					
			ps.setInt(1, user.getUserno());
			ps.setString(2, user.getUserid());
			ps.setString(3, user.getUserpw());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getAddress());
			ps.setInt(6, user.getPhone());
			ps.setDate(7, user.getBirth());
			ps.setString(8, user.getEmail());
			ps.setString(9, user.getNick());
			ps.setDate(10, user.getJoinday());
			ps.setDate(11, user.getUserupdate());
			ps.setInt(12, user.getGradeno());
					
			result = ps.executeUpdate();
					
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(ps);
			}
				
			return result;
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
