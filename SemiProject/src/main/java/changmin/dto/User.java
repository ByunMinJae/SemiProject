package changmin.dto;

public class User {

	private int userno;
	private String username;
	private String address;
	private String phone;
	private String email;
	
	public User() {
	}

	@Override
	public String toString() {
		return "User [userno=" + userno + ", username=" + username + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + "]";
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(int userno, String username, String address, String phone, String email) {
		super();
		this.userno = userno;
		this.username = username;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	
	
}
