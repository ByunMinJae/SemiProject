package jeonghwa.dao.face;

import java.sql.Connection;
import java.util.List;

import jeonghwa.dto.Product;
import jeonghwa.dto.ProductFile;
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
	 * @return List<Product> - 테이블 페이징 목록 조회 결과
	 */
	public List<Product> selectAll(Connection conn, Paging paging);
	
	/**
	 * 총 상품 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectCntAll(Connection conn);


	//--------------------------------------------------------------------

	
	/**
	 * 지정된 boardno의 게시글 조회하기
	 * 
	 * @param conn - DB 연결 객체
	 * @param boardno - 조회할 게시글의 boardno를 가진 DTO객체
	 * @return Board - 조회된 게시글의 상세정보 DTO객체
	 */
	public Product selectProductByProdno(Connection conn, Product prodno);

	
	//--------------------------------------------------------------------

	
	/**
	 * 게시글 입력
	 * 
	 * @param conn - DB 연결 객체
	 * @param board - 삽입될 게시글 내용
	 * @return int - INSERT 쿼리 수행 결과
	 */
	public int insert(Connection conn, Product product);

	
	/**
	 * 시퀀스를 이용하여 다음 게시글 번호 조회하기
	 * 
	 * @param conn - DB연결 객체
	 * @return int - 다음 게시글 번호
	 */	
	public int selectNextProdno(Connection conn);

	
	/**
	 * 첨부파일 삽입
	 * 
	 * @param conn - DB연결 객체
	 * @param boardFile - 첨부파일 정보
	 * @return int - INSERT 수행 결과
	 */	
	public int insertFile(Connection conn, ProductFile productFile);
	
	
	/**
	 * 첨부파일 정보 조회
	 * 
	 * @param conn - DB연결 객체
	 * @param viewBoard - 조회할 게시글 번호
	 * @return BoardFile - 첨부파일 정보
	 */
	public ProductFile selectFile(Connection conn, Product viewProduct);
	
	
	/**
	 * 게시글 수정
	 * 
	 * @param conn - DB연결 객체
	 * @param board - 수정할 내용을 담은 객체
	 * @return UPDATE 수행 결과
	 */
	public int update(Connection conn, Product product);
	
	/**
	 * 게시글에 첨부된 파일 정보 삭제
	 * 
	 * @param conn - DB연결 객체
	 * @param board - 삭제할 게시글 번호
	 * @return UPDATE 수행 결과
	 */
	public int deleteFile(Connection conn, Product product);

	/**
	 * 게시글 삭제
	 * 
	 * @param conn - DB연결 객체
	 * @param board - 삭제할 게시글 번호
	 * @return UPDATE 수행 결과
	 */
	public int delete(Connection conn, Product product);
	

}



















