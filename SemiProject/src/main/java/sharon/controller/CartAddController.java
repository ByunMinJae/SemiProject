package sharon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sharon.dto.Cart;
import sharon.dto.Product;
import sharon.service.face.CartService;
import sharon.service.impl.CartServiceImpl;

@WebServlet("/cart/add")
public class CartAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CartService cartService = new CartServiceImpl();
       

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/cart/add [GET]");
		
		//상품 가져오기
		int prodno = Integer.parseInt(req.getParameter("prodno"));
		Product prod = cartService.getProd(prodno);
		req.setAttribute("prod", prod);
		System.out.println("장바구니 선택 상품:"+prod);
		
		cartService.cartinsert(req);
		
		List<Cart> cart= cartService.getList();

		req.getRequestDispatcher("/WEB-INF/views/sharon/user/CartPro.jsp").forward(req, resp);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/cart/add [POST]");
		req.setCharacterEncoding("UTF-8");
		
		
		resp.sendRedirect("/cart/list");
	}

}
