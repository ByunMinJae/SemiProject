package minjae.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import minjae.dto.Product;
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
		
		req.getRequestDispatcher("/WEB-INF/views/minjae/goods/goodsListDetail.jsp").forward(req, resp);
		
	}
	
}
