package jeonghwa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jeonghwa.common.JDBCTemplate;
import jeonghwa.dao.face.ProdListDao;
import jeonghwa.dto.Product;

public class ProdListDaoImpl implements ProdListDao{

	
	
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
		sql += " ORDER BY prodno";
		
		
		//--- 조회 결과 저장할 List 객체 ---
		List<Product> list = new ArrayList<>();
		
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
				product.setProdimage( rs.getBlob("prodimage"));
				
				product.setProdcon( rs.getString("prodcon"));
				product.setProdDate( rs.getDate("prodDate"));
				product.setProdpop( rs.getInt("prodpop"));
				
				list.add(product);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//--- 자원 해제 ---
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		//--- 최종 결과 반환 ---
		
		return list;
	}



	@Override
	public Product selectByProdno(Connection conn, int prodno) {
		//--- SQL 작성 ---
		String sql = "";
		sql += "SELECT";
		sql += " prodno, prodname, prodprice, prodimage";
		sql += "	, prodcon, prodDate, prodpop";
		sql += " FROM Product";
		sql += " ORDER BY prodno";
				
		//--- 조회 결과 저장 객체 ---
		Product product = null;
				
		try {
			//--- SQL 수행 객체 생성 ---
			ps = conn.prepareStatement(sql);
			ps.setInt(1, prodno);
					
			//--- SQL 수행 및 결과 저장 ---
			rs = ps.executeQuery();
					
			//--- 조회 결과 처리 ---
			while( rs.next() ) {
				product = new Product();
						
				product.setProdno( rs.getInt("prodno"));
				product.setProdname( rs.getString("prodname"));
				product.setProdprice( rs.getInt("prodprice"));
				product.setProdimage( rs.getBlob("prodimage"));
				
				product.setProdcon( rs.getString("prodcon"));
				product.setProdDate( rs.getDate("prodDate"));
				product.setProdpop( rs.getInt("prodpop"));
				
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//--- 자원 해제 ---
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		//--- 조회 결과 반환 ---
		return product;
	}
			
	}



	



