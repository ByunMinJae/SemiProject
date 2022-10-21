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

@WebServlet("/board/question")
public class QuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardService boardService = new BoardServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/board/question [GET]");

		//----------------------게시글 전체 조회-------------------------------

		//전달파라미터에서 현재 페이징 객체 계산하기
		Paging paging = boardService.getPaging(req);
		System.out.println("[TEST] " + paging);

		req.setAttribute("paging", paging);


		//게시글 페이징 목록 조회
		List<Board> boardList = boardService.getList( paging );

		//[TEST] 조회결과 확인
		for(Board b : boardList)	System.out.println(b);

		req.setAttribute("boardList", boardList);

		//----------------------게시글 전체 조회-------------------------------
		
		
		req.getRequestDispatcher("/WEB-INF/views/changmin/question.jsp").forward(req, resp);
	
	}
}
