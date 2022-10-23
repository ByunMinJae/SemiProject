package changmin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import changmin.dto.Order;
import changmin.service.face.OrderService;
import changmin.service.impl.OrderServiceImpl;

@WebServlet("/orderafterlist")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Order order = new Order();
	private OrderService orderService = new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Order [GET]");
		
//		order.setMerchant_uid(req.getParameter("merchant_uid"));
//		order.setProdname(req.getParameter("name"));
//		order.setAmount(Integer.parseInt(req.getParameter("amount")));
//		order.setBuyeremail(req.getParameter("buyer_email"));
//		order.setBuyername(req.getParameter("buyer_name"));
//		order.setBuyertel(req.getParameter("buyer_tel"));
//		order.setBuyeraddr(req.getParameter("buyer_addr"));
//		order.setBuyeraddr(req.getParameter("buyer_addr"));
		
		
//		   pay_method: "card",
//		    merchant_uid: "ORD20180131-0000011",
//		    name: $("#prodnamevalue").val(),
//		    amount: $("#prodpricevalue").val(),
//		    buyer_email: $("#emailvalue").val(),
//		    buyer_name: $("#prodpricevalue").val(),
//		    buyer_tel: $("#phonevalue").val(),
//		    buyer_addr
	
	
		req.getRequestDispatcher("/WEB-INF/views/changmin/orderafterlist.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Order [POST]");

//		Gson gson = new Gson();
//		Pay pay = gson.fromJson( req.getParameter("pay_method"), Pay.class);
//		System.out.println(pay);
		
		order.setMerchant_uid(req.getParameter("merchant_uid"));
		order.setProdname(req.getParameter("name"));
		order.setAmount(Integer.parseInt(req.getParameter("amount")));
		order.setBuyeremail(req.getParameter("buyer_email"));
		order.setBuyername(req.getParameter("buyer_name"));
		order.setBuyertel(req.getParameter("buyer_tel"));
		order.setBuyeraddr(req.getParameter("buyer_addr"));
		
		String test = req.getParameter("pay_method");
		System.out.println(test);
		
		Order orderinsert = orderService.orderinsert(req);
		
		
		req.getRequestDispatcher("/WEB-INF/views/changmin/orderafterlist.jsp").forward(req, resp);
	}
	
	
}
