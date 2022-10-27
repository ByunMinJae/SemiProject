package sharon.dao.face;

import java.sql.Connection;
import java.util.List;

import sharon.dto.Cart;
import sharon.dto.Product;
import sharon.dto.User;

public interface CartDao {

	public int insertCart(Connection conn, Cart cart);

	public List<Cart> cartList(Connection conn);
	
	public Product getProd(Connection conn, int prodno);

	public User getUser(Connection conn, int userno);

}
