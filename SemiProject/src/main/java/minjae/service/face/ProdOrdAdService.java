package minjae.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import minjae.dto.ProdOrdAd;
import util.Paging;

public interface ProdOrdAdService {
	
	/**
	 * 상품 주문 정보를 조회하여 DTO에 담아 반환한다
	 * 
	 * @param paging - 페이징 정보 객체 
	 * @return List<ProdOrdAd>  - 주문 정보 조회 목록
	 */
	public List<ProdOrdAd> getProdOrdInfo(Paging paging);
	
	/**
	 * 카테고리별 상품 주문 정보를 조회하여 DTO에 담아 반환한다
	 * 
	 * @param paging - 페이징 정보 객체 
	 * @param cate - 정렬할 카테고리명
	 * @return List<ProdOrdAd>  - 카테고리별 주문 정보 조회 목록
	 */
	public List<ProdOrdAd> getProdOrdCate(Paging paging, String cate);

	/**
	 * 게시글 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);
	
	/**
	 *  요청 받은 정보를 이용해 주문상태를 변경하고
	 * 결과를 boolean으로 반환한다
	 * 
	 * @param req - 요청 파라미터
	 * @return - boolean (true - 성공, false - 실패)
	 */
	public boolean changeOrdProcess(HttpServletRequest req);
	
	
	
}
