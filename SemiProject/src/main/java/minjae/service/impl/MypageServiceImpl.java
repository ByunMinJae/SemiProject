package minjae.service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import minjae.dao.face.MypageDao;
import minjae.dao.impl.MypageDaoImpl;
import minjae.dto.MpMain;
import minjae.service.face.MypageService;

public class MypageServiceImpl implements MypageService {
	
	private MypageDao mypageDao = new MypageDaoImpl();
	
	@Override
	public MpMain getUserInfo(int userno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MpMain mpMain = mypageDao.selectUserInfo(conn, userno);
		
		return mpMain;
	}
	
}
