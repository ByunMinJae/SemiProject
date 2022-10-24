package minjae.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import minjae.dto.Product;
import util.Paging;

public interface GoodsService {
	
	/**
	 *  상품의 목록을 반환한다
	 * 
	 * @return - List<Product> - 상품 리스트
	 */
	public List<Product> getGoodsList();
	
	/**
	 * 게시글 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);
	
	/**
	 * 게시글 페이징 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Product> - 게시글 전체 조회 목록
	 */
	public List<Product> getGoodsList(Paging paging);
	
	/**
	 *  선택하여 넘어온 상품번호를 이용하여
	 * 해당 상품의 상세 정보를 조회한다
	 * 
	 * @param prodno - 상품번호
	 * @return 상품 상세 정보 
	 */
	public Product getProdDetail(int prodno);
	
	/**
	 * 카테고리 별 게시글 페이징 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @param cateVal - 카테고리 값
	 * @return List<Product> - 게시글 조회 목록
	 */
	public List<Product> getGoodsList(Paging paging, String cateVal);

}