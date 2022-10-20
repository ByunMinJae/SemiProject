package minjae.service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import minjae.dao.face.MypageDao;
import minjae.dao.impl.MypageDaoImpl;
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
	
}









