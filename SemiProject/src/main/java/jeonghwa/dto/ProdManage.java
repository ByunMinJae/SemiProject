package jeonghwa.dto;

public class ProdManage {
	
	private int prodno;
	private String prodname;
	private int prodprice;
	private int prodimage;
	private int prodcon;
	private int proddate;
	private int prodpop;
	
	
	public ProdManage() {}


	public ProdManage(int prodno, String prodname, int prodprice, int prodimage, int prodcon, int proddate,
			int prodpop) {
		super();
		this.prodno = prodno;
		this.prodname = prodname;
		this.prodprice = prodprice;
		this.prodimage = prodimage;
		this.prodcon = prodcon;
		this.proddate = proddate;
		this.prodpop = prodpop;
	}


	@Override
	public String toString() {
		return "ProdManage [prodno=" + prodno + ", prodname=" + prodname + ", prodprice=" + prodprice + ", prodimage="
				+ prodimage + ", prodcon=" + prodcon + ", proddate=" + proddate + ", prodpop=" + prodpop + "]";
	}


	public int getProdno() {
		return prodno;
	}


	public void setProdno(int prodno) {
		this.prodno = prodno;
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


	public int getProdimage() {
		return prodimage;
	}


	public void setProdimage(int prodimage) {
		this.prodimage = prodimage;
	}


	public int getProdcon() {
		return prodcon;
	}


	public void setProdcon(int prodcon) {
		this.prodcon = prodcon;
	}


	public int getProddate() {
		return proddate;
	}


	public void setProddate(int proddate) {
		this.proddate = proddate;
	}


	public int getProdpop() {
		return prodpop;
	}


	public void setProdpop(int prodpop) {
		this.prodpop = prodpop;
	}
	
	
	
}
