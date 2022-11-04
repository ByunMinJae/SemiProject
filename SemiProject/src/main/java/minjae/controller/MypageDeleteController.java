package minjae.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import minjae.dto.MpMain;
import minjae.service.face.MypageService;
import minjae.service.impl.MypageServiceImpl;

@WebServlet("/mypage/delete")
public class MypageDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MypageService mypageService = new MypageServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/delete [GET]");
		
		HttpSession session = req.getSession();
		int userno = (int)session.getAttribute("userno");
		
		MpMain mpMain = mypageService.getUserInfo(userno);
		
		req.setAttribute("mpMain", mpMain);
		req.getRequestDispatcher("/WEB-INF/views/minjae/mypage/mpDeleteUser.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/delete [POST]");
		
		HttpSession session = req.getSession();
		//로그인한 유저의 userno
		int userno1 = (int)session.getAttribute("userno"); 
		
		//회원탈퇴 요청에서 넘겨준 유저의 userno
		int userno2 = Integer.parseInt(req.getParameter("deleteUser"));
		
		if(userno1 == userno2) {
			int res = mypageService.deleteUserInfo(userno1);
			
			//로그아웃 시키기
			session.invalidate();
			
			req.setAttribute("res", res);
			req.getRequestDispatcher("/WEB-INF/views/minjae/mypage/mpDeleteUser_ok.jsp").forward(req, resp);
		}
		
	}
	
}
