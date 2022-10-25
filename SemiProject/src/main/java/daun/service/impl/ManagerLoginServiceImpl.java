package daun.service.impl;

import java.sql.Connection;

import common.JDBCTemplate;
import daun.dao.face.ManagerLoginDao;
import daun.dao.impl.ManagerLoginDaoImpl;
import daun.service.face.ManagerLoginService;
import donghyun.dto.UserInfo;

public class ManagerLoginServiceImpl implements ManagerLoginService {
	
	ManagerLoginDao managerLoginDao = new ManagerLoginDaoImpl();
	
	@Override
	public UserInfo selectOneUser(String userid, String userpw) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		UserInfo userInfo = managerLoginDao.selectOneUser(userid, userpw, conn);
		
		return userInfo;
	}
	
	

}
