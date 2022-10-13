package minjae.service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import minjae.dao.face.FindUserDao;
import minjae.dao.impl.FindUserDaoImpl;
import minjae.dto.UserInfo;
import minjae.service.face.FindUserService;

public class FindUserServiceImpl implements FindUserService {
	
	private FindUserDao findUserDao = new FindUserDaoImpl();
	
	@Override
	public UserInfo checkEmail(String email) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		UserInfo user = findUserDao.selectEmail(conn, email);
		
		return user;
		
	}

}
