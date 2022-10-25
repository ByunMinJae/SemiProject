package changmin.service.impl;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

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
	public void orderinsert(HttpServletRequest req) {
		
		Order order = new Order();

		order.setPaymethod(req.getParameter("pay_method"));
		order.setMerchant_uid(req.getParameter("merchant_uid"));
		order.setProdname(req.getParameter("name"));
		order.setAmount(Integer.parseInt(req.getParameter("amount").trim()));
		order.setBuyeremail(req.getParameter("buyer_email"));
		order.setBuyername(req.getParameter("buyer_name"));
		order.setBuyertel(req.getParameter("buyer_tel"));
		order.setBuyeraddr(req.getParameter("buyer_addr"));
		order.setOrderno(Integer.parseInt(req.getParameter("orderno").trim()));
		
//		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-mm-dd");
//		String date = req.getParameter("orderdate");
//		Date tDate = transFormat(date);
//		
//		order.setOrderdate(tDate);
		
		int res = orderDao.insertOrder(conn,order);
			
			if( res > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			
		}
	@Override
	public List<Order> orderview() {

		return orderDao.orderList(conn);
	}


}
