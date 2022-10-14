package minjae.dto;

import java.util.Date;

public class UserFind {
	
	private int createno;
	private Date createdat;
	private String email;
	private String id;
	private String pw;
	private int authno;
	
	public UserFind() {}

	public UserFind(int createno, Date createdat, String email, String id, String pw, int authno) {
		super();
		this.createno = createno;
		this.createdat = createdat;
		this.email = email;
		this.id = id;
		this.pw = pw;
		this.authno = authno;
	}

	@Override
	public String toString() {
		return "UserFind [createno=" + createno + ", createdat=" + createdat + ", email=" + email + ", id=" + id
				+ ", pw=" + pw + ", authno=" + authno + "]";
	}

	public int getCreateno() {
		return createno;
	}

	public void setCreateno(int createno) {
		this.createno = createno;
	}

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getAuthno() {
		return authno;
	}

	public void setAuthno(int authno) {
		this.authno = authno;
	}
	
}
