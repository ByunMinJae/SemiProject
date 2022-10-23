package changmin.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import changmin.dao.face.OrderDao;
import changmin.dao.impl.OrderDaoImpl;
import changmin.dto.Order;
import changmin.service.face.OrderService;
import common.JDBCTemplate;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao = new OrderDaoImpl();
	private Connection conn = JDBCTemplate.getConnection();

	@Override
	public Order orderinsert(HttpServletRequest req) {
		return orderDao.orderinsert(conn);
	}

}
