package minjae.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import minjae.dto.MpMain;
import minjae.dto.MpMainRight;
import minjae.service.face.MypageService;
import minjae.service.impl.MypageServiceImpl;

@WebServlet("/mypage/main")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MypageService mypageService = new MypageServiceImpl(); 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/main [GET]");
		
		HttpSession session = req.getSession();
		session.setAttribute("userno", 14);
		int userno = (int)session.getAttribute("userno");
		
		MpMain mpMain = mypageService.getUserInfo(userno);
		MpMainRight mpMR = mypageService.getOrderInfo(userno);
		
		req.setAttribute("mpMain", mpMain);
		req.setAttribute("mpMR", mpMR);
		req.getRequestDispatcher("/WEB-INF/views/minjae/mypage/mypageMain.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/main [POST]");
		
		//전달 받은 date 변수에 저장
		int userno = Integer.parseInt(req.getParameter("userno"));
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		System.out.println("userno, date1, date2 : " + userno + ", " + startDate + ", " + endDate);
		
		MpMainRight mpMR = mypageService.getOrderInfoByDate(userno, startDate, endDate);
		System.out.println(mpMR);
		
		req.setAttribute("mpMR", mpMR);
		req.getRequestDispatcher("/WEB-INF/views/minjae/mypage/mpSelectOrderProc.jsp").forward(req, resp);
		
	}
	
}
