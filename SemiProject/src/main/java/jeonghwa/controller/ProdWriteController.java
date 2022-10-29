package jeonghwa.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jeonghwa.service.face.ProductService;
import jeonghwa.service.impl.ProductServiceImpl;

@WebServlet("/prod/write")
public class ProdWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	//서비스 객체
	private ProductService productService = new ProductServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/jeonghwa/prodwrite.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//작성글 삽입
		productService.write(req);
		
		
		//목록으로 리다이렉트
		resp.sendRedirect("/prod/list");
	}
	

}
