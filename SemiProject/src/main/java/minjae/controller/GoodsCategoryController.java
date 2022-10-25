package minjae.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/goods/cate")
public class GoodsCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/goods/cate [GET]");
		
		req.setCharacterEncoding("UTF-8");
		
		System.out.println(req.getParameter("search"));
		System.out.println(req.getParameter("value"));
		
		if("null".equals(req.getParameter("search")) || req.getParameter("search") == null ) {
			System.out.println("/goods/cate 카테고리로 들어옴");
			//세션에 카테고리 값 저장
			HttpSession session = req.getSession();
			session.setAttribute("cateVal", req.getParameter("value"));
			
			//session 검색어 지우기
			session.setAttribute("search", "null");
			
			//리스트 출력 컨트롤러로 이동
			req.getRequestDispatcher("/goods/list").forward(req, resp);
		}else if("".equals(req.getParameter("value")) || req.getParameter("value") == null) {
			System.out.println("/goods/cate 검색으로 들어옴");
			//세션에 검색 값 저장
			HttpSession session = req.getSession();
			session.setAttribute("search", "%" + req.getParameter("search") + "%");
			
			//검색 리스트 출력 컨트롤러로 이동
			req.getRequestDispatcher("/goods/search").forward(req, resp);
		} 
		
	}
	
}
