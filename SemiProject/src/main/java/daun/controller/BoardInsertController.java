package daun.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daun.dto.Board;
import daun.service.face.BoardService;
import daun.service.impl.BoardServiceImpl;

@WebServlet("/board/insert")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		
		req.getRequestDispatcher("/WEB-INF/views/daun/boardInsert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//전달 파라미터 한글 인코딩 처리
		req.setCharacterEncoding("UTF-8");

		Board board = new Board();

		board.setBoardtitle(req.getParameter("boardTitle"));
		board.setBoardcon(req.getParameter("boardCon"));
//		board.setUserno(req.getParameter("userno"));
		

		if ( boardService.insertBoard(board) > 0) {

			resp.sendRedirect("/board/detaillis");

			} else {

			req.setAttribute("message", "게시글 등록 실패!");
			req.getRequestDispatcher("/WEB-INF/views/daun/boardError.jsp").forward(req, resp);

			}
				
				
			
	}

}
