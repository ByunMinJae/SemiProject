package jeonghwa.dto;

import java.sql.Blob;
import java.util.Date;

public class Product {
	
	private int prodno;
	private String prodname;
	private int prodprice;
	private Blob prodimage;
	private String prodcon;
	private Date prodDate;
	private int prodpop;
	
	
	public Product() {}


	public Product(int prodno, String prodname, int prodprice, Blob prodimage, String prodcon, Date prodDate,
			int prodpop) {
		super();
		this.prodno = prodno;
		this.prodname = prodname;
		this.prodprice = prodprice;
		this.prodimage = prodimage;
		this.prodcon = prodcon;
		this.prodDate = prodDate;
		this.prodpop = prodpop;
	}


	@Override
	public String toString() {
		return "Product [prodno=" + prodno + ", prodname=" + prodname + ", prodprice=" + prodprice + ", prodimage="
				+ prodimage + ", prodcon=" + prodcon + ", prodDate=" + prodDate + ", prodpop=" + prodpop + "]";
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


	public Blob getProdimage() {
		return prodimage;
	}


	public void setProdimage(Blob prodimage) {
		this.prodimage = prodimage;
	}


	public String getProdcon() {
		return prodcon;
	}


	public void setProdcon(String prodcon) {
		this.prodcon = prodcon;
	}


	public Date getProdDate() {
		return prodDate;
	}


	public void setProdDate(Date prodDate) {
		this.prodDate = prodDate;
	}


	public int getProdpop() {
		return prodpop;
	}


	public void setProdpop(int prodpop) {
		this.prodpop = prodpop;
	}
	
	
	
}
