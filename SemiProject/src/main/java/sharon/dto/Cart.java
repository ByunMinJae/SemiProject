package sharon.dto;

public class Cart {

//	private int cartno;
	private String prodname; //상품명
	private int prodprice; //가격
	private int cartcount;	//수량
	
	
	public Cart() {}


	public Cart(String prodname, int prodprice, int cartcount) {
		super();
		this.prodname = prodname;
		this.prodprice = prodprice;
		this.cartcount = cartcount;
	}


	public String getProdname() {
		return prodname;
	}


	public void setProdname(String prodname) {
		this.prodname = prodname;
	}


	public int getProdprice() {
		return prodprice;
	}


	public void setProdprice(int prodprice) {
		this.prodprice = prodprice;
	}


	public int getCartcount() {
		return cartcount;
	}


	public void setCartcount(int cartcount) {
		this.cartcount = cartcount;
	}
	
	
	
	
	
	
}
