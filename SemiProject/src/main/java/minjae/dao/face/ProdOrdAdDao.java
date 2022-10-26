package minjae.dao.face;

import java.sql.Connection;
import java.util.List;

import minjae.dto.ProdOrdAd;

public interface ProdOrdAdDao {
	
	/**
	 *  user_orderafter 테이블에서 정보를 조회하여 
	 * ProdOrdAd DTO에 담아 반환한다
	 * 
	 * @param conn - DB 연결 객체
	 * @return ProdOrdAd DTO
	 */
	public List<ProdOrdAd> selectProdOrdInfo(Connection conn);

}
