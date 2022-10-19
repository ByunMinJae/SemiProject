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
		
		//--- 휴대전화 문자인증으로 비밀번호 찾기 ---
		req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/findPwForm.jsp").forward(req, resp);
		
		//--- 아이디 입력/KG이니시스 통합인증으로 비밀번호 찾기 ---
//		req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/findPwForm_02.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/find/findpw [POST]");
		
		//요청 정보 한글인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
		//요청 아이디 정보
		String id = req.getParameter("userId");
		String phone = req.getParameter("userPhone");
		System.out.println("입력한 정보 : 아이디 - " + id + ", 전화번호 - " + phone);
		
		//성명을 입력하지 않았을 때
		if( "".equals(id) ) {
			//확인 메세지 반환
			req.setAttribute("userId", id);
			req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/notFoundId.jsp").forward(req, resp);
			return;
		}
		//전화번호를 입력하지 않았을 때
		if( "".equals(phone) ) {
			//확인 메세지 반환
			req.setAttribute("userPhone", phone);
			req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/notFoundPhone.jsp").forward(req, resp);
			return;
		}
		
		//해당 아이디, 전화번호 유저 확인 후 정보 가져오기
		UserInfo user = findUseService.checkIdPhone(id, phone);
		System.out.println("해당 유저 정보 : " + user);
		
		//해당 아이디, 전화번호 가입한 유저가 없을 경우
		if( user == null ) {
			//확인 메세지 반환
			req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/notFoundId.jsp").forward(req, resp);
			return;
		} else {
			//인증번호 생성
			findUseService.createAuth(user);
			
			//인증번호 가져오기
			UserFind userFind = findUseService.getUserFind(user);
			System.out.println("해당 유저의 인증번호 정보 : " + userFind);
			
			//인증번호 문자로 발송 (건당 20원 문자까지 테스트할 때만 주석 풀 것)
//			findUseService.sendSms(user, userFind);
			
			//전달 속성 설정
			req.setAttribute("userFind", userFind);
			
			//View 지정 및 포워드
			req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/checkSmsForPw.jsp").forward(req, resp);
		}
		
	}
	
}
