package sharon.controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sharon.dto.User;
import sharon.service.face.JoinService;
import sharon.service.impl.JoinServiceImpl;

@WebServlet("/user/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private JoinService joinService = new JoinServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/user/join [GET]");
		
		req.getRequestDispatcher("/WEB-INF/views/sharon/user/joinForm.jsp").forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/user/join [POST]");
		
		req.setCharacterEncoding("UTF-8");
		
		User user = joinService.getParam(req);
		
		joinService.join(user);
		
		resp.sendRedirect("/main");
	}

}
