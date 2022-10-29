package donghyun.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import donghyun.dao.face.PunishDao;
import donghyun.dao.impl.PunishDaoImpl;
import donghyun.dto.UserInfo;
import donghyun.service.face.PunishService;

public class PunishServiceImpl implements PunishService {
	PunishDao punishDao = new PunishDaoImpl();

	@Override
	public void getPunish(int userno) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		if(punishDao.getPunish(conn, userno)>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
	}

	
		
	
	

}
