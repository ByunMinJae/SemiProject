package donghyun.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import donghyun.dto.UserInfo;
import donghyun.service.face.LoginService;
import donghyun.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/cmc/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private LoginService loginService = new LoginServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    	System.out.println("/cmc/login 내 코드 [GET]" );
    	
    	String rootPath = System.getProperty("user.dir");
    	System.out.println(rootPath);
    	
    	
    	
    	//System.out.println("/cmc/login 선생님 코드[GET]");
    	
    	req.getRequestDispatcher("/WEB-INF/views/donghyun/loginForm.jsp").forward(req, resp);
    	//resp.sendRedirect("../../src/webapp/WEB-INF/views/donghyun/loginForm.jsp");
    	
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	req.setCharacterEncoding("UTF-8");
    	
    	System.out.println("/cmc/login 내 코드 [POST]");
    	//System.out.println("/cmc/login 선생님 코드[POST]");
    	
    	
    	
    	String userid = req.getParameter("userid");
    	String userpw = req.getParameter("userpw");
    	
    	System.out.println("userid :" + userid);
    	System.out.println("userpw :" + userpw);
    	
    	LoginService loginService = new LoginServiceImpl();
    	
    	UserInfo userInfo = loginService.selectOneUser(userid, userpw);
    	
    	if(userInfo != null) {
    		HttpSession session = req.getSession();
    		session.setAttribute("userid", userid);
    		
    		//req.getRequestDispatcher("/WEB-INF/views/donghyun/loginSuccess.jsp").forward(req, resp);
    		resp.sendRedirect("/");
    	}
    	
    	
    	
    	
    	//-------------------------------------------------------------------------
    	
    	
    	
//    	UserInfo user = loginService.selectUser(req);
//    	
//    	boolean isLogin = loginService.login(user);
//    	
//    	if( isLogin ) {
//    		
//    		user = loginService.info(user);
//    		
//    		HttpSession session = req.getSession();
//    		
//    		session.setAttribute("login", isLogin);
//    		session.setAttribute("userid", user.getUserid());
//    		session.setAttribute("usernick", user.getNick());
//    		
//    		//resp.sendRedirect("/WEB-INF/views/donghyun/loginSuccess.jsp");
//    		req.getRequestDispatcher("/WEB-INF/views/donghyun/loginSuccess.jsp").forward(req, resp);
//    	}else {
//    		
//    		req.getRequestDispatcher("/WEB-INF/views/donghyun/loginFail.jsp").forward(req, resp);
//    	}
//    	
//    	
    }
}
