package donghyun.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donghyun.dto.Board;
import donghyun.dto.Report;
import donghyun.service.face.BoardService;
import donghyun.service.impl.BoardServiceImpl;
import util.Paging;

/**
 * Servlet implementation class ManagerBoardController
 */
@WebServlet("/manager/board")
public class ManagerBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.getRequestDispatcher("/WEB-INF/views/donghyun/managerBoard.jsp").forward(req, resp);


		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("/manager/board    [POST]");
		
		String category = req.getParameter("category");
		
		
		
		
		
		if("notice".equals(category)) {
			System.out.println("공지사항 검색");
			
			Paging paging = boardService.getNoticePaging(req);
			System.out.println("[TEST]" + paging);
			
			List<Board> noticeBoard =  boardService.getNoticeList(paging);
			
			req.setAttribute("paging", paging);
			
			for(Board b : noticeBoard) System.out.println(b);
			
			req.setAttribute("noticeBoard", noticeBoard);
			
			req.getRequestDispatcher("/WEB-INF/views/donghyun/noticeList.jsp").forward(req, resp);
		}
		
		if("free".equals(category)) {
			System.out.println("자유게시판 검색");
			
			Paging paging = boardService.getFreePaing(req);
			
			List<Board> freeBoard = boardService.getFreeList(paging);
			
			req.setAttribute("paging", paging);
			
			for(Board b : freeBoard) System.out.println(b);
			
			req.setAttribute("freeBoard", freeBoard);
			
			req.getRequestDispatcher("/WEB-INF/views/donghyun/freeList.jsp").forward(req, resp);

		}
		
		
		if("food".equals(category)) {
			System.out.println("맛집게시판 검색");
			
			Paging paging = boardService.getFoodPaging(req);
			
			List<Board> foodBoard = boardService.getFoodList(paging);
			
			req.setAttribute("paging", paging);
			
			for(Board b : foodBoard) System.out.println(b);
			
			req.setAttribute("foodBoard", foodBoard);
			
			req.getRequestDispatcher("/WEB-INF/views/donghyun/foodList.jsp").forward(req, resp);

		}
		
		if("meeting".equals(category)) {
			System.out.println("소모임게시판 검색");
			Paging paging = boardService.getMeetingPaging(req);
			
			List<Board> meetingBoard = boardService.getMeetingList(paging);
			
			req.setAttribute("paging", paging);
			
			for(Board b : meetingBoard) System.out.println(b);
			
			req.setAttribute("meetingBoard", meetingBoard);
			
			req.getRequestDispatcher("/WEB-INF/views/donghyun/meetingList.jsp").forward(req, resp);

		}
		
		
		if("qna".equals(category)) {
			System.out.println("질문게시판 검색");
			Paging paging = boardService.getQnaPaging(req);
			
			List<Board> qnaBoard = boardService.getQnaList(paging);
			
			req.setAttribute("paging", paging);
			
			for(Board b : qnaBoard) System.out.println(b);
			
			req.setAttribute("qnaBoard", qnaBoard);
			
			req.getRequestDispatcher("/WEB-INF/views/donghyun/qnaList.jsp").forward(req, resp);

		}
		
		if("report".equals(category)){
			System.out.println("신고글 검색");
			Paging paging = boardService.getReportPaging(req);
			
			List<Report> reportBoard = boardService.getReportList(paging);
			
			req.setAttribute("paging", paging);
			
			for(Report b : reportBoard) System.out.println(b);
			
			req.setAttribute("reportBoard", reportBoard);
			
			req.getRequestDispatcher("/WEB-INF/views/donghyun/reportList.jsp").forward(req, resp);
			
		}
	}
}
