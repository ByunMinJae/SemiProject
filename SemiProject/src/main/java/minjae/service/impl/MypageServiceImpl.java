package minjae.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import minjae.dao.face.MypageDao;
import minjae.dao.impl.MypageDaoImpl;
import minjae.dto.BoardInfoCate;
import minjae.dto.MpMain;
import minjae.dto.MpMainRight;
import minjae.service.face.MypageService;

public class MypageServiceImpl implements MypageService {
	
	private MypageDao mypageDao = new MypageDaoImpl();
	
	@Override
	public MpMain getUserInfo(int userno) {
		System.out.println("/mypage/main getUserInfo() - 시작");
		
		Connection conn = JDBCTemplate.getConnection();
		
		MpMain mpMain = mypageDao.selectUserInfo(conn, userno);
		
		System.out.println("/mypage/main getUserInfo() - 끝");
		return mpMain;
	}

	@Override
	public MpMainRight getOrderInfo(int userno) {
		System.out.println("/mypage/main getOrderInfo() - 시작");
		
		Connection conn = JDBCTemplate.getConnection();
		
		MpMainRight mpMR = mypageDao.selectOrderInfo(conn, userno);
		
		System.out.println("/mypage/main getOrderInfo() - 끝");
		return mpMR;
	}
	
	@Override
	public MpMainRight getOrderInfoByDate(int userno, String startDate, String endDate) {
		System.out.println("/mypage/main getOrderInfoByDate() - 시작");
		
		Connection conn = JDBCTemplate.getConnection();
		
		MpMainRight mpMR = mypageDao.selectOIByDate(conn, userno, startDate, endDate);
		
		System.out.println("/mypage/main getOrderInfoByDate() - 끝");
		return mpMR;
	}
	
	@Override
	public List<BoardInfoCate> getBoardInfoCate(int userno) {
		System.out.println("/mypage/main getBoardInfoCate() - 시작");
		
		Connection conn = JDBCTemplate.getConnection();
		
		List<BoardInfoCate> boardICList = mypageDao.selectBoardIC(conn, userno);
		
		System.out.println("/mypage/main getBoardInfoCate() - 끝");
		return boardICList;
	}
	
	@Override
	public boolean checkUserpw(int userno, String pw) {
		System.out.println("/mypage/main checkUserpw() - 시작");
		
		Connection conn = JDBCTemplate.getConnection();
		
		int res = mypageDao.selectUserpw(conn, userno, pw);
		
		if( res > 0 ) {
			System.out.println("/mypage/main checkUserpw() - 끝");
			return true;
		} else {
			System.out.println("/mypage/main checkUserpw() - 끝");
			return false;
		}
		
	}
	
	@Override
	public int existNick(String nick) {
		System.out.println("/mypage/main existNick() - 시작");
		
		Connection conn = JDBCTemplate.getConnection();
		
		int res = mypageDao.countNick(conn, nick);
		
		System.out.println("/mypage/main existNick() - 끝");
		return res;
		
	}
	
	@Override
	public int existPhone(String phone) {
		System.out.println("/mypage/main existPhone() - 시작");
		
		Connection conn = JDBCTemplate.getConnection();
		
		int res = mypageDao.countPhone(conn, phone);
		
		System.out.println("/mypage/main existPhone() - 끝");
		return res;
	}
	
	@Override
	public int updateUserName(int userno, String name) {
		System.out.println("/mypage/main updateUserName() - 시작");
		
		Connection conn = JDBCTemplate.getConnection();
		
		int res = mypageDao.updateUserName(conn, userno, name);
		
		if( res > 0 ) {
			JDBCTemplate.commit(conn);
			System.out.println("/mypage/main updateUserName() - 끝");
			return 1; //성공
		} else {
			JDBCTemplate.rollback(conn);
			System.out.println("/mypage/main updateUserName() - 끝");
			return 0; //실패
		}
	}
	
	@Override
	public int updateUserNick(int userno, String nick) {
		System.out.println("/mypage/main updateUserNick() - 시작");
		
		Connection conn = JDBCTemplate.getConnection();
		
		int res = mypageDao.updateUserNick(conn, userno, nick);
		
		if( res > 0 ) {
			JDBCTemplate.commit(conn);
			System.out.println("/mypage/main updateUserNick() - 끝");
			return 1; //성공
		} else {
			JDBCTemplate.rollback(conn);
			System.out.println("/mypage/main updateUserNick() - 끝");
			return 0; //실패
		}
	}
	
	@Override
	public int updateUserPhone(int userno, String phone) {
		System.out.println("/mypage/main updateUserPhone() - 시작");
		
		Connection conn = JDBCTemplate.getConnection();
		
		int res = mypageDao.updateUserPhone(conn, userno, phone);
		
		if( res > 0 ) {
			JDBCTemplate.commit(conn);
			System.out.println("/mypage/main updateUserPhone() - 끝");
			return 1; //성공
		} else {
			JDBCTemplate.rollback(conn);
			System.out.println("/mypage/main updateUserPhone() - 끝");
			return 0; //실패
		}
	}
	
	@Override
	public int updateUserAddr(int userno, String address) {
		System.out.println("/mypage/main updateUserAddr() - 시작");
		
		Connection conn = JDBCTemplate.getConnection();
		
		int res = mypageDao.updateUserAddr(conn, userno, address);
		
		if( res > 0 ) {
			JDBCTemplate.commit(conn);
			System.out.println("/mypage/main updateUserAddr() - 끝");
			return 1; //성공
		} else {
			JDBCTemplate.rollback(conn);
			System.out.println("/mypage/main updateUserAddr() - 끝");
			return 0; //실패
		}
	}
	
}









