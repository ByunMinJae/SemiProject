package changmin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import changmin.service.face.BoardService;
import changmin.service.impl.BoardServiceImpl;

@WebServlet("/board/detaillist")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardSerivce = new BoardServiceImpl(); 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/board/detaillist [GET]");
		
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/changmin/board.jsp").forward(req, resp);
	}
} 
