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
		sql += "INSERT INTO user_info ( userno, userid, userpw, username, gender, address, phone, birth, email, nick ,joinday,gradeno)";
		sql += " VALUES ( user_info_seq.nextval, ?, ?, ? ,? ,? ,?, ?, ?, ?, sysdate ,?)";

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
			ps.setInt(10, 1);
			
			
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

//	회원삭제
	public int delete(Connection conn, int userno) {
		
		System.out.println("회원삭제 시작 -joindaoimpl-delete");
		
		String sql = "";
		sql += "DELETE FROM user_info";
		sql += "WHERE userno=?";
		
		int res=0;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, userno);
			
			res=ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
			
		}
		
	System.out.println("joindaoimpl - 회원삭제끝");
		return res;
	}

	//회원삭제때문에 userno 찾는-----10/27
	@Override
	public User selectByUserno(Connection conn, int userno) {
		//--- SQL 작성 ---
		String sql = "";
		sql += "SELECT";
		sql += "	userno, userid, userpw, username, gender, address, phone";
		sql += "	, birth, email, nick ,joinday,userupdate,gradeno";		
		sql += " FROM user_info";
		sql += " WHERE userno = ?";
			
		//--- 조회 결과 저장 객체 ---
		User user = null;
		
		try {
			//--- SQL 수행 객체 생성 ---
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userno);
		
				//--- SQL 수행 및 결과 저장 ---
			rs = ps.executeQuery();
				
				//--- 조회 결과 처리 ---
			while( rs.next() ) {
				user = new User();
					
				user.setUserno( rs.getInt("userno") );
				user.setUsername( rs.getString("username") );
				
				user.setUserid( rs.getString("userid") );
				user.setNick( rs.getString("nick") );
				user.setGender( rs.getString("gender") );
				user.setAddress( rs.getString("address") );
				user.setBirth( rs.getString("birth") );
				user.setEmail( rs.getString("email") );
				user.setJoinday( rs.getDate("joinday") );
				user.setUserupdate( rs.getDate("userupdate") );
				user.setGradeno( rs.getInt("gradeno") );
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//--- 자원 해제 ---
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
			
			//--- 조회 결과 반환 ---
		return user;
	}

	//이메일 중복
	@Override
		public int emailCheck(String email) {
			int value = -1;
			
			try {
				conn= JDBCTemplate.getConnection();
				
				String sql ="SELECT count(email)"; 
				sql +=" FROM USER_INFO"; 
				sql +=" WHERE email = ?";
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, email);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					return rs.getInt(1);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			
			return value;
		}
	//닉네임 중복
	@Override
	public int nickCheck(String nick) {
		int value = -1;
		
		try {
			conn= JDBCTemplate.getConnection();
			
			String sql ="SELECT count(nick)"; 
			sql +=" FROM USER_INFO"; 
			sql +=" WHERE nick = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, nick);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return value;
	}
	}
	


