package changmin.dto;

import java.util.Date;

public class Pay {
	
	private int payno;
	private String payoption;
	private Date paydate;
	private int orderno;
	
	public Pay() {
	}
	
	

	public Pay(int payno, String payoption, Date paydate, int orderno) {
		super();
		this.payno = payno;
		this.payoption = payoption;
		this.paydate = paydate;
		this.orderno = orderno;
	}



	@Override
	public String toString() {
		return "Pay [payno=" + payno + ", payoption=" + payoption + ", paydate=" + paydate + ", orderno=" + orderno
				+ "]";
	}

	public int getPayno() {
		return payno;
	}

	public void setPayno(int payno) {
		this.payno = payno;
	}

	public String getPayoption() {
		return payoption;
	}

	public void setPayoption(String payoption) {
		this.payoption = payoption;
	}

	public Date getPaydate() {
		return paydate;
	}

	public void setPaydate(Date paydate) {
		this.paydate = paydate;
	}

	public int getOrderno() {
		return orderno;
	}

	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	
	
	
}
