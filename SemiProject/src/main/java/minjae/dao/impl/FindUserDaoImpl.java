package minjae.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import common.JDBCTemplate;
import minjae.dao.face.FindUserDao;
import minjae.dto.UserFind;
import minjae.dto.UserInfo;

public class FindUserDaoImpl implements FindUserDao {
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public UserInfo selectEmail(Connection conn, String email) {
		System.out.println("FindUserDao selectEmail() - 시작");
		
		String sql = "";
		sql += "SELECT userid, userpw, email FROM user_info";
		sql += " WHERE email = ?";
		
		UserInfo user = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			
			rs = ps.executeQuery();
			
			
			while( rs.next() ) {
				user = new UserInfo();
				
				user.setUserid(rs.getString("userid"));
				user.setUserpw(rs.getString("userpw"));
				user.setEmail(rs.getString("email"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("FindUserDao selectEmail() - 끝");
		return user;
	}
	
	@Override
	public int insertAuth(Connection conn, UserInfo user) {
		System.out.println("FindUserDao insertAuth() - 시작");
		
		//인증번호 생성
		SimpleDateFormat sdf = new SimpleDateFormat("ssSSS"); 	//DateFormat 설정
		Date now = new Date(); 									//Date 객체 생성
		int authno = Integer.parseInt(sdf.format(now)); 		//설정한 format에 맞춰 인증번호 int로 파싱 
		
		String sql = "INSERT INTO user_find VALUES (user_find_seq.nextval, sysdate, ?, ?, ?, ?)";
		
		//수행 결과를 저장할 변수
		int result = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getUserid());
			ps.setString(3, user.getUserpw());
			ps.setInt(4, authno);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("FindUserDao insertAuth() - 끝");
		return result;
	}
	
	@Override
	public UserFind selectAuth(Connection conn, UserInfo user) {
		System.out.println("FindUserDao selectAuth() - 시작");

		String sql = "";
		sql += "SELECT * FROM user_find";
		sql += " WHERE createno >= (SELECT MAX(createno) FROM user_find WHERE email = ?)";
		
		UserFind userFind = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				userFind = new UserFind();
				
				userFind.setCreateno(rs.getInt("createno"));
				userFind.setCreatedat(rs.getDate("createdat"));
				userFind.setEmail(rs.getString("email"));
				userFind.setId(rs.getString("id"));
				userFind.setPw(rs.getString("pw"));
				userFind.setAuthno(rs.getInt("authno"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("FindUserDao selectAuth() - 끝");
		return userFind;
		
	}
	
	@Override
	public UserInfo selectPhone(Connection conn, String name, String phone, String birth) {
		System.out.println("FindUserDao selectPhone() - 시작");
		
		String sql = "";
		sql += "SELECT userid, userpw, username, email, phone, birth FROM user_info";
		sql += " WHERE username = ? AND phone = ? AND birth =  to_date(?)";
		
		UserInfo user = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, birth);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				user = new UserInfo();
				
				user.setUserid(rs.getString("userid"));
				user.setUserpw(rs.getString("userpw"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setBirth(rs.getDate("birth"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("FindUserDao selectPhone() - 끝");
		return user;
	}
	
	@Override
	public UserInfo selectId(Connection conn, String id) {
		System.out.println("FindUserDao selectId() - 시작");
		
		String sql = "";
		sql += "SELECT userid, userpw, username, email, phone, birth FROM user_info";
		sql += " WHERE userid = ?";
		
		UserInfo user = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				user = new UserInfo();
				
				user.setUserid(rs.getString("userid"));
				user.setUserpw(rs.getString("userpw"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setBirth(rs.getDate("birth"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("FindUserDao selectId() - 끝");
		return user;
	}
	
	@Override
	public UserInfo selectIdPhone(Connection conn, String id, String phone) {
		System.out.println("FindUserDao selectIdPhone() - 시작");
		
		String sql = "";
		sql += "SELECT userid, userpw, username, email, phone, birth FROM user_info";
		sql += " WHERE userid = ? AND phone = ?";
		
		UserInfo user = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, phone);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				user = new UserInfo();
				
				user.setUserid(rs.getString("userid"));
				user.setUserpw(rs.getString("userpw"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setBirth(rs.getDate("birth"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("FindUserDao selectIdPhone() - 끝");
		return user;
	}
	
	@Override
	public int updatePwById(Connection conn, String id, String upw) {
		System.out.println("FindUserDao updatePwById() - 시작");
		
		String sql = "";
		sql += "UPDATE user_info SET userpw = ?";
		sql += " WHERE userid = ?";
		
		//수행 결과를 저장할 변수
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, upw);
			ps.setString(2, id);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("FindUserDao updatePwById() - 끝");
		return res;
		
	}
	
	@Override
	public int selectExistPw(Connection conn, String pw) {
		System.out.println("FindUserDao selectExistPw() - 시작");
		
		String sql = "";
		sql += "SELECT count(*) FROM user_info";
		sql += " WHERE userpw = ?";
		
		//수행 결과를 저장할 변수
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pw);
			
			rs = ps.executeQuery();
			
			rs.next();
			res = rs.getInt("count(*)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("FindUserDao selectExistPw() - 끝");
		return res;
	}
	
}










