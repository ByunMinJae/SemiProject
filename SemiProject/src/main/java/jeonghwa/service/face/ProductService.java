package jeonghwa.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jeonghwa.dto.Product;
import jeonghwa.dto.ProductFile;
import util.Paging;

public interface ProductService {

	
	/**
	 * 상품 전체 조회
	 * 
	 * @return List<Product> - 상품 전체 조회 목록
	 */
	public List<Product> getList();

	/**
	 * 페이징 목록 조회
	 * 
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Product> - 상품 전체 조회 목록
	 */
	public List<Product> getList(Paging paging);
	
	/**
	 * 페에징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);

	
	//-------------------------------------------------------

	
	/**
	 * 전달파라미터 boardno를 Board DTO로 저장하여 반환한다
	 * 
	 * @param req - 요청 정보 객체
	 * @return Board - 전달파라미터 boardno를 저장한 DTO객체
	 */
	public Product getProdno(HttpServletRequest req);

	/**
	 * 전달된 boardno를 이용하여 게시글을 조회한다
	 * 조회된 게시글의 조회수를 1 증가시킨다
	 * 
	 * @param boardno - 조회할 boardno를 가진 DTO객체
	 * @return Board - 조회된 게시글 정보
	 */
	public Product view(Product prodno);


	//-------------------------------------------------------
	
	
	/**
	 * 게시글 작성
	 * 입력한 게시글을 DB에 저장한다
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void write(HttpServletRequest req);

	/**
	 * 첨부파일 정보 조회하기
	 * 
	 * @param viewProduct - 첨부파일과 연결된 게시글의 번호
	 * @return ProductFile - 첨부파일 정보 DTO객체
	 */
	public ProductFile viewFile(Product viewProduct);

	
	//-------------------------------------------------------

	
	/**
	 * 게시글 수정
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void update(HttpServletRequest req);

	
	//-------------------------------------------------------

	
	/**
	 * 게시글 삭제
	 * 
	 * @param board - 삭제할 게시글 번호 객체
	 */
	public void delete(Product product);

	
	




	

	

	

}
