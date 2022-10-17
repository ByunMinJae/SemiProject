package changmin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import changmin.dto.Pay;
import changmin.service.face.PayDoService;
import changmin.service.impl.PayDoServiceImpl;

@WebServlet("/pay/do")
public class PayDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private PayDoService payDoService = new PayDoServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/pay/do [GET]");
		
		
		Pay pay = payDoService.paydo();
		
		req.getRequestDispatcher("/WEB-INF/views/changmin/paydo.jsp").forward(req, resp);
	
	}
	
}
