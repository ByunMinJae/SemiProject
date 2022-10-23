package minjae.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import minjae.dao.face.MypageDao;
import minjae.dto.BoardInfoCate;
import minjae.dto.MpMain;
import minjae.dto.MpMainRight;

public class MypageDaoImpl implements MypageDao {
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public MpMain selectUserInfo(Connection conn, int userno) {
		System.out.println("/mypage/main selectUserInfo() - 시작");

		String sql = "";
		sql += "SELECT a.USERNO, a.USERID, a.USERNAME, a.GENDER, a.ADDRESS";
		sql += " , a.PHONE, a.BIRTH, a.EMAIL, a.NICK, a.JOINDAY, a.USERUPDATE";
		sql += " , a.GRADENO, b.gradename FROM user_info a";
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
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("/mypage/main selectUserInfo() - 끝");
		return mpMain;
	}
	
	@Override
	public MpMainRight selectOrderInfo(Connection conn, int userno) {
		System.out.println("/mypage/main selectOrderInfo() - 시작");
		
		String sql = "";
		sql += "SELECT count(DECODE(orderprocess,'배송중', 1)) cnt1";
		sql += " , count(DECODE(orderprocess,'배송완료', 1)) cnt2";
		sql += " , count(DECODE(orderprocess,'교환/반품/취소', 1)) cnt3";
		sql += " FROM";
		sql += " 	(SELECT a.*, b.payno, c.orderafterno, c.orderprocess FROM user_orderbefore a";
		sql += " 	INNER JOIN pay b";
		sql += " 	ON a.orderno = b.orderno";
		sql += " 	INNER JOIN user_orderafter c";
		sql += "	ON b.payno = c.payno";
		sql += "	WHERE a.userno = ?)";
		
		MpMainRight mpMR = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userno);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				mpMR = new MpMainRight();
				
				mpMR.setUserno(userno);
				mpMR.setDelCnt(rs.getInt("cnt1"));
				mpMR.setDelComCnt(rs.getInt("cnt2"));
				mpMR.setExchanCnt(rs.getInt("cnt3"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("/mypage/main selectOrderInfo() - 끝");
		return mpMR;
	}
	
	@Override
	public MpMainRight selectOIByDate(Connection conn, int userno, String startDate, String endDate) {
		System.out.println("/mypage/main selectOIByDate() - 시작");
		
		String sql = "";
		sql += "SELECT count(DECODE(orderprocess,'배송중', 1)) cnt1";
		sql += " , count(DECODE(orderprocess,'배송완료', 1)) cnt2";
		sql += " , count(DECODE(orderprocess,'교환/반품/취소', 1)) cnt3";
		sql += " FROM";
		sql += " 	(SELECT a.*, b.payno, c.orderafterno, c.orderprocess FROM user_orderbefore a";
		sql += " 	INNER JOIN pay b";
		sql += " 	ON a.orderno = b.orderno";
		sql += " 	INNER JOIN user_orderafter c";
		sql += "	ON b.payno = c.payno";
		sql += "	WHERE a.userno = ?";
		sql += "	AND trunc(b.paydate) BETWEEN to_date(?, 'YY/MM/DD') AND to_date(?, 'YY/MM/DD'))";

		MpMainRight mpMR = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userno);
			ps.setString(2, startDate);
			ps.setString(3, endDate);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				mpMR = new MpMainRight();
				
				mpMR.setUserno(userno);
				mpMR.setDelCnt(rs.getInt("cnt1"));
				mpMR.setDelComCnt(rs.getInt("cnt2"));
				mpMR.setExchanCnt(rs.getInt("cnt3"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("/mypage/main selectOIByDate() - 끝");
		return mpMR;
	}
	
	@Override
	public List<BoardInfoCate> selectBoardIC(Connection conn, int userno) {
		System.out.println("/mypage/main selectBoardIC() - 시작");
		
		String sql = "";
		sql += "SELECT a.*, b.categoryname FROM board_info a";
		sql += " INNER JOIN Board_Category b";
		sql += "	ON a.categoryno = b.categoryno";
		sql += " WHERE a.userno = ?";
		sql += " ORDER BY boardno DESC";

		List<BoardInfoCate> boardICList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userno);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				BoardInfoCate bic = new BoardInfoCate(); 
				
				bic.setBoardno(rs.getInt("boardno"));
				bic.setBoardtitle(rs.getString("boardtitle"));
				bic.setBoardcon(rs.getString("boardcon"));
				bic.setBoarddate(rs.getDate("boarddate"));
				bic.setUserno(rs.getInt("userno"));
				bic.setCategoryno(rs.getInt("categoryno"));
				bic.setCategoryname(rs.getString("categoryname"));
				
				boardICList.add(bic);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("/mypage/main selectBoardIC() - 끝");
		return boardICList;
	}
	
	@Override
	public int selectUserpw(Connection conn, int userno, String pw) {
		System.out.println("/mypage/main selectUserpw() - 시작");
		
		String sql = "";
		sql += "SELECT count(*) FROM user_info";
		sql += " WHERE userno = ? AND userpw = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userno);
			ps.setString(2, pw);
			
			rs = ps.executeQuery();
			
			rs.next();
			res = rs.getInt("count(*)");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
			
		System.out.println(res);
		System.out.println("/mypage/main selectUserpw() - 끝");
		return res;
	}
	
	@Override
	public int countNick(Connection conn, String nick) {
		System.out.println("/mypage/main countNick() - 시작");
		
		String sql = "";
		sql += "SELECT count(DECODE(nick, ?, 1)) cnt FROM user_info";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, nick);
			
			rs = ps.executeQuery();
			
			rs.next();
			res = rs.getInt("cnt");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
			
		System.out.println("/mypage/main countNick() - 끝");
		return res;
	}
	
	@Override
	public int countPhone(Connection conn, String phone) {
		System.out.println("/mypage/main countPhone() - 시작");
		
		String sql = "";
		sql += "SELECT count(DECODE(phone, ?, 1)) cnt FROM user_info";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, phone);
			
			rs = ps.executeQuery();
			
			rs.next();
			res = rs.getInt("cnt");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
			
		System.out.println("/mypage/main countPhone() - 끝");
		return res;
	}
	
	@Override
	public int updateUserName(Connection conn, int userno, String name) {
		System.out.println("/mypage/main DAO updateUserName() - 시작");
		
		String sql = "";
		sql += "UPDATE user_info";
		sql += " SET username = ?";
		sql += " WHERE userno = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, userno);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("/mypage/main DAO updateUserName() - 끝");
		return res;
	}
	
	@Override
	public int updateUserNick(Connection conn, int userno, String nick) {
		System.out.println("/mypage/main DAO updateUserNick() - 시작");
		
		String sql = "";
		sql += "UPDATE user_info";
		sql += " SET nick = ?";
		sql += " WHERE userno = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, nick);
			ps.setInt(2, userno);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("/mypage/main DAO updateUserNick() - 끝");
		return res;
	}
	
	@Override
	public int updateUserPhone(Connection conn, int userno, String phone) {
		System.out.println("/mypage/main DAO updateUserPhone() - 시작");
		
		String sql = "";
		sql += "UPDATE user_info";
		sql += " SET phone = ?";
		sql += " WHERE userno = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, phone);
			ps.setInt(2, userno);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("/mypage/main DAO updateUserPhone() - 끝");
		return res;
	}
	
	@Override
	public int updateUserAddr(Connection conn, int userno, String address) {
		System.out.println("/mypage/main DAO updateUserAddr() - 시작");
		
		String sql = "";
		sql += "UPDATE user_info";
		sql += " SET address = ?";
		sql += " WHERE userno = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, address);
			ps.setInt(2, userno);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("/mypage/main DAO updateUserAddr() - 끝");
		return res;
	}
	
}
















