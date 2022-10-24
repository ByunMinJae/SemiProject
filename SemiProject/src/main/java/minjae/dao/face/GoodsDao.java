package minjae.dao.face;

import java.sql.Connection;
import java.util.List;

import minjae.dto.Product;
import util.Paging;

public interface GoodsDao {
	
	/**
	 * product의 데이터를 조회후 List에 담아 반환한다
	 * 
	 * @param conn - DB 연결 객체
	 * @return 상품 리스트
	 */
	public List<Product> selectProdList(Connection conn);
	
	/**
	 * 총 게시글 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectCntAll(Connection conn);
	
	/**
	 * 게시글 테이블 페이징 목록 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param paging - 페이징 정보 객체
	 * @return List<Product> - 테이블 페이징 목록 조회 결과
	 */
	public List<Product> selectAll(Connection conn, Paging paging);
	
	/**
	 * 게시글 테이블 페이징 목록 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param paging - 페이징 정보 객체
	 * @param cateVal - 카테고리 값
	 * @return List<Product> - 테이블 페이징 목록 조회 결과
	 */
	public List<Product> selectAll(Connection conn, Paging paging, String cateVal);

	/**
	 *  해당 번호의 상품의 상세정보를 조회한 후 반환한다
	 * 
	 * @param conn DB 연결 객체
	 * @param prodno - 상품 번호
	 * @return 상품 상세 정보 DTO
	 */
	public Product selectProdDetail(Connection conn, int prodno);


}
