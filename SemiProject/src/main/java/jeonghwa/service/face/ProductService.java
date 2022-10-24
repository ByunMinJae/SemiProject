package jeonghwa.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jeonghwa.dto.Product;
import util.Paging;

public interface ProductService {

	/**
	 * 상품 전체 조회
	 * 
	 * @return List<Product> - 상품 전체 조회 목록
	 */
	public List<Product> getList();

	/**
	 * 게시글 페이징 목록 조회
	 * 
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Board> - 게시글 전체 조회 목록
	 */
	public List<Product> getList(Paging paging);
	

	/**
	 * 게시글 페에징 객체 생성
	 * 
	 * @param req - 요청 저보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);

	
	
	public Product info(int prodno);

	





	

}