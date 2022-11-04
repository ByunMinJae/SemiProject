package sharon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sharon.dto.User;
import sharon.service.face.ListService;
import sharon.service.impl.ListServiceImpl;

@WebServlet("/user/list")
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ListService listService = new ListServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("/user/list [GET]");
	
	System.out.println("findType : " + req.getParameter("findType"));
	System.out.println("findKeyword : " + req.getParameter("findKeyword"));
	
	String findType = req.getParameter("findType");
	String findKeyword = req.getParameter("findKeyword");
	
	
	List<User> list = listService.list(findType, findKeyword);
	
	
	System.out.println("[TEST} UserListController-전체조회목록");
	
	req.setAttribute("userList", list);
	
	req.getRequestDispatcher("/WEB-INF/views/sharon/user/list.jsp").forward(req, resp);
	
	}

}
