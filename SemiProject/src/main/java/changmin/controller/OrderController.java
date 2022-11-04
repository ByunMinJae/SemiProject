package changmin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import changmin.service.face.OrderService;
import changmin.service.impl.OrderServiceImpl;
import minjae.dto.Product;

@WebServlet("/ordersuccess")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OrderService orderService = new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Order [GET]");
		
	
		req.getRequestDispatcher("/WEB-INF/views/changmin/ordersuccess.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Order [POST]");

		req.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession();
		
		int userno = (int)session.getAttribute("userno");
		
		System.out.println("prodno : " + req.getParameter("prodno"));
		
		String prodno = req.getParameter("prodno");

		//상품 구매시 상품판매량 + 1
		orderService.prodUpdate(prodno);

		//상품 구매시 주문목록 DB INSERT
		orderService.orderinsert(req, userno);
		
		
		req.getRequestDispatcher("/WEB-INF/views/changmin/ordersuccess.jsp").forward(req, resp);
	}
	
	
}
