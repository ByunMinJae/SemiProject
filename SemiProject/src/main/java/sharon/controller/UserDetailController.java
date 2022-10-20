package sharon.controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sharon.dto.User;
import sharon.service.face.ListService;
import sharon.service.impl.ListServiceImpl;

@WebServlet("/user/detail")
public class UserDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ListService listService = new ListServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/user/detail [GET]");
		
		String param = req.getParameter("userno");
		System.out.println("UserDetailController - param : " + param);

		int userno = 0; 
		if( param!=null && !"".equals(param) ) {
			userno = Integer.parseInt(param);
		}
		System.out.println("UserDetailController - userno : " + userno);
		
		
		//조회
		User user = ListService.info(userno);
		System.out.println("UserDetailController - user조회 : " + user);
		
		req.setAttribute("user", user);
		
		req.getRequestDispatcher("/WEB-INF/views/sharon/user/detail.jsp").forward(req, resp);
	}
}
