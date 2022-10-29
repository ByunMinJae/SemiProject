package minjae.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import minjae.dto.Product;
import minjae.dto.ProductFile;
import minjae.service.face.GoodsService;
import minjae.service.impl.GoodsServiceImpl;

@WebServlet("/goods/detail")
public class GoodsDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GoodsService goodsService = new GoodsServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/goods/detail [GET]");
		
		int prodno = Integer.parseInt(req.getParameter("prodno"));
		
		Product pordDetail = goodsService.getProdDetail(prodno);
		
		req.setAttribute("pordDetail", pordDetail);
		
		//첨부파일 정보 조회
		ProductFile prodFile = goodsService.viewFile(pordDetail);
		
		//첨부파일 정보를 MODEL값 전달
		req.setAttribute("prodFile", prodFile);
		req.getRequestDispatcher("/WEB-INF/views/minjae/goods/goodsListDetail.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	}
	
}
