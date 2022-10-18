package changmin.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import changmin.dao.face.PayDoDao;
import changmin.dao.impl.PayDoDaoImpl;
import changmin.dto.Pay;
import changmin.dto.User;
import changmin.service.face.PayDoService;
import common.JDBCTemplate;

public class PayDoServiceImpl implements PayDoService{

	private PayDoDao payDoDao = new PayDoDaoImpl();


	@Override
	public User getUserInfo(int userno) {
		Connection conn = JDBCTemplate.getConnection();
		
		return payDoDao.getUserInfo(conn, userno);
	}


	@Override
	public Pay paydo(HttpServletRequest req) {
		return null;
	}


}
