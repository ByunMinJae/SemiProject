package changmin.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import changmin.dao.face.PayDoDao;
import changmin.dao.impl.PayDoDaoImpl;
import changmin.dto.OrderBefore;
import changmin.dto.Pay;
import changmin.service.face.PayDoService;
import common.JDBCTemplate;
import jeonghwa.dto.Product;
import sharon.dto.User;

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



//	@Override
//	public OrderBefore getOrderInfo(int orderno) {
//		
//		return payDoDao.getOrderInfo(conn, orderno);
//	}
	
	@Override
	public OrderBefore getOrderInfo(int userno) {
		
		return payDoDao.getOrderInfo(conn, userno);
	}



}
