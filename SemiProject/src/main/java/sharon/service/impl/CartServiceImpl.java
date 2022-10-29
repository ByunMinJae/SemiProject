package sharon.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import sharon.dao.face.CartDao;
import sharon.dao.impl.CartDaoImpl;
import sharon.dto.Cart;
import sharon.dto.Product;
import sharon.dto.User;
import sharon.service.face.CartService;


public class CartServiceImpl implements CartService {
	
private CartDao cartDao = new CartDaoImpl();
private ArrayList<Cart> cartList = new ArrayList<Cart>();
private Connection conn = JDBCTemplate.getConnection();






@Override
public List<Cart> getList() {
	
	return cartDao.cartList(conn);
}




@Override
public User getUser(int userno) {
	return cartDao.getUser(conn, userno);
}




@Override
public Product getProd(int prodno) {
	
	return cartDao.getProd(conn,prodno);
}




@Override
public void cartinsert(int userno, HttpServletRequest req, Product prod) {
	
	Cart cart= new Cart();

	
//	cart.setCartno(Integer.parseInt(req.getParameter("cartno")));
	cart.setUserno(userno);
	cart.setProdno(Integer.parseInt(req.getParameter("prodno")));
//	cart.setUserno((int)req.getSession().getAttribute("userno"));
	cart.setCartcount(Integer.parseInt(req.getParameter("cartcount")));
	cart.setProdprice(prod.getProdprice());
	cart.setProdname(prod.getProdname());	
	
	int res = cartDao.insertCart(conn,cart);
	
	if(res > 0 ) {
		JDBCTemplate.commit(conn);
//		return cart;
	}else{
		JDBCTemplate.rollback(conn);
//		return null;
	}
//	return cart;
	
}



@Override
public Cart getCartno(int cartno) {
	return cartDao.getCartno(conn, cartno);
}



//결제로 넘기기
@Override
public int insertBuyProd(HttpServletRequest req, int userno) {
	System.out.println("insertBuyProd()");
	
	Connection conn = JDBCTemplate.getConnection();
	
	String buyprodname = req.getParameter("buyprodname");
	int totalamount = Integer.parseInt(req.getParameter("totalamount"));
			
	int res = cartDao.insertBuyProd(conn, userno, buyprodname, totalamount);
	
	if( res > 0 ) {
		JDBCTemplate.commit(conn);
		System.out.println("/goods/detail insertBuyProd() - 끝");
		return 1;
	} else {
		JDBCTemplate.rollback(conn);
		System.out.println("/goods/detail insertBuyProd() - 끝");
		return 0;
	}

}



//장바구니 비우기
@Override
public void cartdelete() {
Cart cart= new Cart();
	
	int res = cartDao.deleteCart(conn);
	
	if(res > 0 ) {
		JDBCTemplate.commit(conn);
//		return cart;
	}else{
		JDBCTemplate.rollback(conn);
//		return null;
	}
//	return cart;	
}

}