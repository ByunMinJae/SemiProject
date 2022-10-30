package changmin.dto;

public class Order {
	private int orderafterno;
	private String orderprocess;
	private String paymethod;
	private String merchant_uid;
	private String prodname;
	private int amount;
	private String buyeremail;
	private String buyername;
	private String buyertel;
	private String buyeraddr;
	private String orderdate;
	private int orderno;
	private int userno;

	public Order() {
	}

	@Override
	public String toString() {
		return "Order [orderafterno=" + orderafterno + ", orderprocess=" + orderprocess + ", paymethod=" + paymethod
				+ ", merchant_uid=" + merchant_uid + ", prodname=" + prodname + ", amount=" + amount + ", buyeremail="
				+ buyeremail + ", buyername=" + buyername + ", buyertel=" + buyertel + ", buyeraddr=" + buyeraddr
				+ ", orderdate=" + orderdate + ", orderno=" + orderno + ", userno=" + userno + "]";
	}

	public Order(int orderafterno, String orderprocess, String paymethod, String merchant_uid, String prodname,
			int amount, String buyeremail, String buyername, String buyertel, String buyeraddr, String orderdate,
			int orderno, int userno) {
		super();
		this.orderafterno = orderafterno;
		this.orderprocess = orderprocess;
		this.paymethod = paymethod;
		this.merchant_uid = merchant_uid;
		this.prodname = prodname;
		this.amount = amount;
		this.buyeremail = buyeremail;
		this.buyername = buyername;
		this.buyertel = buyertel;
		this.buyeraddr = buyeraddr;
		this.orderdate = orderdate;
		this.orderno = orderno;
		this.userno = userno;
	}

	public int getOrderafterno() {
		return orderafterno;
	}

	public void setOrderafterno(int orderafterno) {
		this.orderafterno = orderafterno;
	}

	public String getOrderprocess() {
		return orderprocess;
	}

	public void setOrderprocess(String orderprocess) {
		this.orderprocess = orderprocess;
	}

	public String getPaymethod() {
		return paymethod;
	}

	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}

	public String getMerchant_uid() {
		return merchant_uid;
	}

	public void setMerchant_uid(String merchant_uid) {
		this.merchant_uid = merchant_uid;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getBuyeremail() {
		return buyeremail;
	}

	public void setBuyeremail(String buyeremail) {
		this.buyeremail = buyeremail;
	}

	public String getBuyername() {
		return buyername;
	}

	public void setBuyername(String buyername) {
		this.buyername = buyername;
	}

	public String getBuyertel() {
		return buyertel;
	}

	public void setBuyertel(String buyertel) {
		this.buyertel = buyertel;
	}

	public String getBuyeraddr() {
		return buyeraddr;
	}

	public void setBuyeraddr(String buyeraddr) {
		this.buyeraddr = buyeraddr;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	
	
	
}
