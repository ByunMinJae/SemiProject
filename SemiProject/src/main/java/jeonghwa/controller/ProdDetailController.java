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

@WebServlet("/prod/detail")
public class ProdDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	//Service 객체
	private ProductService productService = new ProductServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get성공");
		
		
		//요청 정보에서 전달파라미터 prodno 추출 - HttpServletRequest 이용
		String param = req.getParameter("prodno");
		System.out.println("ProdDetailController - param : " + param);

		
		int prodno = 0;	//파라미터를 저장할 변수
		if ( param != null && !"".equals(param)) {
			prodno = Integer.parseInt(param);
		}
		
		System.out.println("ProdDetailController - prodno : " + prodno);
		
		
		//상품 정보 조회하기 - ProductService 이용
		Product product = productService.info(prodno);
		System.out.println("ProdDetailController - product조회 : " + prodno);
		
		
		//조회된 결과를 View에 전달 - HttpServletRequest 이용
		req.setAttribute("product", product);
		
		
		//View 지정하기 - RequestDispatcher 이용
		//지정한 View를 응답으로 사용하기 - .forward() 호출
		req.getRequestDispatcher("/WEB-INF/views/jeonghwa/prodDetail.jsp").forward(req, resp);
		
	}

	

}
