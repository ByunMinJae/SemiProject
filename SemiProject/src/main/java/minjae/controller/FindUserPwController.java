package minjae.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import minjae.dto.UserFind;
import minjae.dto.UserInfo;
import minjae.service.face.FindUserService;
import minjae.service.impl.FindUserServiceImpl;

@WebServlet("/find/findpw")
public class FindUserPwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FindUserService findUseService = new FindUserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/find/findpw [GET]");
		
//		req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/findPwForm.jsp").forward(req, resp);
		req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/findPwForm_02.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/find/findpw [POST]");
		
		//요청 정보 한글인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
		//요청 아이디 정보
		String id = req.getParameter("userid");
		System.out.println("입력한 아이디 : " + id);
		
		//해당 아이디 유저 확인 후 정보 가져오기
		UserInfo user = findUseService.checkId(id);
		System.out.println("해당 유저 정보 : " + user);
		
		if( user == null ) { //해당 아이디로 가입한 유저가 없을 때
			resp.getWriter().print(""); //false 반환
			
		} else { //해당 아이디로 가입한 유저가 있을 때
//			resp.getWriter().print("true"); //true 반환
			resp.getWriter().print(id); //true 반환
			
		}
		
		// email 인증으로 할 경우 주석 해제
		//요청 이메일이 빈 칸일 경우
//		if( "".equals(email) ) {
//			//확인 메세지 반환
//			req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/notFoundEmail.jsp").forward(req, resp);
//			return;
//		}
		
		//해당 이메일로 가입한 유저가 없을 경우
//		if( user == null ) {
//			//확인 메세지 반환
//			req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/notFoundEmail.jsp").forward(req, resp);
//			return;
//		} else {
//			//인증번호 생성
//			findUseService.createAuth(user);
//			
//			//인증번호 가져오기
//			UserFind userFind = findUseService.getUserFind(user);
//			System.out.println("해당 유저의 인증번호 정보 : " + userFind);
//			
//			//인증번호 이메일로 발송
//			findUseService.sendEmail(userFind);
//			
//			//전달 속성 설정
//			req.setAttribute("userFind", userFind);
//			//View 지정 및 전달
//			req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/checkEmailForPw.jsp").forward(req, resp);
//		}
		
	}
	
}
