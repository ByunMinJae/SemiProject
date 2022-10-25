package changmin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import changmin.dao.face.OrderDao;
import changmin.dto.Order;
import common.JDBCTemplate;
import util.Paging2;

public class OrderDaoImpl implements OrderDao{
 
	private PreparedStatement ps;
	private ResultSet rs;
	

	@Override
	public int insertOrder(Connection conn, Order order, int userno) {
		System.out.println(order.getPaymethod()); 
		String sql = "";
		sql += "INSERT INTO user_orderafter";
		sql += "	(orderafterno, pay_method, merchant_uid, prodname, amount, buyer_email, buyer_name, buyer_tel, buyer_addr, orderno, orderprocess, orderdate, userno)";
		sql += "	VALUES";
		sql += "	(user_orderafter_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, '결제완료', trim(to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss')), ?)";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, order.getOrderafterno());
			ps.setString(1, order.getPaymethod());
			ps.setString(2, order.getMerchant_uid());
			ps.setString(3, order.getProdname());
			ps.setInt(4, order.getAmount());
			ps.setString(5, order.getBuyeremail());
			ps.setString(6, order.getBuyername());
			ps.setString(7, order.getBuyertel());
			ps.setString(8, order.getBuyeraddr());
			ps.setInt(9, order.getOrderno());
			ps.setInt(10, userno);
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println(order.getOrderprocess());
		return res;
	}


	@Override
	public List<Order> orderList(Connection conn) {
		String sql = "";
		sql+="SELECT orderafterno, pay_method, prodname, amount, buyer_email, buyer_name, buyer_addr, orderdate";
		sql+="	FROM user_orderafter";
		sql+="	ORDER BY orderafterno desc";
		
		List<Order> orderList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Order o = new Order();
				o.setOrderafterno(rs.getInt("orderafterno"));
				o.setPaymethod(rs.getString("pay_method"));
				o.setProdname(rs.getString("prodname"));
				o.setAmount(rs.getInt("amount"));
				o.setBuyeremail(rs.getString("buyer_name"));
				o.setBuyeraddr(rs.getString("buyer_addr"));
				o.setOrderdate(rs.getString("orderdate"));
				System.out.println("OrderDaoImpl orderdate : " + rs.getString("orderdate"));
//				o.setOrderdate(rs.getDate("orderdate"));
				
				orderList.add(o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderList;
	}


	@Override
	public int selectCntAll(Connection conn, int userno) {
		
		String sql = "";
		sql += "SELECT count(*) cnt";
		sql += "	FROM user_orderafter";
		sql += "	WHERE userno=?";
		
		//총 게시글 수 변수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, userno);
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("selectCntAll : " + count);
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return count;
	}


	@Override
	public List<Order> selectAll(Connection conn, Paging2 paging, int userno) {
		System.out.println("selectAll - start");
		
		//SQL 작성
	      String sql = "";
	      sql += "SELECT * FROM ("; 
	      sql += "   SELECT rownum rnum, B.* FROM (";
	      sql += "      SELECT";
	      sql += "         orderafterno, prodname, amount, buyer_addr, orderdate";
	      sql += "       FROM user_orderafter";
	      sql += "		 WHERE userno = ?";		
	      sql += "       ORDER BY orderafterno DESC";
	      sql += "    ) B";
	      sql += " )";
	      sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Order> list = new ArrayList<>();

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userno);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				Order order = new Order();
				
				order.setOrderafterno(rs.getInt("orderafterno"));
				order.setProdname(rs.getString("prodname"));
				order.setAmount(rs.getInt("amount"));
				order.setBuyeraddr(rs.getString("buyer_addr"));
				order.setOrderdate(rs.getString("orderdate"));
				
				list.add(order);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return list;
	}
}
