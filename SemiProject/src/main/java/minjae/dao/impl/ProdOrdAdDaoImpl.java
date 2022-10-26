package minjae.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import minjae.dao.face.ProdOrdAdDao;
import minjae.dto.ProdOrdAd;

public class ProdOrdAdDaoImpl implements ProdOrdAdDao {
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public List<ProdOrdAd> selectProdOrdInfo(Connection conn) {
		System.out.println("/admin/prodOrdAd selectProdOrdInfo() - 시작");
		
		String sql = "";
		sql += "SELECT a.orderafterno, SUBSTR(a.orderdate, 1, 10) orderdate, a.prodname, a.orderprocess,";
		sql += " (a.amount/b.prodprice) cnt, a.amount FROM user_orderafter a";
		sql += " 	INNER JOIN product b";
		sql += " 	ON a.prodname = b.prodname";
		
		List<ProdOrdAd> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
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
		
		System.out.println("/admin/prodOrdAd selectProdOrdInfo() - 끝");
		return list;
	}

}















