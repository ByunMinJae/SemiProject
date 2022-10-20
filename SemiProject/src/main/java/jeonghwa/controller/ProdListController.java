package jeonghwa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jeonghwa.dto.Product;
import jeonghwa.service.face.ProdListService;
import jeonghwa.service.impl.ProdListServiceImpl;

@WebServlet("/prod/list")
public class ProdListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Service객체
	private ProdListService prodlistService = new ProdListServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			System.out.println("get 성공");

			
			
			//Product테이블의 전체 목록을 조회하기 - ProdManageService 이용
			List<Product> list = prodlistService.getList();
			
			
			
			System.out.println("- - - - - 전체 조회 목록 - - - - -");
			for(Product p : list)
			System.out.println( p );
			
			
			//조회결과를 전달
			req.setAttribute("productList", list);
			
			
			//JSP를 View로 지정하고, View를 이용한 응답	- RequestDispatcher 이용
			req.getRequestDispatcher("/WEB-INF/views/jeonghwa/prodlist.jsp").forward(req, resp);

	}


}
