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
public Cart cartinsert(HttpServletRequest req) {
	
	Cart cart =new Cart();

//	cart.setCartno(Integer.parseInt(req.getParameter("cartno")));
//	cart.setUserno(Integer.parseInt(req.getParameter("userno")));
	cart.setProdno(Integer.parseInt(req.getParameter("prodno")));
	cart.setUserno((int)req.getSession().getAttribute("userno"));
	cart.setCartcount(Integer.parseInt(req.getParameter("cartcount")));
	
	int res = cartDao.insertCart(conn,cart);
	
	if(res > 0 ) {
		JDBCTemplate.commit(conn);
		return cart;
	}else{
		JDBCTemplate.rollback(conn);
		return null;
	}
//	return cart;
	
}




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

}


