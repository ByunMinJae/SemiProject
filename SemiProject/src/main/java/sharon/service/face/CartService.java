package sharon.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import sharon.dto.Cart;
import sharon.dto.Product;
import sharon.dto.User;

public interface CartService {

	public List<Cart> getList();
	
	public User getUser(int userno);
	
	public Product getProd(int prodno);

	public void cartinsert(int userno, HttpServletRequest req, Product prod);


	public Cart getCartno(int cartno);

	public int insertBuyProd(HttpServletRequest req, int userno);


	public void cartdelete();

}
