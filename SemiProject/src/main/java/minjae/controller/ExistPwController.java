package minjae.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import minjae.service.face.FindUserService;
import minjae.service.impl.FindUserServiceImpl;

@WebServlet("/find/existpw")
public class ExistPwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FindUserService findUserService = new FindUserServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/find/existpw [POST]");

		int res = findUserService.existPw(req);
		System.out.println("결과 값 : " + res);
		
		req.setAttribute("res", res);
		req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/existPw.jsp").forward(req, resp);
	}
	
}
