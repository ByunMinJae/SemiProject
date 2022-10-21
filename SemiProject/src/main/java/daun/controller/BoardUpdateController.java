package daun.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daun.dto.Board;
import daun.service.face.BoardService;
import daun.service.impl.BoardServiceImpl;

@WebServlet("/board/update")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달 파라미터 한글 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		
		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPw");
		String userName = req.getParameter("userName");
		String arr[] = req.getParameterValues("hobby");

		String hobby = "";

		if (arr != null) {

		hobby = String.join(",", arr);

		}
		
		req.getRequestDispatcher("/WEB-INF/views/daun/boardupdate.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달 파라미터 한글 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		
		BoardService boardService = new BoardServiceImpl();

		String id = req.getParameter("id");

		Board board = new Board();

//		if(board != null && board.getUserId().equals(id)) { // 만약 ID 값이 기존값과 일치한다면 수정 실행
//			
//			board.setBoardtitle(req.getParameter("boardTitle"));
//			board.setBoardcon(req.getParameter("boardCon"));
//			board.setUserno(req.getParameter("userno"));
//
//			if(boardService.updateBoard(board) > 0) {
//				session.setAttribute("member", member);
//				resp.sendRedirect(reqt.getContextPath()+"/index.jsp");
//			} else {
//				out.append("<script>alert('회원 정보 수정 오류!\\n 관리자에게 문의하세요!');</script>");
//			}
//		} else {
//			req.setAttribute("message", "회원 정보 수정 오류 발생!!");
//			req.getRequestDispatcher("/WEB-INF/views/daun/boardError.jsp").forward(req, resp);
//		}
//	
		
	}
	
	
}
