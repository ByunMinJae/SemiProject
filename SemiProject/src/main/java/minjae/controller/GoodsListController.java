package minjae.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import minjae.dto.Product;
import minjae.service.face.GoodsService;
import minjae.service.impl.GoodsServiceImpl;
import util.Paging;

@WebServlet("/goods/list")
public class GoodsListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GoodsService goodsService = new GoodsServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/goods/list [GET]");
		
		req.setCharacterEncoding("UTF-8");

		//선택한 카테고리값
		HttpSession session = req.getSession();
		String cateVal = (String)session.getAttribute("cateVal");
		String search = (String)session.getAttribute("search");
		System.out.println("[TEST] cateVal : " + cateVal);
		System.out.println("[TEST] search : " + search);
		
		if(cateVal == null) {
			session.setAttribute("cateVal", "prodno");
		}
		
		if(null != search && !"null".equals(search)) { //!"null".equals(search)
			System.out.println("검색어 발견 /goods/search 로 이동");
			req.getRequestDispatcher("/goods/search").forward(req, resp);
			return;
		}
		
		//현재 페이징 객체 계산하기
		Paging paging = goodsService.getPaging(req);
		System.out.println("[TEST] paging : " + paging);
		
		//페이징 객체를 MDOEL값 전달
		req.setAttribute("paging", paging);
		
			
		if("".equals(cateVal) || null == cateVal) {
			System.out.println("기본 세팅 정렬");
			
			//상품 페이징 목록 조회
			List<Product> goodsList = goodsService.getGoodsList(paging);
			
			req.setAttribute("goodsList", goodsList);
			req.getRequestDispatcher("/WEB-INF/views/minjae/goods/goodsList.jsp").forward(req, resp);
		} else {
			System.out.println("카테고리 세팅 정렬");
			
			List<Product> goodsList = goodsService.getGoodsList(paging, cateVal);
			
			req.setAttribute("goodsList", goodsList);
			req.getRequestDispatcher("/WEB-INF/views/minjae/goods/goodsList.jsp").forward(req, resp);
		}
			
			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/goods/list [POST]");
//		
//		//선택한 카테고리값
//		String cateVal = req.getParameter("value");
//		System.out.println(cateVal);
//		//현재 페이징 객체 계산하기
//		Paging paging = goodsService.getPaging(req);
////		System.out.println("[TEST] " + paging);
//		
//		//페이징 객체를 MDOEL값 전달
//		req.setAttribute("paging", paging);
//		
//		List<Product> goodsList = goodsService.getGoodsList(paging, cateVal);
//		
////		req.setAttribute("goodsCateList", goodsCateList);
////		req.getRequestDispatcher("/WEB-INF/views/minjae/goods/goodsCateList.jsp").forward(req, resp);
//		
//		req.setAttribute("goodsList", goodsList);
//		req.getRequestDispatcher("/WEB-INF/views/minjae/goods/goodsList.jsp").forward(req, resp);
		
	}
	
}
