package daun.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daun.dto.Board;
import daun.service.face.BoardService;
import daun.service.impl.BoardServiceImpl;
import daun.util.Paging;



@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		System.out.println("/board/list [GET]");
		
		//전달파라미터에서 현재 페이징 객체 계산하기
		Paging paging = boardService.getPaging(req);
		System.out.println("[TEST] " + paging);
		
		//페이징 객체를 MODEL값 전달
		req.setAttribute("paging", paging);

		//페이징 전체 조회
		List<Board> boardList = boardService.getList( paging );
		
		
		//[TEST] 조회결과 반환
		for(Board b : boardList )	System.out.println(b);
		
		//조회결과를 MODEL값 전달
		req.setAttribute("boardList", boardList );
	
		//View 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/daun/boardlist.jsp").forward(req, resp);
		
		
	}
	

}
