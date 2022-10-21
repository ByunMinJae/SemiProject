package changmin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import changmin.service.face.BoardService;
import changmin.service.impl.BoardServiceImpl;
import daun.dto.Board;
import util.Paging;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/board/list [GET]");
		
		Paging paging = boardService.getPaging(req);
		
		req.setAttribute("paging", paging);
		
		List<Board> list = boardService.getList(paging);
		for(Board b : list)
		System.out.println(b);
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/changmin/board.jsp").forward(req, resp);
	}
} 
