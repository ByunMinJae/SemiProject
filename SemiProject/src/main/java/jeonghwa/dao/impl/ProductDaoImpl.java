package jeonghwa.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jeonghwa.common.JDBCTemplate;
import jeonghwa.dao.face.ProductDao;
import jeonghwa.dto.Product;
import util.Paging;

public class ProductDaoImpl implements ProductDao{

	
	
	private PreparedStatement ps;	// SQL수행 객체
	private ResultSet rs;		// 조회 결과 객체
	
	
	
	@Override
	public List<Product> selectAll(Connection conn) {
	
		//--- SQL 작성 ---
		String sql = "";
		sql += "SELECT";
		sql += " prodno, prodname, prodprice, prodimage";
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
				product.setProdimage( rs.getString("prodimage"));
				
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




	@Override
	public List<Product> selectAll(Connection conn, Paging paging) {
		System.out.println("ProductDao selectAll() - 시작");
		
		//SQL작성
				String sql = "";
				sql += "SELECT * FROM (";
				sql += "	SELECT rownum rnum, P.* FROM (";
				sql += "		SELECT";
				sql += "			prodno, prodname, prodprice, prodimage";
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
				p.setProdimage( rs.getString("prodimage"));
				
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
		
		System.out.println("ProductDao selectAll() - 끝");
		return productList; //최종 결과 반환
	}






			
}




















