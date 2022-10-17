package changmin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/pay/do [POST]");
		
		//전달 파라미터에 대한 한글 인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
		//전달 파라미터 얻기
		String userid=null;
		String email=null;
		
		userid = req.getParameter("userid");
		email = req.getParameter("email");
		
		System.out.println("PayDoController doPost() - id : " + userid);
		System.out.println("PayDoController doPost() - pass : " + email);
		
		//-----------------------------------------------------------------
		
		//로그인 인증 - 제대로된 ID & PASS 인지 검사
		
		HttpSession session = req.getSession();
		
		//세션 정보 저장하기
		session.setAttribute("userid", userid);
		session.setAttribute("email", email);
		
		
		req.getRequestDispatcher("/WEB-INF/views/login/loginSuccess.jsp").forward(req, resp);
			 
	}
	
}
