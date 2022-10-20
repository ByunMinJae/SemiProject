package daun.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daun.dto.Board;

@WebServlet("/board/update")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/daun/boardupdate.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달 파라미터 한글 인코딩 처리
		req.setCharacterEncoding("UTF-8");

		Board b = new Board();

		b.setBoardtitle(req.getParameter("boardtitle"));

		b.setBoardcon(req.getParameter("boardcon"));

//		b.setUserno(req.getParameter("userno"));
//		
//
//		if ( boardService.insertBoard(b) > 0) {
//
//			resp.sendRedirect("/board/boardList");
//	
//			} else {
//	
//			
//			req.setAttribute("message", "게시글 등록 실패!");
//	
//			req.getRequestDispatcher("/WEB-INF/views/daun/boardError.jsp").forward(req, resp);
//	
//			}
		
		
	}
	
	
}
