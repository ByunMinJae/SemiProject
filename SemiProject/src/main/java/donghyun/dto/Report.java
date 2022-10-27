package donghyun.dto;

import java.util.Date;

public class Report {
	private int reportno;
	private String reportcon;
	private Date reportdate;
	private int userno;
	private int boardno;
	
	public Report() {}

	@Override
	public String toString() {
		return "Report [reportno=" + reportno + ", reportcon=" + reportcon + ", reportdate=" + reportdate + ", userno="
				+ userno + ", boardno=" + boardno + "]";
	}

	public int getReportno() {
		return reportno;
	}

	public void setReportno(int reportno) {
		this.reportno = reportno;
	}

	public String getReportcon() {
		return reportcon;
	}

	public void setReportcon(String reportcon) {
		this.reportcon = reportcon;
	}

	public Date getReportdate() {
		return reportdate;
	}

	public void setReportdate(Date reportdate) {
		this.reportdate = reportdate;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	
	
}
