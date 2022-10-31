package jeonghwa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import jeonghwa.dao.face.ProductDao;
import jeonghwa.dto.Product;
import jeonghwa.dto.ProductFile;
import util.Paging;


public class ProductDaoImpl implements ProductDao{

	
	
	private PreparedStatement ps;	// SQL수행 객체
	private ResultSet rs;		// 조회 결과 객체
	
	
	
	@Override
	public List<Product> selectAll(Connection conn) {
	
		//--- SQL 작성 ---
		String sql = "";
		sql += "SELECT";
		sql += " prodno, prodname, prodprice";
		sql += "	, prodcon, prodDate, prodpop";
		sql += " FROM Product";
		sql += " ORDER BY prodno DESC";
		
		
		//--- 조회 결과 저장할 List 객체 ---
		List<Product> productList = new ArrayList<>();
		
		try {
			//--- SQL 수행 객체 생성 ---
			ps = conn.prepareStatement(sql);
			
			//--- SQL 수행 및 결과 저장 ---
			rs = ps.executeQuery();
			
			//--- 조회 결과 처리 ---
			while ( rs.next() ) {
				Product product = new Product();
			
				product.setProdno( rs.getInt("prodno"));
				product.setProdname( rs.getString("prodname"));
				product.setProdprice( rs.getInt("prodprice"));
				
				product.setProdcon( rs.getString("prodcon"));
				product.setProdDate( rs.getDate("prodDate"));
				product.setProdpop( rs.getInt("prodpop"));
				
				productList.add(product);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//--- 자원 해제 ---
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		//--- 최종 결과 반환 ---
		
		return productList;
	}
	
	
	
	@Override
	public List<Product> selectAll(Connection conn, Paging paging) {
		System.out.println("ProductDao selectAll() - 시작");
		
		//SQL작성
				String sql = "";
				sql += "SELECT * FROM (";
				sql += "	SELECT rownum rnum, P.* FROM (";
				sql += "		SELECT";
				sql += "			prodno, prodname, prodprice";
				sql += "			, prodcon, prodDate, prodpop";
				sql += "		FROM Product";
				sql += "		ORDER BY prodno DESC";
				sql += "	) P";
				sql += " ) PRODUCT";
				sql += " WHERE rnum BETWEEN ? AND ?";
		
		//결과 저장할 List
		List<Product> productList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Product p = new Product();
				
				p.setProdno( rs.getInt("prodno")); 
				p.setProdname( rs.getString("prodname"));
				p.setProdprice(rs.getInt("prodprice"));
				
				p.setProdcon( rs.getString("prodcon"));
				p.setProdDate( rs.getDate("prodDate"));
				p.setProdpop( rs.getInt("prodpop"));
				
				//리스트에 결과값 저장하기
				productList.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return productList; //최종 결과 반환
	}



	@Override
	public int selectCntAll(Connection conn) {
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM Product";

		//총 게시글 수 변수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while ( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		//최종 결과 반환
		return count;
	}

	//--------------------------------------------------------------------	



	@Override
	public Product selectProductByProdno(Connection conn, Product prodno) {
		
		String sql = "";
		sql += "SELECT";
		sql += "	prodno, prodname, prodprice";
		sql += "	, prodcon, prodDate, prodpop";
		sql += " FROM Product";
		sql += " WHERE prodno = ?";
		
		Product product = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, prodno.getProdno());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				product = new Product();
				
				product.setProdno( rs.getInt("prodno") );
				product.setProdname( rs.getString("prodname"));
				product.setProdprice( rs.getInt("prodprice"));
				
				product.setProdcon( rs.getString("prodcon"));
				product.setProdDate( rs.getDate("prodDate"));
				product.setProdpop( rs.getInt("prodpop"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return product;		
	}

	//--------------------------------------------------------------------	


	@Override
	public int insert(Connection conn, Product product) {
		
		String sql = "";
		sql += "INSERT INTO product ( prodno, prodname, prodprice, prodcon, prodDate, prodpop )";
		sql += " VALUES (  ?, ?, ?, ?, sysdate, 0 )";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, product.getProdno());
			ps.setString(2, product.getProdname());
			ps.setInt(3, product.getProdprice());
			ps.setString(4, product.getProdcon());
		
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;	
	}



	@Override
	public int selectNextProdno(Connection conn) {
		
		String sql = "";
		sql += "SELECT product_seq.nextval FROM dual";
		
		int nextProdno = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				nextProdno = rs.getInt("nextval");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println("nextProdno : " + nextProdno);
		return nextProdno;
	}



	@Override
	public int insertFile(Connection conn, ProductFile productFile) {
		System.out.println(productFile.getProdno());
		String sql = "";
		sql += "INSERT INTO productfile( fileno, prodno, originname, storedname, filesize )";
		sql += " VALUES( productfile_seq.nextval, ?, ?, ?, ? )";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, productFile.getProdno());
			ps.setString(2, productFile.getOriginname());
			ps.setString(3, productFile.getStoredname());
			ps.setInt(4, productFile.getFilesize());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;		
	}



	@Override
	public ProductFile selectFile(Connection conn, Product viewProduct) {
		
		String sql = "";
		sql += "SELECT";
		sql += "	fileno, prodno, originname, storedname, filesize, write_date";
		sql += " FROM productfile";
		sql += " WHERE prodno = ?";
		
		//조회 결과 객체
		ProductFile productFile = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, viewProduct.getProdno());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				productFile = new ProductFile();
				
				productFile.setFileno( rs.getInt("fileno") );
				productFile.setProdno( rs.getInt("prodno") );
				productFile.setOriginname( rs.getString("originname"));
				productFile.setStoredname( rs.getString("storedname"));
				productFile.setFilesize( rs.getInt("filesize") );
				productFile.setWrite_date( rs.getDate("write_date") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return productFile;	
	}




	//--------------------------------------------------------------------	


	@Override
	public int update(Connection conn, Product product) {
		
		String sql = "";
		sql += "UPDATE product ";
		sql += " SET";
		sql += "	prodname = ?";
		sql += "	, prodprice = ?";
		sql += "	, prodcon = ?";
		sql += " WHERE prodno = ?";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, product.getProdname());
			ps.setInt(2, product.getProdprice());
			ps.setString(3, product.getProdcon());
			ps.setInt(4, product.getProdno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
		
	}



	@Override
	public int deleteFile(Connection conn, Product product) {
		
		String sql = "";
		sql += "DELETE productfile ";
		sql += " WHERE prodno = ?";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, product.getProdno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
		
	}



	@Override
	public int delete(Connection conn, Product product) {
		
		String sql = "";
		sql += "DELETE product";
		sql += " WHERE prodno = ?";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, product.getProdno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
		
	}
	
	
	
}



	
	


			





















	



