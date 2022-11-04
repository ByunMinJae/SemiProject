package minjae.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import minjae.service.face.MypageService;
import minjae.service.impl.MypageServiceImpl;

@WebServlet("/mypage/upcheck")
public class MypageUpCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MypageService mypageService = new MypageServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/upcheck [POST]");
		
		req.setCharacterEncoding("UTF-8");
		
		//눌려진 수정버튼의 종류
		String btnName = req.getParameter("btnName");
		
		//닉네임 수정일 때 검사
		if( btnName.equals("nick") ) {
			String nick = req.getParameter("info");
			int resNick = mypageService.existNick(nick);
			
			System.out.println(resNick);
			req.setAttribute("resNick", resNick);
			req.getRequestDispatcher("/WEB-INF/views/minjae/mypage/mpExistNick.jsp").forward(req, resp);
			return;
		}
		
		//전화번호 수정일 때 검사
		if( btnName.equals("phone") ) {
			String phone = req.getParameter("info");
			int resPhone = mypageService.existPhone(phone);
			
			req.setAttribute("resPhone", resPhone);
			req.getRequestDispatcher("/WEB-INF/views/minjae/mypage/mpExistPhone.jsp").forward(req, resp);
			return;
		}

		
	}
	
}
