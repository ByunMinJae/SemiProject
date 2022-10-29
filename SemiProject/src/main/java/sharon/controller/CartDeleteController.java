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

@WebServlet("/cart/delete")
public class CartDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CartService cartService = new CartServiceImpl();
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/cart/delete [GET]");
		//회원번호 
		HttpSession session = req.getSession();
		int userno = (int)session.getAttribute("userno"); 
		req.setAttribute("userno", userno);
		
		cartService.cartdelete();
		
		req.getRequestDispatcher("/WEB-INF/views/sharon/user/CartClear.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/cart/delete [POST]");
		req.setCharacterEncoding("UTF-8");
		
		resp.sendRedirect("/cart/list");
	
	}



}
