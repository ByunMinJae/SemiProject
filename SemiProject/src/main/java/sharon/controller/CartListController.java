package sharon.controller;

import java.io.IOException;  
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sharon.dto.Cart;
import sharon.dto.Product;
import sharon.service.face.CartService;
import sharon.service.impl.CartServiceImpl;

@WebServlet("/cart/list")
public class CartListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Service객체
	private CartService cartService = new CartServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/cart/list [GET]");

		
		
		
		List<Cart> cartList = cartService.getList();
		
		req.setAttribute("cartList", cartList);
		System.out.println( "CartListController:"+cartList );
		
		
		req.getRequestDispatcher("/WEB-INF/views/sharon/user/CartView.jsp").forward(req, resp);

}


}
