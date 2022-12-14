package minjae.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import minjae._common.Coolsms;
import minjae._common.JavaMail;
import minjae.dao.face.FindUserDao;
import minjae.dao.impl.FindUserDaoImpl;
import minjae.dto.UserFind;
import minjae.dto.UserInfo;
import minjae.service.face.FindUserService;

public class FindUserServiceImpl implements FindUserService {
	
	private FindUserDao findUserDao = new FindUserDaoImpl(); 
	private JavaMail javaMail = new JavaMail(); //메일 전송 클래스 객체
	private Coolsms coolsms = new Coolsms(); 	//문자 전송 클래스 객체
	
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
		System.out.println("FindUserService sendEmail() - 시작");
		javaMail.sendAuthEmail(userFind);
		System.out.println("FindUserService sendEmail() - 끝");
	}
	
	@Override
	public UserInfo getUserInfoByPhone(String name, String phone, String birth) {
		System.out.println("FindUserService getUserInfoByPhone() - 시작");
		
		Connection conn = JDBCTemplate.getConnection();
		
		UserInfo userInfo = findUserDao.selectPhone(conn, name, phone, birth);
		
		System.out.println("FindUserService getUserInfoByPhone() - 끝");
		return userInfo;
	}
	
	@Override
	public void sendSms(UserInfo user, UserFind userFind) {
		System.out.println("FindUserService sendSms() - 시작");
		coolsms.sendAuthSms(user, userFind);
		System.out.println("FindUserService sendSms() - 끝");
	}

	@Override
	public UserInfo checkId(String id) {
		System.out.println("FindUserService checkId() - 시작");

		Connection conn = JDBCTemplate.getConnection();
		
		UserInfo userInfo = findUserDao.selectId(conn, id);
		
		System.out.println("FindUserService checkId() - 끝");
		return userInfo;
	}
	
	@Override
	public UserInfo checkIdPhone(String id, String phone) {
		System.out.println("FindUserService checkIdPhone() - 시작");

		Connection conn = JDBCTemplate.getConnection();
		
		UserInfo userInfo = findUserDao.selectIdPhone(conn, id, phone);
		
		System.out.println("FindUserService checkIdPhone() - 끝");
		return userInfo;
	}
	
	@Override
	public boolean updateUserPw(String id, String upw) {
		System.out.println("FindUserService updateUserPw() - 시작");
		
		Connection conn = JDBCTemplate.getConnection();

		int res = findUserDao.updatePwById(conn, id, upw);
		
		if( res > 0 ) {
			JDBCTemplate.commit(conn);
			System.out.println("FindUserService updateUserPw() - 끝");
			return true;
		} else {
			JDBCTemplate.rollback(conn);
			System.out.println("FindUserService updateUserPw() - 끝");
			return false;
		}
		
	}

	@Override
	public int existPw(HttpServletRequest req) {
		System.out.println("FindUserService updateUserPw() - 시작");
		
		Connection conn = JDBCTemplate.getConnection();
		
		String pw = req.getParameter("pw");
		
		int res = findUserDao.selectExistPw(conn, pw);
		
		System.out.println("FindUserService updateUserPw() - 끝");
		return res;
	}

	
	
}
