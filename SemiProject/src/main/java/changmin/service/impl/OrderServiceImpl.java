package changmin.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import changmin.dao.face.OrderDao;
import changmin.dao.impl.OrderDaoImpl;
import changmin.dto.Order;
import changmin.service.face.OrderService;
import common.JDBCTemplate;
import util.Paging;
import util.Paging2;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao = new OrderDaoImpl();
	private Connection conn = JDBCTemplate.getConnection();
	@Override
	public void orderinsert(HttpServletRequest req, int userno) {
		
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
		
		int res = orderDao.insertOrder(conn,order,userno);
			
			if( res > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			
		}
	

	@Override
	public Paging2 getPaging(HttpServletRequest req, int userno) {
		
		//총 게시글 수 조회하기
		int totalCount = orderDao.selectCntAll(JDBCTemplate.getConnection(), userno);
		
		
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//Paging객체 생성
		Paging2 paging = new Paging2(totalCount, curPage);
		
		return paging;
	}

	@Override
	public List<Order> orderview(Paging2 paging, int userno) {

		System.out.println(paging.getListCount());
		 
		return orderDao.selectAll(conn, paging, userno);
	}


}
