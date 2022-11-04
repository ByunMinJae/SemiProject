package sharon.dto;

public class Cart {

	private int cartno;		//장바구니 번호 -자동생성
	private int userno;		//회원번호	-user에 있는것
	private int prodno;		//상품번호	-product에 있는것
	private int cartcount;	//수량

		private String prodname; //상품명 
		private int prodprice; //가격 	

	public Cart() {	}



	public Cart(int cartno, int userno, int prodno, int cartcount, String prodname, int prodprice) {
		super();
		this.cartno = cartno;
		this.userno = userno;
		this.prodno = prodno;
		this.cartcount = cartcount;
		this.prodname = prodname;
		this.prodprice = prodprice;
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

	@Override
	public String toString() {
		return "Cart [cartno=" + cartno + ", userno=" + userno + ", prodno=" + prodno + ", cartcount=" + cartcount
				+ ", prodname=" + prodname + ", prodprice=" + prodprice + "]";
	}

	public int getCartno() {
		return cartno;
	}

	public void setCartno(int cartno) {
		this.cartno = cartno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public int getProdno() {
		return prodno;
	}

	public void setProdno(int prodno) {
		this.prodno = prodno;
	}

	public int getCartcount() {
		return cartcount;
	}

	public void setCartcount(int cartcount) {
		this.cartcount = cartcount;
	}




}
