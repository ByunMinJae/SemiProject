package changmin.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import changmin.dao.face.PayDoDao;
import changmin.dao.impl.PayDoDaoImpl;
import changmin.dto.Pay;
import changmin.dto.Product;
import changmin.dto.User;
import changmin.service.face.PayDoService;
import common.JDBCTemplate;

public class PayDoServiceImpl implements PayDoService{

	private PayDoDao payDoDao = new PayDoDaoImpl();
	private Connection conn = JDBCTemplate.getConnection();

	@Override
	public User getUserInfo(int userno) {
		
		return payDoDao.getUserInfo(conn, userno);
	}


	@Override
	public Pay paydo(HttpServletRequest req) {
		return null;
	}


	@Override
	public Product getProdInfo(int prodno) {
		
		return payDoDao.getProdInfo(conn, prodno);
	}


	@Override
	public User updateUser(int userno) {

		
		return payDoDao.updateUser(conn, userno);
	}


}
