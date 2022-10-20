package minjae.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public BoardInfoCate selectBoardIC(Connection conn, int userno) {
		System.out.println("/mypage/main selectBoardIC() - 시작");
		
		String sql = "";
		sql += "SELECT a.*, b.categoryname FROM board_info a";
		sql += " INNER JOIN Board_Category b";
		sql += "	ON a.categoryno = b.categoryno";
		sql += " WHERE a.userno = ?";

		BoardInfoCate boardIC = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userno);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				boardIC = new BoardInfoCate();
				
				boardIC.setBoardno(rs.getInt("boardno"));
				boardIC.setBoardtitle(rs.getString("boardtitle"));
				boardIC.setBoardcon(rs.getString("bardcon"));
				boardIC.setBoarddate(rs.getDate("boarddate"));
				boardIC.setUserno(rs.getInt("userno"));
				boardIC.setCategoryno(rs.getInt("categoryno"));
				boardIC.setCategoryname(rs.getString("categoryname"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("/mypage/main selectBoardIC() - 끝");
		return boardIC;
	}
	
}
















