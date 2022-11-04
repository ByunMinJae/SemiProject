package jeonghwa.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jeonghwa.dto.Product;
import jeonghwa.dto.ProductFile;
import jeonghwa.service.face.ProductService;
import jeonghwa.service.impl.ProductServiceImpl;

@WebServlet("/prod/update")
public class ProdUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	//서비스 객체
	private ProductService productService = new ProductServiceImpl();

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달파라미터 저장 객체 얻기
		Product prodno = productService.getProdno(req);
		System.out.println("ProdUpdateController doGet() - 전달파라미터 객체 : " + prodno);
		
		
		//상세보기 결과 조회
		Product updateProduct = productService.view(prodno);
		System.out.println("ProdUpdateController doGet() - 상세보기 객체 : " + updateProduct);
		

		//조회결과 MODEL값 전달
		req.setAttribute("updateProduct", updateProduct);
		
		
		//작성자 닉네임 전달
		//req.setAttribute("writerNick", productService.getWriteNick(updateProduct));
		
		
		//첨부파일 정보 조회
		ProductFile productFile = productService.viewFile(updateProduct);
		
		//첨부파일 정보를 MODEL값 전달
		req.setAttribute("productFile", productFile);
		
		
		//VIEW 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/jeonghwa/produpdate.jsp").forward(req, resp);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		productService.update(req);
		
		resp.sendRedirect("/prod/list");
	}
	
	
	

}


















