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

@WebServlet("/prod/view")
public class ProdViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	//Service 객체
	private ProductService productService = new ProductServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/prod/view [GET]");
		
		System.out.println("ProdViewController doGet() - prodno : " + req.getParameter("prodno"));
		
		//전달파라미터 객체 얻어오기
		Product prodno = productService.getProdno(req);
		System.out.println("ProdViewController doGet() - prodno객체 : " + prodno);		
		
		
		//게시글 상세보기 조회 결과 얻어오기
		Product viewProduct = productService.view( prodno );
		System.out.println("ProdViewController doGet() - viewProduct : " + viewProduct);		
		
		
		//조회결과를 MODEL값으로 전달
		req.setAttribute("viewProduct", viewProduct);
		
	
		
		
		//첨부파일 정보 조회
		ProductFile productFile = productService.viewFile(viewProduct);
		
		
		//첨부파일 정보를 MODEL값 전달
		req.setAttribute("productFile", productFile);
		
		
		//View 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/jeonghwa/prodview.jsp").forward(req, resp);
		
	}

	

}
