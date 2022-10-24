package sharon.service.impl;

import java.util.ArrayList;
import java.util.List;

import sharon.dto.Cart;
import sharon.service.face.CartService;


public class CartServiceImpl implements CartService {
	
private ArrayList<Cart> cartList = new ArrayList<Cart>();
	
	@Override
	public List<Cart> getList() {
		return cartList;
	}

}


