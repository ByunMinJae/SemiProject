package donghyun.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import donghyun.dto.Board;
import donghyun.dto.Report;
import donghyun.dto.UserInfo;
import donghyun.service.face.BoardService;
import donghyun.service.face.PunishService;
import donghyun.service.impl.BoardServiceImpl;
import donghyun.service.impl.PunishServiceImpl;

/**
 * Servlet implementation class PunishController
 */
@WebServlet("/cmc/punish")
public class PunishController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PunishService punishService = new PunishServiceImpl();
    BoardService boardService = new BoardServiceImpl();
    Report report = new Report();
    	@Override
    	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		
    	System.out.println("/cmc/punish [GET]");
    	
    	Report report = boardService.getUserno(req);
    	
    	int userno = report.getUserno();
    	
    	System.out.println(userno);
    	
    	punishService.getPunish(userno);
    	
    	resp.sendRedirect("/manager/board");
    	
    	}

}
