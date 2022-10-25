package changmin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import changmin.dto.Order;
import changmin.service.face.OrderService;
import changmin.service.impl.OrderServiceImpl;
import util.Paging2;

@WebServlet("/orderafterlist")
public class OrderViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private OrderService orderService = new OrderServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/order/view [GET]");
		
		HttpSession session = req.getSession();
				
		if( session.getAttribute("userno")==null ) {
			resp.sendRedirect("/cmc/login");
			
		} else {
			int userno = (int)session.getAttribute("userno");
			
			System.out.println("/orderafterlist userno : " + userno);
			
			Paging2 paging = orderService.getPaging(req, userno);
			 
			List<Order> orderview = orderService.orderview(paging, userno);
	
			req.setAttribute("paging", paging);
			req.setAttribute("orderView", orderview);
			System.out.println(orderview);
			
			req.getRequestDispatcher("/WEB-INF/views/changmin/orderview.jsp").forward(req, resp);

		}
	}
	

}
