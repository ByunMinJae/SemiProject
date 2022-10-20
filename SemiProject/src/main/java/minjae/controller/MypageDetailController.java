package minjae.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import minjae.dto.BoardInfoCate;
import minjae.dto.MpMain;
import minjae.service.face.MypageService;
import minjae.service.impl.MypageServiceImpl;

@WebServlet("/mypage/detail")
public class MypageDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MypageService mypageService = new MypageServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/mypage/detail [GET]");
		
		HttpSession session = req.getSession();
		int userno = (int)session.getAttribute("userno");
		
		MpMain mpMain = mypageService.getUserInfo(userno);
		BoardInfoCate boardInfoCate = mypageService.getBoardInfoCate(userno); 
		
		req.setAttribute("mpMain", mpMain);
		req.setAttribute("boardInfoCate", boardInfoCate);
		req.getRequestDispatcher("/WEB-INF/views/minjae/mypage/mpDetail.jsp").forward(req, resp);
	}
	
}
