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
				
		//로그인상태가 아닐때 로그인페이지로 이동
		if( session.getAttribute("userno")==null ) {
			resp.sendRedirect("/cmc/login");
			
		} else {
			//로그인상태일 경우 userno에 따른 주문목록 조회
			int userno = (int)session.getAttribute("userno");
			System.out.println("/orderafterlist userno : " + userno);
			
			String word = req.getParameter("word");
			
			//검색한 값이 없을때
			if ( word==null || word.equals("")) {
				System.out.println("디폴트페이지");
				
				Paging2 paging = orderService.getPaging(req, userno);
				List<Order> orderview = orderService.orderview(paging, userno);
		
				req.setAttribute("paging", paging);
				req.setAttribute("orderView", orderview);
			
			//검색한 값이 있을때
			} else {
				System.out.println("검색페이지");
				
				Paging2 paging = orderService.getPaging(req, userno, word);
				List<Order> orderview = orderService.orderview(paging, userno, word);
		
				req.setAttribute("paging", paging);
				req.setAttribute("orderView", orderview);
				req.setAttribute("word", word);
				
			}
			
			req.getRequestDispatcher("/WEB-INF/views/changmin/orderview.jsp").forward(req, resp);

		}
	}
	

}
