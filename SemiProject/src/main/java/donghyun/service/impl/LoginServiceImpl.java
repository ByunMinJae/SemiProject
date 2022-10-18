package donghyun.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import donghyun.dao.face.LoginDao;
import donghyun.dao.impl.LoginDaoImpl;
import donghyun.dto.UserInfo;
import donghyun.service.face.LoginService;

public class LoginServiceImpl implements LoginService {
	LoginDao loginDao = new LoginDaoImpl();

	@Override
	public UserInfo selectOneUser(String userid, String userpw) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		UserInfo userInfo = loginDao.selectOneUser(userid, userpw, conn);
		
		return userInfo;
		
		
	}

	//-----------------------------------------------------------------------------------------------------
	
//	@Override
//	public UserInfo selectUser(HttpServletRequest req) {
//		
//		UserInfo user = new UserInfo();
//		
//		user.setUserid(req.getParameter("userid"));
//		user.setUserpw(req.getParameter("userpw"));
//		
//		return user;
//	}
//
//	@Override
//	public boolean login(UserInfo user) {
//		
//		if( loginDao.selectCntUserByUseridUserpw(JDBCTemplate.getConnection(), user) >0 ){
//			return true;
//		}
//		return false;
//	}
//
//	@Override
//	public UserInfo info(UserInfo user) {
//		return loginDao.selectUserByUserid(JDBCTemplate.getConnection(), user);
//	}
//
//	
//	
	
	

}
