package jeonghwa.service.impl;

import java.sql.Connection;
import java.util.List;

import jeonghwa.common.JDBCTemplate;
import jeonghwa.dao.face.ProdListDao;
import jeonghwa.dao.impl.ProdListDaoImpl;
import jeonghwa.dto.Product;
import jeonghwa.service.face.ProdListService;

public class ProdListServiceImpl implements ProdListService{

	//DAO 객체
	private ProdListDao prodlistDao = new ProdListDaoImpl();
	
	
	@Override
	public List<Product> getList() {
		//DB연결 객체 생성 - JDBCTemplate 이용
		Connection conn = JDBCTemplate.getConnection();		
		
		//Product테이블 전체 조회 - EmpDao 이용
		List<Product> list = prodlistDao.selectAll(conn);
		
		return list;
	}




	@Override
	public Product info(int prodno) {
		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		return prodlistDao.selectByProdno(conn, prodno);
	}


	

	


	
	
	
	
	

}
