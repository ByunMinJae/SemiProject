package minjae.dto;

public class ProdOrdAd {
	
	private int orderafterno;
	private String orderdate;
	private String prodname;
	private String orderprocess;
	private int ordercnt;
	private int amount;
	
	public ProdOrdAd() {}

	public ProdOrdAd(int orderafterno, String orderdate, String prodname, String orderprocess, int ordercnt,
			int amount) {
		super();
		this.orderafterno = orderafterno;
		this.orderdate = orderdate;
		this.prodname = prodname;
		this.orderprocess = orderprocess;
		this.ordercnt = ordercnt;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ProdOrdAd [orderafterno=" + orderafterno + ", orderdate=" + orderdate + ", prodname=" + prodname
				+ ", orderprocess=" + orderprocess + ", ordercnt=" + ordercnt + ", amount=" + amount + "]";
	}

	public int getOrderafterno() {
		return orderafterno;
	}

	public void setOrderafterno(int orderafterno) {
		this.orderafterno = orderafterno;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public String getOrderprocess() {
		return orderprocess;
	}

	public void setOrderprocess(String orderprocess) {
		this.orderprocess = orderprocess;
	}

	public int getOrdercnt() {
		return ordercnt;
	}

	public void setOrdercnt(int ordercnt) {
		this.ordercnt = ordercnt;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
