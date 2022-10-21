package minjae.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import minjae.service.face.MypageService;
import minjae.service.impl.MypageServiceImpl;

@WebServlet("/mypage/pwcheck")
public class MypagePWCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MypageService mypageService = new MypageServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/pwcheck [POST]");
		
		//다이얼로그로 넘어온 비밀번호 변수에 저장
		String pw = req.getParameter("pw");
		
		//로그인 유저의 세션정보에서 유저번호 꺼내기
		HttpSession session = req.getSession();
		int userno = (int)session.getAttribute("userno");
		
		//입력받은 pw가 현재 로그인한 회원의 패스워드가 맞는지 확인 하고 결과 반환
		boolean res = mypageService.checkUserpw(userno, pw);
		System.out.println(res);
		
		req.setAttribute("res", res);
		req.getRequestDispatcher("/WEB-INF/views/minjae/mypage/mpPwCheckMsg.jsp").forward(req, resp);
		
		
	}
	
}










