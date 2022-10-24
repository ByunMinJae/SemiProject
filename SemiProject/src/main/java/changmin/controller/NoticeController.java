package changmin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import changmin.dto.Category;
import changmin.service.face.BoardService;
import changmin.service.impl.BoardServiceImpl;
import daun.dto.Board;
import sharon.dto.User;
import util.Paging;

@WebServlet("/board/notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardService boardService = new BoardServiceImpl();
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/board/notice [GET]");
	
		//----------------------게시글 전체 조회-------------------------------
		
		Category category = new Category();
		category.setCategoryno(1);
		
		//전달파라미터에서 현재 페이징 객체 계산하기
		Paging paging = boardService.getPaging(req, category);
		System.out.println("[TEST] " + paging);
		
		
		//게시글 페이징 목록 조회
		List<Board> boardList = boardService.getList( paging, category );

		//[TEST] 조회결과 확인
		for(Board b : boardList)	System.out.println(b);
		
		req.setAttribute("paging", paging);
		req.setAttribute("boardList", boardList);
		
		//----------------------게시글 전체 조회-------------------------------
			
		
	
		
		req.getRequestDispatcher("/WEB-INF/views/changmin/notice.jsp").forward(req, resp);
	}
	
}
