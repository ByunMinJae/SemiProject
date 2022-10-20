package jeonghwa.dao.face;

import java.sql.Connection;
import java.util.List;

import jeonghwa.dto.Product;

public interface ProdListDao {

	
	/**
	 * Product 테이블 전체 조회
	 * 
	 * @param conn - DB연결 객체
	 * @return 조회된 전체 상품 목록 
	 */
	public List<Product> selectAll(Connection conn);

	
	
	/**
	 * 전달된 empno를 이용하여 상품 정보를 조회한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param prodno - 조회할 상품번호
	 * @return 조회된 상품의 정보를 Product객체로 반환, 존재하지 않으면 null 반환
	 */
	public Product selectByProdno(Connection conn, int prodno);

	




	

}
