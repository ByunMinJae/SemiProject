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
		
		if( null == req.getParameter("userName") ) { // 이메일로 아이디 찾기
			
			//요청 이메일 정보
			String email = req.getParameter("userEmail");
			System.out.println("입력한 이메일 : " + email);
			
			//요청 이메일이 빈 칸일 경우
			if( "".equals(email) ) {
				//확인 메세지 반환
				req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/notFoundEmail.jsp").forward(req, resp);
				return;
			}
			
			//해당 이메일 유저 확인 후 정보 가져오기
			UserInfo user = findUseService.checkEmail(email);
			System.out.println("해당 유저 정보 : " + user);
			
			//해당 이메일로 가입한 유저가 없을 경우
			if( user == null ) {
				//확인 메세지 반환
				req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/notFoundEmail.jsp").forward(req, resp);
				return;
			} else {
				//인증번호 생성
				findUseService.createAuth(user);
				
				//인증번호 가져오기
				UserFind userFind = findUseService.getUserFind(user);
				System.out.println("해당 유저의 인증번호 정보 : " + userFind);
				
				//인증번호 이메일로 발송
				findUseService.sendEmail(userFind);
				
				//전달 속성 설정
				req.setAttribute("userFind", userFind);
				//View 지정 및 전달
				req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/checkEmailForId.jsp").forward(req, resp);
			}
			
		} else { //전화번호로 아이디 찾기
			
			//입력받은 정보
			String name = req.getParameter("userName");
			String birth = req.getParameter("userBirth");
			String phone = req.getParameter("userPhone");
			System.out.println("입력한 정보 : 이름 - " + name + ", 생년월일 - " + birth + ", 전화번호 - " + phone );

			//성명을 입력하지 않았을 때
			if( "".equals(name) ) {
				//확인 메세지 반환
				req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/notFoundName.jsp").forward(req, resp);
				return;
			}
			//전화번호를 입력하지 않았을 때
			if( "".equals(phone) ) {
				//확인 메세지 반환
				req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/notFoundPhone.jsp").forward(req, resp);
				return;
			}
			
			//파라미터를 이용해 일치하는 유저정보 조회
			UserInfo user = findUseService.getUserInfoByPhone(name, phone, birth);
			System.out.println("해당 유저 정보 : " + user);
			
			//해당 정보로 가입한 유저가 없을 경우
			if( user == null ) {
				//확인 메세지 반환
				req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/notFoundPhone.jsp").forward(req, resp);
				return;
			} else {
				//인증번호 생성
				findUseService.createAuth(user);
				
				//인증번호 가져오기
				UserFind userFind = findUseService.getUserFind(user);
				System.out.println("해당 유저의 인증번호 정보 : " + userFind);
				
				//인증번호 문자로 발송 (건당 20원 문자까지 테스트할 때만 주석 풀 것)
//				findUseService.sendSms(user, userFind);
				
				//전달 속성 설정
				req.setAttribute("userFind", userFind);
				//View 지정 및 전달
				req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/checkSmsForId.jsp").forward(req, resp);
				
			}
			
		}
		
		
	}
	
}
