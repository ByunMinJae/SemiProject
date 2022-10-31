package daun.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daun.service.face.ManagerLoginService;
import daun.service.impl.ManagerLoginServiceImpl;
import donghyun.dto.UserInfo;

@WebServlet("/manager/login")
public class ManagerLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/daun/managerLogin.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달 파라미터에 대한 한글 인코딩 설정
		req.setCharacterEncoding("UTF-8");
		
		//전달 파라미터 얻기
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		
		
		ManagerLoginService ManagerLoginService = new ManagerLoginServiceImpl();
		
		UserInfo userInfo = ManagerLoginService.selectOneUser(userid, userpw);
		
		
		if( userInfo != null ) {
			
			
			//세션 객체
			HttpSession session = req.getSession();
			
			//세션 정보 저장하기
			session.setAttribute("userno", userInfo.getUserno());
			
			if( (int) session.getAttribute("userno") <= 1000 ) { 
				
	    		resp.sendRedirect("/manager/main");
	    		
			} else {
				resp.sendRedirect("/main");
			}
			
		} else {
			req.getRequestDispatcher("/WEB-INF/views/daun/managerLoginFail.jsp").forward(req, resp);
		}
	}

}
