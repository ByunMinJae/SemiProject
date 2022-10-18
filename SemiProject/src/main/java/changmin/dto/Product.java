package changmin.dto;

public class Product {
	private int prodno;
	private String prodname;
	private int prodprice;

	public Product() {
	}

	@Override
	public String toString() {
		return "Product [prodno=" + prodno + ", prodname=" + prodname + ", prodprice=" + prodprice + "]";
	}

	public Product(int prodno, String prodname, int prodprice) {
		super();
		this.prodno = prodno;
		this.prodname = prodname;
		this.prodprice = prodprice;
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

	
	
}
