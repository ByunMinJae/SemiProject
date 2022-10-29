package minjae.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import minjae.dto.Product;
import minjae.dto.ProductFile;
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
	
	public Paging getPagingForSearch(HttpServletRequest req, String search);

	
	/**
	 * 게시글 페이징 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Product> - 게시글 전체 조회 목록
	 */
	public List<Product> getGoodsList(Paging paging);
	
	/**
	 * 카테고리 별 게시글 페이징 목록 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @param cateVal - 카테고리 값
	 * @return List<Product> - 조건에 맞는 게시글 조회 목록
	 */
	public List<Product> getGoodsList(Paging paging, String cateVal);
	
	/**
	 *  입력받은 단어가 포함된 상품을 조회한다
	 * 
	 * @param paging - 페이징 정보 객체
	 * @param search - 검색 단어
	 * @return List<Product> - 조건에 맞는 게시글 조회 목록
	 */
	public List<Product> getSearchList(Paging paging, String search);
	
	/**
	 *  선택하여 넘어온 상품번호를 이용하여
	 * 해당 상품의 상세 정보를 조회한다
	 * 
	 * @param prodno - 상품번호
	 * @return 상품 상세 정보 
	 */
	public Product getProdDetail(int prodno);
	
	/**
	 * 요청 정보를 orderbefore 테이블에 저장한다
	 * 
	 * @param req - 요청 데이터 정보
	 * @param userno - 요청한 유저 번호
	 * @return insert 결과
	 */
	public int insertBuyProd(HttpServletRequest req, int userno);
	
	/**
	 *  첨부파일 정보 조회하기
	 *  
	 * @param pordDetail - 첨부파일과 연결된 게시글의 번호
	 * @return ProductFile - 첨부파일 정보 DTO객체
	 */
	public ProductFile viewFile(Product pordDetail);
	
	/**
	 *  첨부파일 정보 조회하기
	 *  
	 * @param pordDetail - 첨부파일과 연결된 게시글의 번호
	 * @return ProductFile - 첨부파일 정보 DTO객체
	 */
	public List<ProductFile> viewFile(List<Product> goodsList, Paging paging);

	public List<ProductFile> viewSearchFile(List<Product> goodsList, Paging paging, String search);



}
