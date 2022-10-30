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
import minjae.dto.ProductFile;
import minjae.service.face.GoodsService;
import minjae.service.impl.GoodsServiceImpl;
import util.Paging;

@WebServlet("/goods/search")
public class GoodsSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GoodsService goodsService = new GoodsServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/goods/search [GET]");
		
		req.setCharacterEncoding("UTF-8");

		//검색한 값
		HttpSession session = req.getSession();
		String search = (String)session.getAttribute("search");
		System.out.println("[TEST] search : " + search);
		
		//현재 페이징 객체 계산하기
		Paging paging = goodsService.getPagingForSearch(req, search);
		System.out.println("[TEST] " + paging);
		
		//페이징 객체를 MDOEL값 전달
		req.setAttribute("paging", paging);
		
		
		System.out.println("검색어 세팅 정렬");
		
		List<Product> goodsList = goodsService.getSearchList(paging, search);
		req.setAttribute("goodsList", goodsList);

		List<ProductFile> prodFileList = goodsService.viewSearchFile(goodsList, paging, search);
		req.setAttribute("prodFileList", prodFileList);
		
		req.getRequestDispatcher("/WEB-INF/views/minjae/goods/goodsList.jsp").forward(req, resp);
	}
	
}
