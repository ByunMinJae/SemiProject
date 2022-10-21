package minjae.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import minjae.service.face.FindUserService;
import minjae.service.impl.FindUserServiceImpl;

@WebServlet("/find/update_pw")
public class UpdatePwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FindUserService findUserService = new FindUserServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String upw = req.getParameter("upw");
		System.out.println("업데이트 : " + id + " :  " + upw);
		
		//아이디를 이용해 패스워드 변경 후 결과 반환
		boolean isComp = findUserService.updateUserPw(id, upw);
		
		if( isComp ) {
			//View 지정 및 포워드
			req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/successFindPw.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/failUpdatePw.jsp").forward(req, resp);
		}
	}
}
