package changmin.dto;

public class OrderBefore {
	private int orderno;
	private String buyprodname;
	private int totalamount;
	private int userno;
	
	public OrderBefore() {
	}

	public OrderBefore(int orderno, String buyprodname, int totalamount, int userno) {
		super();
		this.orderno = orderno;
		this.buyprodname = buyprodname;
		this.totalamount = totalamount;
		this.userno = userno;
	}

	@Override
	public String toString() {
		return "OrderBefore [orderno=" + orderno + ", buyprodname=" + buyprodname + ", totalamount=" + totalamount
				+ ", userno=" + userno + "]";
	}

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}

	public String getBuyprodname() {
		return buyprodname;
	}

	public void setBuyprodname(String buyprodname) {
		this.buyprodname = buyprodname;
	}

	public int getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}
	
	
}
