package daun.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daun.dto.Board;
import daun.dto.BoardFile;
import daun.service.face.BoardService;
import daun.service.impl.BoardServiceImpl;
import sharon.dto.User;


@WebServlet("/board/report")
public class BoardReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		int userno = (int) session.getAttribute("userno");
		
		User loginUser = boardService.getUserInfo(userno);
		req.setAttribute("loginUser", loginUser);	
		
		Board boardno = boardService.getBoardno(req);
		
		Board viewBoard = boardService.viewBeforeReport(boardno);
		
		req.setAttribute("viewBoard", viewBoard);
		
//		//상세보기 결과 조회
//		Board updateBoard = boardService.view(boardno);
//		
//		//조회결과 MODEL값 전달
//		req.setAttribute("updateBoard", updateBoard);
//
//		//작성자 닉네임 전달
//		req.setAttribute("writerNick", boardService.getWriteNick(updateBoard));
//		
//		//첨부파일 정보 조회
//		BoardFile boardFile = boardService.viewFile(updateBoard);
//		
//		//첨부파일 정보를 MODEL값 전달
//		req.setAttribute("boardFile", boardFile);

		
		req.getRequestDispatcher("/WEB-INF/views/daun/boardreport.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		boardService.report(req);
		resp.sendRedirect("/board/view");

	}
}
