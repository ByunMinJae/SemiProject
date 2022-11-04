package minjae.dto;

import java.util.Date;

public class UserInfo {
	
	private int userno;
	private String userid;
	private String userpw;
	private String username;
	private String gender;
	private String address;
	private String phone;
	private Date birth;
	private String email;
	private String nick;
	private Date joinday;
	private Date userupdate;
	private int gradeno;
	
	public UserInfo() {}

	public UserInfo(int userno, String userid, String userpw, String username, String gender, String address,
			String phone, Date birth, String email, String nick, Date joinday, Date userupdate, int gradeno) {
		super();
		this.userno = userno;
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.birth = birth;
		this.email = email;
		this.nick = nick;
		this.joinday = joinday;
		this.userupdate = userupdate;
		this.gradeno = gradeno;
	}

	@Override
	public String toString() {
		return "UserInfo [userno=" + userno + ", userid=" + userid + ", userpw=" + userpw + ", username=" + username
				+ ", gender=" + gender + ", address=" + address + ", phone=" + phone + ", birth=" + birth + ", email="
				+ email + ", nick=" + nick + ", joinday=" + joinday + ", userupdate=" + userupdate + ", gradeno="
				+ gradeno + "]";
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Date getJoinday() {
		return joinday;
	}

	public void setJoinday(Date joinday) {
		this.joinday = joinday;
	}

	public Date getUserupdate() {
		return userupdate;
	}

	public void setUserupdate(Date userupdate) {
		this.userupdate = userupdate;
	}

	public int getGradeno() {
		return gradeno;
	}

	public void setGradeno(int gradeno) {
		this.gradeno = gradeno;
	}
	
}
