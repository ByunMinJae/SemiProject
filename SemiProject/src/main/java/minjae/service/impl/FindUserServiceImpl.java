package minjae.service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import minjae._common.JavaMail;
import minjae.dao.face.FindUserDao;
import minjae.dao.impl.FindUserDaoImpl;
import minjae.dto.UserFind;
import minjae.dto.UserInfo;
import minjae.service.face.FindUserService;

public class FindUserServiceImpl implements FindUserService {
	
	private FindUserDao findUserDao = new FindUserDaoImpl();
	private JavaMail javaMail = new JavaMail();
	
	@Override
	public UserInfo checkEmail(String email) {
		System.out.println("FindUserService checkEmail() - 시작");
		
		Connection conn = JDBCTemplate.getConnection();
		
		UserInfo user = findUserDao.selectEmail(conn, email);
		
		System.out.println("FindUserService checkEmail() - 끝");
		return user;
	}
	
	@Override
	public void createAuth(UserInfo user) {
		System.out.println("FindUserService createAuth() - 시작");
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = findUserDao.insertAuth(conn, user);
		if( result > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		System.out.println("FindUserService createAuth() - 끝");
	}
	
	@Override
	public UserFind getUserFind(UserInfo user) {
		System.out.println("FindUserService getUserFind() - 시작");
		
		Connection conn = JDBCTemplate.getConnection();
		
		UserFind userFind = findUserDao.selectAuth(conn, user);
		
		System.out.println("FindUserService getUserFind() - 끝");
		return userFind;
	}
	
	@Override
	public void sendEmail(UserFind userFind) {
		System.out.println("FindUserService sendEmail - 시작");
		javaMail.sendAuthEmail(userFind);
		System.out.println("FindUserService sendEmail - 끝");
	}
	
}
