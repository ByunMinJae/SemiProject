package jeonghwa.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jeonghwa.common.JDBCTemplate;

import jeonghwa.dao.face.ProductDao;

import jeonghwa.dao.impl.ProductDaoImpl;
import jeonghwa.dto.Product;
import jeonghwa.service.face.ProductService;
import util.Paging;

public class ProductServiceImpl implements ProductService{

	//DAO 객체
	private ProductDao productDao = new ProductDaoImpl();
	
	
	@Override
	public List<Product> getList() {
		//DB연결 객체 생성 - JDBCTemplate 이용
		Connection conn = JDBCTemplate.getConnection();		
		
		//Product테이블 전체 조회 - EmpDao 이용
		List<Product> list = productDao.selectAll(conn);
		
		return list;
	}
			
	
	
	@Override
	public List<Product> getList(Paging paging) {

		return productDao.selectAll(JDBCTemplate.getConnection(), paging);
	}
	
	
	
	@Override
	public Paging getPaging(HttpServletRequest req) {

		 //총 게시글 수 
		int totalCount = productDao.selectCntAll(JDBCTemplate.getConnection());
		
		//전달 파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if ( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
		
		//	-> 알아야 할 필수 변수인 totalCount, curPage 알아냄 
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}



	@Override
	public Product info(int prodno) {
		// TODO Auto-generated method stub
		return null;
	}


}
