package sharon.dao.impl;

import java.sql.Connection;
import java.sql.Date;
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
	private Connection conn;
	
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
					user.setUserpw( rs.getString("userpw") );
					user.setNick( rs.getString("nick") );
					user.setGender( rs.getString("gender") );
					user.setAddress( rs.getString("address") );
					user.setPhone( rs.getString("phone") );
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

	public List<User> selectAll(Connection conn, String findType, String findKeyword) {
		String colName="";

		
		//--- SQL 작성 ---
		String sql = "";
		sql += "SELECT";
		sql += "	userno, userid, userpw, username, gender, address, phone";
		sql += "	, birth, email, nick ,joinday,userupdate,gradeno";
		sql += " FROM user_info";

		if( findType != null && !"".equals(findType) ) {
			switch(findType) {
			case "1": colName="username";
			break;
			case "2": colName="gender";
			break;
			case "3": colName="phone";
			break;
			}

			sql += " where " + colName + " like ?";
		}
		
		sql += " ORDER BY userno";
		
		//--- 조회 결과 저장할 List 객체 ---
		List<User> list = new ArrayList<>();				
		try {
			//--- SQL 수행 객체 생성 ---
			ps = conn.prepareStatement(sql);

			if( findType != null && !"".equals(findType) ) {
				ps.setString(1, "%"+findKeyword+"%");
			}
			
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
				user.setPhone( rs.getString("phone") );
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
					user.setUserpw( rs.getString("userpw") );
					user.setNick( rs.getString("nick") );
					user.setGender( rs.getString("gender") );
					user.setAddress( rs.getString("address") );
					user.setPhone( rs.getString("phone") );
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

	
	//--------------1022회원검색
	@Override
	public List<User> findUser(String type, String keyword) throws SQLException {
		try {
			String colName="";
			switch(type) {
				case "1": colName="username";
					break;
				case "2": colName="gender";
					break;
				case "3": colName="phone";
					break;
			}
			
			conn = JDBCTemplate.getConnection();
			
			String sql="select * from user_info where "+colName+" like ?";
			System.out.println(sql);
			ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			rs=ps.executeQuery();
			
			return makeList(rs);
			
			
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
	}

	private List<User> makeList(ResultSet rs) throws SQLException {
			List<User> arr=new ArrayList<>();
			
			while(rs.next()) {
				int userno = rs.getInt("userno");
				String username= rs.getString("username");
				String userid= rs.getString("userid");
				String nick= rs.getString("nick");
				String gender= rs.getString("gender");
				String address= rs.getString("address");
				String phone= rs.getString("phone");
				String birth= rs.getString("birth");
				String email= rs.getString("email");
				Date joinday=rs.getDate("joinday");
				Date userupdate=rs.getDate("userupdate");
				int gradeno= rs.getInt("gradeno");
				
				User user = new User();
				arr.add(user);
			}
		
		return arr;
	}

	
	}

