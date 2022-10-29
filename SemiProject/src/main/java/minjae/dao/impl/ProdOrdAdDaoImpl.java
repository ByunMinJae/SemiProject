package minjae.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import minjae.dao.face.ProdOrdAdDao;
import minjae.dto.ProdOrdAd;
import util.Paging;

public class ProdOrdAdDaoImpl implements ProdOrdAdDao {
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List<ProdOrdAd> selectProdOrdInfo(Connection conn, Paging paging) {
		System.out.println("/prodOrdAd/list selectProdOrdInfo() - 시작");
		
		String sql = "";
		
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "SELECT a.orderafterno, SUBSTR(a.orderdate, 1, 10) orderdate, a.prodname, a.orderprocess,";
		sql += " (a.amount/b.prodprice) cnt, a.amount FROM user_orderafter a";
		sql += " 	INNER JOIN product b";
		sql += " 	ON a.prodname = b.prodname";
		sql += "	) B";
		sql += " ) PROD";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		List<ProdOrdAd> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				ProdOrdAd p = new ProdOrdAd();
				
				p.setOrderafterno(rs.getInt("orderafterno"));
				p.setOrderdate(rs.getString("orderdate"));
				p.setProdname(rs.getString("prodname"));
				p.setOrderprocess(rs.getString("orderprocess"));
				p.setOrdercnt(rs.getInt("cnt"));
				p.setAmount(rs.getInt("amount"));
				
				list.add(p);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("/prodOrdAd/list selectProdOrdInfo() - 끝");
		return list;
	}
	
	@Override
	public List<ProdOrdAd> selectProdOrdCate(Connection conn, Paging paging, String cate) {
		System.out.println("/prodOrdAd/list selectProdOrdCate() - 시작");
		
		String sql = "";
		
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "SELECT a.orderafterno, SUBSTR(a.orderdate, 1, 10) orderdate, a.prodname, a.orderprocess,";
		sql += " (a.amount/b.prodprice) cnt, a.amount FROM user_orderafter a";
		sql += " 	INNER JOIN product b";
		sql += " 	ON a.prodname = b.prodname";
		if("orderafterno".equals(cate)) { //기본 순
			sql += "		ORDER BY orderafterno";
		} else if("orderdate".equals(cate)) { //오래된 순
			sql += "		ORDER BY orderdate";
		} else if("orderdate DESC".equals(cate)) { //최신 순
			sql += "		ORDER BY orderdate DESC";
		} else if("prodname".equals(cate)) { //이름 순
			sql += "		ORDER BY prodname";
		} 
		sql += "	) B";
		sql += " ) PROD";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		List<ProdOrdAd> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				ProdOrdAd p = new ProdOrdAd();
				
				p.setOrderafterno(rs.getInt("orderafterno"));
				p.setOrderdate(rs.getString("orderdate"));
				p.setProdname(rs.getString("prodname"));
				p.setOrderprocess(rs.getString("orderprocess"));
				p.setOrdercnt(rs.getInt("cnt"));
				p.setAmount(rs.getInt("amount"));
				
				list.add(p);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("/prodOrdAd/list selectProdOrdCate() - 끝");
		return list;
	}
	
	@Override
	public int selectCntAll(Connection conn) {
		System.out.println("/prodOrdAd/list selectCntAll() - 시작");
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM (";
		sql += " SELECT a.orderafterno, SUBSTR(a.orderdate, 1, 10) orderdate, a.prodname, a.orderprocess,";
		sql += " (a.amount/b.prodprice) cnt, a.amount FROM user_orderafter a";
		sql += " 	INNER JOIN product b";
		sql += " 	ON a.prodname = b.prodname)";
		
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
		
		System.out.println("/prodOrdAd/list selectCntAll() - 끝");
		//최종 결과 반환
		return count;
	}
	
	@Override
	public int updateOrdProc(Connection conn, HttpServletRequest req) {
		System.out.println("/prodOrdAd/list updateOrdProc() - 시작");
		
		String sql = "";
		sql += "UPDATE user_orderafter";
		sql += " SET orderprocess = ?";
		sql += " WHERE orderafterno = ?";
		
		//update 결과 저장 변수
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			ps.setString(1, req.getParameter("select"));
			ps.setInt(2, Integer.parseInt(req.getParameter("orderafterno")));
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}	
		
		System.out.println("/prodOrdAd/list updateOrdProc() - 끝");
		return res;
	}
	
}















