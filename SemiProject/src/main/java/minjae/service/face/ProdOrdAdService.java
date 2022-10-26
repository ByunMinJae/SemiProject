package minjae.service.face;

import java.util.List;

import minjae.dto.ProdOrdAd;

public interface ProdOrdAdService {
	
	/**
	 * 상품 주문 정보를 조회하여 DTO에 담아 반환한다
	 * 
	 * @return ProdOrdAd DTO 
	 */
	public List<ProdOrdAd> getProdOrdInfo();

}
