package minjae.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/find/checkPw")
public class checkPwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/find/checkPw [GET]");
		
		//전달받은 정보객체 에서 비밀번호값 꺼내기
		String pw = req.getParameter("pw");
		req.setAttribute("pw", pw);
		req.getRequestDispatcher("/WEB-INF/views/minjae/findUser/successFindPw.jsp").forward(req, resp);
	}
	
}
