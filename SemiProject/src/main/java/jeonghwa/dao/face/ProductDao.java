package jeonghwa.dao.face;

import java.sql.Connection;
import java.util.List;

import jeonghwa.dto.Product;
import util.Paging;

public interface ProductDao {

	
	/**
	 * Product 테이블 전체 조회
	 * 
	 * @param conn - DB연결 객체
	 * @return 조회된 전체 상품 목록 
	 */
	public List<Product> selectAll(Connection conn);


	/**
	 * 게시글 테이블 페이징 목록 조회
	 * 
	 * 
	 * @param conn - DB 연결 객체
	 * @param paging - 페이징 정보 전체
	 * @return List<Board> - 테이블 페이징 목록 조회 결과
	 */
	public List<Product> selectAll(Connection conn, Paging paging);


	/**
	 * 총 게시글 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectCntAll(Connection conn);

	





	

}