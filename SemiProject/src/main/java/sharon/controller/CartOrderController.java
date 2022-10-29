package sharon.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sharon.service.face.CartService;
import sharon.service.impl.CartServiceImpl;

@WebServlet("/cart/order")
public class CartOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CartService cartservice = new CartServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/cart/order [GET]");
		//회원번호
		HttpSession session = req.getSession();
		int userno = (Integer)(session.getAttribute("userno"));
		System.out.println("회원번호:"+userno);
		
		//buyprodname null->오류->paydo에 보내야하는데..
		System.out.println(req.getParameter("buyprodname") + " : " + req.getParameter("totalamount"));
		int res = cartservice.insertBuyProd(req, userno);
		
		
		if(res > 0) {
			req.setAttribute("prodno", req.getParameter("prodno"));
			req.getRequestDispatcher("/pay/do").forward(req, resp);
		} else {
			req.getRequestDispatcher("/WEB-INF/views/minjae/notInsertBuyProd.jsp").forward(req, resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}


}
