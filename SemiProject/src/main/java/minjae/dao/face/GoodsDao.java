package minjae.dao.face;

import java.sql.Connection;
import java.util.List;

import minjae.dto.Product;
import minjae.dto.ProductFile;
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
	
	public int selectCntSearch(Connection connection, String search);

	
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
	 *  전달 받은 단어가 포함된 상품 리스트를 반환한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param paging - 페이징 정보 객체
	 * @param search - 검색 단어
	 * @return List<Product> - 테이블 페이징 목록 조회 결과
	 */
	public List<Product> selectSearchAll(Connection conn, Paging paging, String search);
	
	/**
	 *  잔달 받은 단어가 없을 때 디폴트 값으로 '%%'를 넣어 조회한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param paging - 페이징 정보 객체
	 * @param def - 디폴드 검색어
	 * @return List<Product> - 테이블 페이징 목록 조회 결과
	 */
	public List<Product> selectSearchDefualt(Connection conn, Paging paging, String def);

	/**
	 *  해당 번호의 상품의 상세정보를 조회한 후 반환한다
	 * 
	 * @param conn - DB 연결 객체
	 * @param prodno - 상품 번호
	 * @return 상품 상세 정보 DTO
	 */
	public Product selectProdDetail(Connection conn, int prodno);
	
	/**
	 *  해당 정보를 orderbefore 테이블에 insert 한다
	 *  
	 * @param conn - DB 연결 객체
	 * @param userno - 유저 번호
	 * @param buyprodname - 상품이름
	 * @param totalamount - 총 구매가격
	 * @return insert 결과
	 */
	public int insertBuyProd(Connection conn, int userno, String buyprodname, int totalamount);
	
	/**
	 *  첨부파일 정보 조회
	 *  
	 * @param conn - DB연결 객체
	 * @param pordDetail - 조회할 상품 번호
	 * @return ProductFile - 첨부파일 정보
	 */
	public ProductFile selectFile(Connection conn, Product pordDetail);

	public List<ProductFile> selectFileList(Connection conn, List<Product> goodsList);





}
