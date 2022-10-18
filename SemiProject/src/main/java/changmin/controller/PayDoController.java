package changmin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import changmin.dto.User;
import changmin.service.face.PayDoService;
import changmin.service.impl.PayDoServiceImpl;

@WebServlet("/pay/do")
public class PayDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PayDoService payDoService = new PayDoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/pay/do [GET]");
		
		//테스트 용 데이터
		req.getSession().setAttribute("userno", 2323);
		
		//로그인한 사람의 PK -> userno -> 2323
		//	-> 이걸 이용하여 로그인한 사람의 정보 조회 - 서비스 이용
		
		 
		int userno = (int) req.getSession().getAttribute("userno");
		
		//로그인한 사람의 정보 조회
		User loginUser = payDoService.getUserInfo(userno);
		System.out.println(loginUser);
		
		//로그인 한 사람 정보를 모델값으로 전달
		req.setAttribute("loginUser", loginUser);
		
		
//		Pay pay = payDoService.paydo(req);
//		req.setAttribute("pay", pay);
		
		req.getRequestDispatcher("/WEB-INF/views/changmin/paydo.jsp").forward(req, resp);
	
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("/pay/do [POST]");
//		
//		//전달 파라미터에 대한 한글 인코딩 설정
//		req.setCharacterEncoding("UTF-8");
//		
//		//전달 파라미터 얻기
//		String userid=null;
//		String email=null;
//		
//		userid = req.getParameter("userid");
//		email = req.getParameter("email");
//		
//		System.out.println("PayDoController doPost() - id : " + userid);
//		System.out.println("PayDoController doPost() - pass : " + email);
//		
//		//-----------------------------------------------------------------
//		
//		HttpSession session = req.getSession();
//		
//		//세션 정보 저장하기
//		session.setAttribute("userid", userid);
//		session.setAttribute("email", email);
//		
//		
//		req.getRequestDispatcher("/WEB-INF/views/changmin/paydo.jsp").forward(req, resp);
//			 
//	}
	
}
