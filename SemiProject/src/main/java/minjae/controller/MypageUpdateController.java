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

@WebServlet("/mypage/update")
public class MypageUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MypageService mypageService = new MypageServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/update [GET]");
	
		HttpSession session = req.getSession();
		int userno = (int)session.getAttribute("userno");
		
		MpMain mpMain = mypageService.getUserInfo(userno);
		
		req.setAttribute("mpMain", mpMain);
		req.getRequestDispatcher("/WEB-INF/views/minjae/mypage/mpUpdate.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/update [POST]");
		
		//세션에서 userno 꺼내기
		HttpSession session = req.getSession();
		int userno = (int)session.getAttribute("userno");
		
		req.setCharacterEncoding("UTF-8");
		
		String btnName = req.getParameter("btnName");
		
		if( btnName.equals("name") ) {
			
			String name = req.getParameter("info");
			System.out.println("수정 요청한 유저 번호 : " + userno);
			int res = mypageService.updateUserName(userno, name);
			
			req.setAttribute("res", res);
			req.getRequestDispatcher("/WEB-INF/views/minjae/mypage/mpUdtResult.jsp").forward(req, resp);
			return;
		} 
		
		if( btnName.equals("nick") ) {
			
			String nick = req.getParameter("info");
			System.out.println("수정 요청한 유저 번호 : " + userno);
			int res = mypageService.updateUserNick(userno, nick);
			
			req.setAttribute("res", res);
			req.getRequestDispatcher("/WEB-INF/views/minjae/mypage/mpUdtResult.jsp").forward(req, resp);
			return;
		} 
		
		if( btnName.equals("phone") ) {
			
			String phone = req.getParameter("info");
			System.out.println("수정 요청한 유저 번호 : " + userno);
			int res = mypageService.updateUserPhone(userno, phone);
			
			req.setAttribute("res", res);
			req.getRequestDispatcher("/WEB-INF/views/minjae/mypage/mpUdtResult.jsp").forward(req, resp);
			return;
		} 
		
		if( btnName.equals("address") ) {
			
			String address = req.getParameter("info");
			System.out.println("수정 요청한 유저 번호 : " + userno);
			int res = mypageService.updateUserAddr(userno, address);
			
			req.setAttribute("res", res);
			req.getRequestDispatcher("/WEB-INF/views/minjae/mypage/mpUdtResult.jsp").forward(req, resp);
			return;
		} 
	}
	
}
