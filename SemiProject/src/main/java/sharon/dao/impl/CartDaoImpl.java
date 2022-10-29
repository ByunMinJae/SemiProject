package sharon.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import sharon.dao.face.CartDao;
import sharon.dto.Cart;
import sharon.dto.Product;
import sharon.dto.User;

public class CartDaoImpl implements CartDao {
	
	private PreparedStatement ps;
	private ResultSet rs;

	
	
	//회원번호 
		@Override
		public User getUser(Connection conn, int userno) {
			
			String sql = "";
			
			sql+="SELECT userno FROM user_info";
			sql+= "WHERE userno=?";
			
			User user = new User();
			
			try {
				ps= conn.prepareStatement(sql);
				ps.setInt(1, userno);
				rs=ps.executeQuery();
				
				while(rs.next()) {
					user.setUserno(rs.getInt("userno"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return user;
		}


		//상품-번호,이름,가격
		@Override
		public Product getProd(Connection conn, int prodno) {

			String sql ="";
			
			sql+= "SELECT";
			sql+= " prodno, prodname, prodprice";
			sql+= " FROM product";
			sql+= " WHERE prodno=?";
			
			Product pro = null;
			
			try {
				ps= conn.prepareStatement(sql);
				ps.setInt(1, prodno);
				rs=ps.executeQuery();
				
				while(rs.next()) {
					pro = new Product();
					
					pro.setProdno(rs.getInt("prodno"));
					pro.setProdname(rs.getString("prodname"));
					pro.setProdprice(rs.getInt("prodprice"));
				}
						
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}
			
			
			return pro;
		}
		
		
	//장바구니 추가
	@Override
	public int insertCart(Connection conn, Cart cart) {
		System.out.println(cart);
		String sql ="";
		
		sql += "INSERT INTO cart";
		sql += "	(cartno, cartcount, userno, prodno)";// , prodname, prodprice
		sql += "	VALUES";
		sql += "	(cart_seq.nextval, ?, ?, ?)";
		
		int res = 0;
		
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1,cart.getCartcount());
			ps.setInt(2,cart.getUserno());
			ps.setInt(3,cart.getProdno());
//			ps.setString(4,cart.getProdname());
//			ps.setInt(5,cart.getProdprice());
			
			res= ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	
	//장바구니 목록
	@Override
	public List<Cart> cartList(Connection conn) {
		
		String sql = "";
		sql+="SELECT cartno, cartcount, userno, prodno";//, prodprice, prodname
		sql+="	FROM cart";
		sql+="	ORDER BY cartno desc";
		
		//조회 결과 저장할 List객체
		List<Cart> cartList = new ArrayList<>();
		
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
					
			//조회 결과 처리
			while(rs.next()) {
				
				Cart c = new Cart();
				c.setCartno(rs.getInt("cartno"));
				c.setCartno(rs.getInt("cartcount"));
				c.setUserno(rs.getInt("userno"));
				c.setProdno(rs.getInt("prodno"));
//				c.setProdname(rs.getString("prodname"));
//				c.setProdprice(rs.getInt("prodprice"));
				
				cartList.add(c);
				
			}
		
			System.out.println("cartList"+cartList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cartList;
	}



}
