package minjae.dto;

public class UserLevel {
	
	private int gradeno;
	private String gradename;
	private String gradegrant;
	
	public UserLevel() {}

	public UserLevel(int gradeno, String gradename, String gradegrant) {
		super();
		this.gradeno = gradeno;
		this.gradename = gradename;
		this.gradegrant = gradegrant;
	}

	@Override
	public String toString() {
		return "UserLevel [gradeno=" + gradeno + ", gradename=" + gradename + ", gradegrant=" + gradegrant + "]";
	}

	public int getGradeno() {
		return gradeno;
	}

	public void setGradeno(int gradeno) {
		this.gradeno = gradeno;
	}

	public String getGradename() {
		return gradename;
	}

	public void setGradename(String gradename) {
		this.gradename = gradename;
	}

	public String getGradegrant() {
		return gradegrant;
	}

	public void setGradegrant(String gradegrant) {
		this.gradegrant = gradegrant;
	}
	
}
