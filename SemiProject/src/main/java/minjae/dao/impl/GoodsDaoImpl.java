package minjae.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import minjae.dao.face.GoodsDao;
import minjae.dto.Product;
import util.Paging;

public class GoodsDaoImpl implements GoodsDao {
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List<Product> selectProdList(Connection conn) {
		System.out.println("/goods/list selectProdList() - 시작");
		
		String sql = "SELECT * FROM product ORDER BY prodno";
		
		List<Product> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				Product prod = new Product();
				
				prod.setProdno(rs.getInt("prodno"));
				prod.setProdname(rs.getString("prodname"));
				prod.setProdprice(rs.getInt("prodprice"));
				prod.setProdcon(rs.getString("prodcon"));
				prod.setProddate(rs.getDate("proddate"));
				prod.setProdpop(rs.getInt("prodpop"));
				prod.setProdimage(rs.getString("prodimage"));
				
				list.add(prod);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		System.out.println("/goods/list selectProdList() - 끝");
		return list;
	}
	
	@Override
	public int selectCntAll(Connection conn) {
		System.out.println("/goods/list selectCntAll() - 시작");
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM product";
		
		//총 게시글 수 변수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장

			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("/goods/list selectCntAll() - 끝");
		//최종 결과 반환
		return count;
	}
	
	@Override
	public List<Product> selectAll(Connection conn, Paging paging) {
		System.out.println("/goods/list selectAll() - 시작");
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		SELECT";
		sql += "			prodno, prodname, prodprice, prodimage, prodcon, proddate, prodpop";
		sql += "		FROM product";
		sql += "		ORDER BY prodno DESC";
		sql += "	) B";
		sql += " ) PROD";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		//결과 저장할 List
		List<Product> goodsList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Product prod = new Product(); //조회 결과 행 저장 DTO객체
				
				prod.setProdno(rs.getInt("prodno"));
				prod.setProdname(rs.getString("prodname"));
				prod.setProdprice(rs.getInt("prodprice"));
				prod.setProdcon(rs.getString("prodcon"));
				prod.setProddate(rs.getDate("proddate"));
				prod.setProdpop(rs.getInt("prodpop"));
				prod.setProdimage(rs.getString("prodimage"));
				
				//리스트에 결과값 저장하기
				goodsList.add(prod);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("/goods/list selectAll() - 끝");
		return goodsList; //최종 결과 반환
	}
	
	@Override
	public List<Product> selectAll(Connection conn, Paging paging, String cateVal) {
		System.out.println("/goods/list selectAll(cateVal) - 시작");
		System.out.println("현재 조회하려는 카테고리 : " + cateVal);
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		SELECT";
		sql += "			prodno, prodname, prodprice, prodimage, prodcon, proddate, prodpop";
		sql += "		FROM product";
		if("prodno".equals(cateVal)) { //기본 순
			sql += "		ORDER BY prodno";
		} else if("prodprice".equals(cateVal)) { //가격 낮은 순
			sql += "		ORDER BY prodprice";
		} else if("prodprice DESC".equals(cateVal)) { //가격 높은 순
			sql += "		ORDER BY prodprice DESC";
		} else if("prodpop DESC".equals(cateVal)) { //판매량 순
			sql += "		ORDER BY prodpop DESC";
		} 
//		else if("proddate".equals(cateVal)) { //최신 등록일 순
//			sql += "		ORDER BY proddate";
//		}
		sql += "	) B"; 	
		sql += " ) PROD";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//결과 저장할 List
		List<Product> goodsList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Product prod = new Product(); //조회 결과 행 저장 DTO객체
				
				prod.setProdno(rs.getInt("prodno"));
				prod.setProdname(rs.getString("prodname"));
				prod.setProdprice(rs.getInt("prodprice"));
				prod.setProdcon(rs.getString("prodcon"));
				prod.setProddate(rs.getDate("proddate"));
				prod.setProdpop(rs.getInt("prodpop"));
				prod.setProdimage(rs.getString("prodimage"));
				
				//리스트에 결과값 저장하기
				goodsList.add(prod);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("/goods/list selectAll(cateVal) - 끝");
		return goodsList; //최종 결과 반환
	}
	
	@Override
	public List<Product> selectSearchAll(Connection conn, Paging paging, String search) {
		System.out.println("/goods/list selectSearchAll() - 시작");
		System.out.println("현재 검색하려는 단어 : " + search);
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		SELECT";
		sql += "			prodno, prodname, prodprice, prodimage, prodcon, proddate, prodpop";
		sql += "		FROM product";
		sql += "		WHERE prodname LIKE ?";
		sql += "		ORDER BY prodno";
		sql += "	) B"; 	
		sql += " ) PROD";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//결과 저장할 List
		List<Product> goodsList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			ps.setString(1, search);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Product prod = new Product(); //조회 결과 행 저장 DTO객체
				
				prod.setProdno(rs.getInt("prodno"));
				prod.setProdname(rs.getString("prodname"));
				prod.setProdprice(rs.getInt("prodprice"));
				prod.setProdcon(rs.getString("prodcon"));
				prod.setProddate(rs.getDate("proddate"));
				prod.setProdpop(rs.getInt("prodpop"));
				prod.setProdimage(rs.getString("prodimage"));
				
				//리스트에 결과값 저장하기
				goodsList.add(prod);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("/goods/list selectSearchAll() - 끝");
		return goodsList; //최종 결과 반환
	}
	
	@Override
	public List<Product> selectSearchDefualt(Connection conn, Paging paging, String def) {
		System.out.println("/goods/list selectSearchDefualt() - 시작");
		System.out.println("현재 검색하려는 단어 : " + def);
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		SELECT";
		sql += "			prodno, prodname, prodprice, prodimage, prodcon, proddate, prodpop";//이미지 있는거
		sql += "		FROM product";
		sql += "		WHERE prodname LIKE ?";
		sql += "		ORDER BY prodno";
		sql += "	) B"; 	
		sql += " ) PROD";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//결과 저장할 List
		List<Product> goodsList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			ps.setString(1, def);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Product prod = new Product(); //조회 결과 행 저장 DTO객체
				
				prod.setProdno(rs.getInt("prodno"));
				prod.setProdname(rs.getString("prodname"));
				prod.setProdprice(rs.getInt("prodprice"));
				prod.setProdcon(rs.getString("prodcon"));
				prod.setProddate(rs.getDate("proddate"));
				prod.setProdpop(rs.getInt("prodpop"));
				prod.setProdimage(rs.getString("prodimage"));
				
				//리스트에 결과값 저장하기
				goodsList.add(prod);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("/goods/list selectSearchDefualt() - 끝");
		return goodsList; //최종 결과 반환
	}
	
	@Override
	public Product selectProdDetail(Connection conn, int prodno) {
		System.out.println("/goods/detail selectProdDetail() - 시작");
		
		String sql = "SELECT * FROM product WHERE prodno = ?";
		
		Product prod = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, prodno);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				prod = new Product();
				
				prod.setProdno(rs.getInt("prodno"));
				prod.setProdname(rs.getString("prodname"));
				prod.setProdprice(rs.getInt("prodprice"));
				prod.setProdcon(rs.getString("prodcon"));
				prod.setProddate(rs.getDate("proddate"));
				prod.setProdpop(rs.getInt("prodpop"));
				prod.setProdimage(rs.getString("prodimage"));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		System.out.println("/goods/detail selectProdDetail() - 끝");
		return prod;
	}
	
	@Override
	public int insertBuyProd(Connection conn, int userno, String buyprodname, int totalamount) {
		System.out.println("/goods/detail insertBuyProd() - 시작");
		
		String sql = "";
		sql += "INSERT INTO user_orderbefore";
		sql += " VALUES (user_orderbefore_seq.nextval, ?, ?, ?)";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, buyprodname);
			ps.setInt(2, totalamount);
			ps.setInt(3, userno);
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("/goods/detail insertBuyProd() - 끝");
		return res;
	}
	
}











