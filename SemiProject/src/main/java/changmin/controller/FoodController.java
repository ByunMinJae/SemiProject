package changmin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import changmin.dto.Board;
import changmin.dto.Category;
import changmin.service.face.BoardService;
import changmin.service.impl.BoardServiceImpl;
import util.Paging;

@WebServlet("/board/food")
public class FoodController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/board/food [GET]");

		//----------------------게시글 전체 조회-------------------------------

		Category category = new Category();
		category.setCategoryno(3);
		
		//전달파라미터에서 현재 페이징 객체 계산하기
		
		String word = req.getParameter("word");
		String searchList = req.getParameter("list");
		
		if ( word==null || word.equals("")) {
			System.out.println("디폴트페이지");
			
			Paging paging = boardService.getPaging(req, category);
			List<Board> boardList = boardService.getList( paging, category );
			
			req.setAttribute("boardList", boardList);
			req.setAttribute("paging", paging);
			
		} else {
			System.out.println("검색페이지");
			
			Paging paging = boardService.getPaging(req, category, word, searchList);
			List<Board> boardList = boardService.getList( paging, category, word, searchList ); 
			
			req.setAttribute("boardList", boardList);
			req.setAttribute("paging", paging);
			req.setAttribute("word", word);
			req.setAttribute("list", searchList);
		}

		//----------------------게시글 전체 조회-------------------------------

		req.getRequestDispatcher("/WEB-INF/views/changmin/food.jsp").forward(req, resp);

	}
}
