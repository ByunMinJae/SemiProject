package sharon.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import sharon.dto.Cart;
import sharon.dto.Product;
import sharon.dto.User;

public interface CartService {

	public List<Cart> getList();

	public Cart cartinsert(HttpServletRequest req);
	
	public User getUser(int userno);
	
	public Product getProd(int prodno);

}
