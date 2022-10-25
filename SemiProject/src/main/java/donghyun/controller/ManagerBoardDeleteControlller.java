package donghyun.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donghyun.dto.Board;
import donghyun.service.face.BoardService;
import donghyun.service.impl.BoardServiceImpl;

/**
 * Servlet implementation class ManagerBoardDeleteControlller
 */
@WebServlet("/manager/boarddelete")
public class ManagerBoardDeleteControlller extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	BoardService boardService = new BoardServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	System.out.println("[/manager/boarddelete GET");
    
    	
    	Board boardno = boardService.getboardno(req);
    	
    	
    	
    	System.out.println("boardno : " + boardno);
    	
    	boardService.delete(boardno);
    	
    	resp.sendRedirect("/manager/board");
    	
    	
    }

}
