package jeonghwa.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jeonghwa.dto.Product;
import jeonghwa.service.face.ProductService;
import jeonghwa.service.impl.ProductServiceImpl;

@WebServlet("/prod/delete")
public class ProdDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//Service객체
	private ProductService productService = new ProductServiceImpl();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Product product = productService.getProdno(req);
		
		productService.delete(product);
		
		resp.sendRedirect("/prod/list");
		
		
	}
	
	
	
	
	
}
