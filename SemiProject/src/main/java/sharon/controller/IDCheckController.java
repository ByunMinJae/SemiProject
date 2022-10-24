package sharon.controller;

import java.io.IOException;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sharon.dao.impl.JoinDaoImpl;
import sharon.dto.User;

@WebServlet("/user/idCheck")
public class IDCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/user/idCheck [GET]");
//		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost():["+req.getParameter("")+"]");
		
		JoinDaoImpl dao= new JoinDaoImpl();
		User user = new User();
		
		user.setUserid(req.getParameter("userid"));
		
		int result = dao.checkId(user);
		
		String json = "{\"result\":" +result+"}";
		System.out.println(json);
		
		resp.setContentType("application/x-json; charset=utf-8");
		
		resp.getWriter().write(json);
	}
	
//-----------------------------------------------	
//	private JoinService joinService =new JoinServiceImpl();
//
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp, Connection Connection) throws ServletException, IOException {
//		System.out.println("/user/idCheck [POST]");
//		
//		int res= joinService.checkId(req);
//		System.out.println("결과:"+res);
//		
//		req.setAttribute("res", res);
//		req.getRequestDispatcher("/WEB-INF/views/sharon/user/idCheck2.jsp").forward(req, resp);

}
