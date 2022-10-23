package changmin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import changmin.service.face.BoardService;
import changmin.service.impl.BoardServiceImpl;
import daun.dto.Board;

@WebServlet("/board/deleteboard")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/board/delete [POST]");

		//------------------------게시글 삭제----------------------------------
		
		Board board = boardService.getBoardno(req);
		
		boardService.deleteboard(board);
				
		//------------------------게시글 삭제----------------------------------
				
		resp.sendRedirect("/board/notice");
	}
}
