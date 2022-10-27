package donghyun.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donghyun.dto.Board;
import donghyun.dto.BoardFile;
import donghyun.service.face.BoardService;
import donghyun.service.impl.BoardServiceImpl;

/**
 * Servlet implementation class ManagerBoardViewController
 */
@WebServlet("/manager/boardview")
public class ManagerBoardViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private BoardService boardService = new BoardServiceImpl();
    
    @Override
    	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	System.out.println("/manager/boardview   [GET]");
   
    	
    	Board boardno = boardService.getboardno(req);
    
    	
    	Board viewBoard = boardService.view(boardno);
    	
    	req.setAttribute("viewBoard", viewBoard);
    	
    	BoardFile boardFile = boardService.viewFile(viewBoard);
    	
    	req.setAttribute("boardFile", boardFile);
    	
    	req.getRequestDispatcher("/WEB-INF/views/donghyun/view.jsp").forward(req, resp);
    	}

}
