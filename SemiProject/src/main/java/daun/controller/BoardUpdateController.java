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

@WebServlet("/board/update")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		Board boardno = boardService.getBoardno(req);
		
		HttpSession session = req.getSession();
		
		//로그인 상태가 아닐 경우 로그인 페이지로 이동
		if( session.getAttribute("userno") == null ) {
			resp.sendRedirect("/cmc/login");
			
		} else {
			int userno = (int) session.getAttribute("userno");
			System.out.println("userno : " + userno);
			
			//로그인한 사람의 정보 조회
			User loginUser = boardService.getUserInfo(userno);
			System.out.println(loginUser);
			
			//로그인 한 사람 정보를 모델값으로 전달
			req.setAttribute("loginUser", loginUser);
			
		
			//상세보기 결과 조회
			Board updateBoard = boardService.view(boardno);
			System.out.println("boardno : " + boardno);
			
			//조회결과 MODEL값 전달
			req.setAttribute("updateBoard", updateBoard);
			System.out.println("updateBoard : " + updateBoard);
	
		
			
			//첨부파일 정보 조회
			BoardFile boardFile = boardService.viewFile(updateBoard);
			
			//첨부파일 정보를 MODEL값 전달
			req.setAttribute("boardFile", boardFile);
			
			//VIEW 지정 및 응답
			req.getRequestDispatcher("/WEB-INF/views/daun/boardupdate.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String boardtitle = req.getParameter("boardtitle");
		System.out.println("boardtitle : " + boardtitle);
		
		String boardcon = req.getParameter("boardcon");
		System.out.println("boardcon : " + boardcon);
		
		Board board = new Board();
		
		boardService.update(req, board, boardtitle, boardcon);
		
		resp.sendRedirect("/board/notice");
		
	}
	
	
}
