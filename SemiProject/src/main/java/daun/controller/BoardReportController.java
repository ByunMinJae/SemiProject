package daun.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.JDBCTemplate;
import daun.dto.Board;
import daun.dto.Report;
import daun.service.face.BoardService;
import daun.service.impl.BoardServiceImpl;
import sharon.dto.User;
import sharon.service.face.ListService;
import sharon.service.impl.ListServiceImpl;


@WebServlet("/board/report")
public class BoardReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BoardService boardService = new BoardServiceImpl();
	private ListService listService = new ListServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
			
			
			Board boardno = boardService.getBoardno(req);
			System.out.println("boardno : " + boardno);
			
			//상세보기 결과 조회
			Board infoboard = boardService.infoboard(boardno);
			
			//조회결과 MODEL값 전달
			req.setAttribute("infoboard", infoboard);
			System.out.println("infoboard : " + infoboard);
			
			req.getRequestDispatcher("/WEB-INF/views/daun/boardreport.jsp").forward(req, resp);
		
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setCharacterEncoding("UTF-8");
		boardService.report(req);
		
		resp.sendRedirect("/board/notice");

	}
}
