package changmin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

		//세션 유저정보를 userno로 조회
		HttpSession session = req.getSession();

		//게시판 유저정보를 userno로 조회
		int userno = (Integer.parseInt(req.getParameter("userno")));

		System.out.println("세션 유저넘버 : " + (int)session.getAttribute("userno"));
		System.out.println("보드 유저넘버 : " + userno);
		
		//세션 userno가 게시판 userno와 일치할때 삭제 가능
		if( (int)session.getAttribute("userno")!=userno ) {
			
			System.out.println("Session userno != Board userno");
			
		} else {
			
			//------------------------게시글 삭제----------------------------------
			
			Board board = boardService.getBoardno(req);
			
			boardService.deleteboard(board);
			
			//------------------------게시글 삭제----------------------------------
			
			resp.sendRedirect("/board/notice");

		} 
	}
}
