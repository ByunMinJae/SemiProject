package minjae.dao.face;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import minjae.dto.ProdOrdAd;
import util.Paging;

public interface ProdOrdAdDao {
	
	/**
	 *  user_orderafter 테이블에서 정보를 조회하여 
	 * ProdOrdAd DTO에 담아 반환한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param paging - 페이징 정보 객체
	 * @return ProdOrdAd DTO
	 */
	public List<ProdOrdAd> selectProdOrdInfo(Connection conn, Paging paging);
	
	/**
	 *  카테고리별 정렬된 정보를 리스트에 담아 반환한다
	 *  
	 * @param conn - DB 연결 객체
	 * @param paging - 페이징 정보 객체
	 * @param cate - 카테고리명
	 * @return ProdOrdAd DTO
	 */
	public List<ProdOrdAd> selectProdOrdCate(Connection conn, Paging paging, String cate);

	/**
	 * 총 게시글 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectCntAll(Connection conn);
	
	/**
	 *  요청 받은 select 정보를 이용하여
	 * orderprocess의 데이터를 수정한다.
	 * 
	 * @param conn - DB 연결 객체
	 * @param req - 요청 파라미터
	 * @return UPDATE 쿼리문 수행 결과 (1 - 성공, 0 - 실패)
	 */
	public int updateOrdProc(Connection conn, HttpServletRequest req);

	
	
}
