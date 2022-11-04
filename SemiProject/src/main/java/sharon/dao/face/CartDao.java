package sharon.dao.face;

import java.sql.Connection;
import java.util.List;

import sharon.dto.Cart;
import sharon.dto.Product;
import sharon.dto.User;

public interface CartDao {


	public List<Cart> cartList(Connection conn);
	
	public Product getProd(Connection conn, int prodno);

	public User getUser(Connection conn, int userno);

	public int insertCart(Connection conn, Cart cart);

//	public int deleteCart(Connection conn, Cart cart);

	public Cart getCartno(Connection conn, int cartno);

	public int insertBuyProd(Connection conn, int userno, String buyprodname, int totalamount);
	//1028 추가 테스트
	public int deleteCart(Connection conn);

}
