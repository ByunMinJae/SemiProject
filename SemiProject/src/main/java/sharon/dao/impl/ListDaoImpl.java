package sharon.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import sharon.dao.face.ListDao;
import sharon.dto.User;

public class ListDaoImpl implements ListDao {

	private PreparedStatement ps; 
	private ResultSet rs;
	
	public List<User> selectAll(Connection conn) {
		//--- SQL 작성 ---
		String sql = "";
			sql += "SELECT";
			sql += "	userno, userid, userpw, username, gender, address, phone";
			sql += "	, birth, email, nick ,joinday,userupdate,gradeno";			
			sql += " FROM user_info";
			sql += " ORDER BY userno";
				
			//--- 조회 결과 저장할 List 객체 ---
			List<User> list = new ArrayList<>();				
			try {
				//--- SQL 수행 객체 생성 ---
				ps = conn.prepareStatement(sql);
				
				//--- SQL 수행 및 결과 저장 ---
				rs = ps.executeQuery();
					
					//--- 조회 결과 처리 ---
				while( rs.next() ) {
					User user = new User();
						
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
					
					list.add(user);
			}
					
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				//--- 자원 해제 ---
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}
				
			//--- 최종 결과 반환 ---
			return list;
		}

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
			
	}

