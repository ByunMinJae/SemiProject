package daun.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import changmin.dto.OrderBefore;
import daun.dto.Board;
import daun.service.face.BoardService;
import daun.service.impl.BoardServiceImpl;
import sharon.dto.User;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
	
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
			
			System.out.println("/board/write doGet");
			req.getRequestDispatcher("/WEB-INF/views/daun/boardwrite.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//작성글 삽입
		boardService.write(req);
		
		//목록으로 리다이렉트
		resp.sendRedirect("/board/notice");
		
	}
}
