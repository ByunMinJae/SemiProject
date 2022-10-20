package jeonghwa.service.face;

import java.util.List;

import jeonghwa.dto.Product;

public interface ProdListService {

	/**
	 * 상품 전체 조회
	 * 
	 * @return List<Product> - 상품 전체 조회 목록
	 */
	public List<Product> getList();


	/**
	 * 상품 정보를 조회한다
	 * 
	 * @param prodno 조회할 상품번호
	 * @return 조회된 상품의 정보, 모든 컬럼 조회
	 * 		조회되는 상품이 없을 경우 null
	 */
	public Product info(int prodno);


	

}
