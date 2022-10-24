package changmin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import changmin.service.face.PayDoService;
import changmin.service.impl.PayDoServiceImpl;
import jeonghwa.dto.Product;
import sharon.dto.User;

@WebServlet("/pay/do")
public class PayDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PayDoService payDoService = new PayDoServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/pay/do [GET]");
		
		
		//-----------------------회원 정보 조회------------------------------
		
		HttpSession session = req.getSession();
//		session.setAttribute("userno", 4);
		
		//로그인한 사람의 PK -> userno -> 2323
		//	-> 이걸 이용하여 로그인한 사람의 정보 조회 - 서비스 이용
		if( session.getAttribute("userno")==null ) {
			resp.sendRedirect("/cmc/login");
		
			
			
		} else {
			int userno = (int) session.getAttribute("userno");
			System.out.println("userno : " + userno);
			
			//로그인한 사람의 정보 조회
			User loginUser = payDoService.getUserInfo(userno);
			System.out.println(loginUser);
			
			//로그인 한 사람 정보를 모델값으로 전달
			req.setAttribute("loginUser", loginUser);
			
			//-------------------------------------------------------------------
	
			//------------------------상품 정보 조회-----------------------------
			
			req.getSession().setAttribute("prodno", 1);
			
			int prodno = (int) req.getSession().getAttribute("prodno");
			
			Product orderlist = payDoService.getProdInfo(prodno);
			
			req.setAttribute("prod", orderlist);
			
			//-------------------------------------------------------------------
	
			
			req.getRequestDispatcher("/WEB-INF/views/changmin/paydo.jsp").forward(req, resp);
	
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/pay/do [POST]");
		
		
		req.getRequestDispatcher("/WEB-INF/views/changmin/paydo.jsp").forward(req, resp);
	}
	
	
	
	
}
