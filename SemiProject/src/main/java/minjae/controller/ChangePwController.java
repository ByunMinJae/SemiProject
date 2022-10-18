package minjae.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/find/change_pw")
public class ChangePwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/find/change_pw [POST]");
		
		//요청 정보 한글인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		System.out.println(id);
		req.setAttribute("id", id);
		req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/changeFindPw.jsp").forward(req, resp);
	}
	
}
