package minjae.dto;

import java.util.Date;

public class ProductFile {
	
	private int fileno;
	private int prodno;
	private String originname;
	private String storedname;
	private int filesize;
	private Date write_date;
	
	public ProductFile() {}

	public ProductFile(int fileno, int prodno, String originname, String storedname, int filesize, Date write_date) {
		super();
		this.fileno = fileno;
		this.prodno = prodno;
		this.originname = originname;
		this.storedname = storedname;
		this.filesize = filesize;
		this.write_date = write_date;
	}

	@Override
	public String toString() {
		return "ProductFile [fileno=" + fileno + ", prodno=" + prodno + ", originname=" + originname + ", storedname="
				+ storedname + ", filesize=" + filesize + ", write_date=" + write_date + "]";
	}

	public int getFileno() {
		return fileno;
	}

	public void setFileno(int fileno) {
		this.fileno = fileno;
	}

	public int getProdno() {
		return prodno;
	}

	public void setProdno(int prodno) {
		this.prodno = prodno;
	}

	public String getOriginname() {
		return originname;
	}

	public void setOriginname(String originname) {
		this.originname = originname;
	}

	public String getStoredname() {
		return storedname;
	}

	public void setStoredname(String storedname) {
		this.storedname = storedname;
	}

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public Date getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	
	
}
