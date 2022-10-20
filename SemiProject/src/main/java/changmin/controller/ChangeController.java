package changmin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import changmin.dto.User;
import changmin.service.face.PayDoService;
import changmin.service.impl.PayDoServiceImpl;

@WebServlet("/address/change")
public class ChangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PayDoService payDoService = new PayDoServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/address/change [GET]");
		
		
		req.getRequestDispatcher("/WEB-INF/views/changmin/change.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		System.out.println("/address/change [GET]");
		System.out.println("/address/change [POST]");
	
		int userno = (int) req.getSession().getAttribute("userno");
		
		String[] address = req.getParameterValues("data");
		System.out.println(address);
		
		
		//로그인한 사람의 정보 조회
		User loginUser = payDoService.getUserInfo(userno);
		
		req.setAttribute("loginUser", loginUser);
		
		req.getRequestDispatcher("/WEB-INF/views/changmin/change.jsp").forward(req, resp);
	}
}
