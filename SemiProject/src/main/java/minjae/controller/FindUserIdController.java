package minjae.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import dto.UserFind;
import minjae.dto.UserInfo;
import minjae.service.face.FindUserService;
import minjae.service.impl.FindUserServiceImpl;

@WebServlet("/find/findid")
public class FindUserIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FindUserService findUseService = new FindUserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/find/userid [GET]");
		
		req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/findIdForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/find/userid [POST]");
		
		//요청 이메일 정보
		String email = req.getParameter("userEmail");
		
		//요청 이메일이 빈 칸일 경우
		if( "".equals(email) ) {
			req.getRequestDispatcher("/WEB-INF/views/findUser/notFoundEmail.jsp").forward(req, resp);
			return;
		}
		//해당 이메일 유저 확인 후 정보 가져오기
		UserInfo user = findUseService.checkEmail(email);
		System.out.println(user);
		
		//해당 이메일로 가입한 유저가 없을 경우
//		if( user == null ) {
//			req.getRequestDispatcher("/WEB-INF/views/findUser/notFoundEmail.jsp").forward(req, resp);
//			return;
//		} else {
//			//인증번호 생성
//			findUseService.createAuth(user);
//			
//			//인증번호 가져오기
//			UserFind userFind = findUseService.getUserFind(user);
//			System.out.println(userFind);
//			
//			//인증번호 이메일로 발송
//			findUseService.sendEmail(userFind);
//			
//			req.setAttribute("userFind", userFind);
//			req.getRequestDispatcher("/WEB-INF/views/findUser/checkEmailForId.jsp").forward(req, resp);
//		}
		
	}
	
}
