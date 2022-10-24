package minjae.dto;

import java.util.Date;

public class Product {
	
	private int prodno;
	private String prodname;
	private int prodprice;
	private String prodcon;
	private Date proddate;
	private int prodpop;
	private String prodimage;
	
	public Product() {}

	public Product(int prodno, String prodname, int prodprice, String prodcon, Date proddate, int prodpop,
			String prodimage) {
		super();
		this.prodno = prodno;
		this.prodname = prodname;
		this.prodprice = prodprice;
		this.prodcon = prodcon;
		this.proddate = proddate;
		this.prodpop = prodpop;
		this.prodimage = prodimage;
	}

	@Override
	public String toString() {
		return "Product [prodno=" + prodno + ", prodname=" + prodname + ", prodprice=" + prodprice + ", prodcon="
				+ prodcon + ", proddate=" + proddate + ", prodpop=" + prodpop + ", prodimage=" + prodimage + "]";
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

	public String getProdcon() {
		return prodcon;
	}

	public void setProdcon(String prodcon) {
		this.prodcon = prodcon;
	}

	public Date getProddate() {
		return proddate;
	}

	public void setProddate(Date proddate) {
		this.proddate = proddate;
	}

	public int getProdpop() {
		return prodpop;
	}

	public void setProdpop(int prodpop) {
		this.prodpop = prodpop;
	}

	public String getProdimage() {
		return prodimage;
	}

	public void setProdimage(String prodimage) {
		this.prodimage = prodimage;
	}

}
