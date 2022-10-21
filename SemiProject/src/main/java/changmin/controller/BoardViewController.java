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


@WebServlet("/board/view")
public class BoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/board/view [GET]");
		
		//----------------------게시글 상세 조회-------------------------------
		
		//전달파라미터 객체 얻어오기
		Board boardno = boardService.getBoardno(req);
		System.out.println("BoardViewController doGet() - boardno 객체 : " + boardno );
		
		//게시글 상세보기 조회 결과 얻어오기
		Board viewBoard = boardService.view(boardno);
		System.out.println("BoardViewControoler doGet() - viewBoard : " + viewBoard );

		req.setAttribute("viewBoard", viewBoard);
		
		//----------------------게시글 상세 조회-------------------------------
		
		req.getRequestDispatcher("/WEB-INF/views/changmin/viewboard.jsp").forward(req, resp);
	}
}
