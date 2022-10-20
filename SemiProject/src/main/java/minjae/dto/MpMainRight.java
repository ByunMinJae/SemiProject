package minjae.dto;

public class MpMainRight {
	
	private int userno;
	private int delCnt;
	private int delComCnt;
	private int exchanCnt;
	
	public MpMainRight() {}

	public MpMainRight(int userno, int delCnt, int delComCnt, int exchanCnt) {
		super();
		this.userno = userno;
		this.delCnt = delCnt;
		this.delComCnt = delComCnt;
		this.exchanCnt = exchanCnt;
	}

	@Override
	public String toString() {
		return "MpMainRight [userno=" + userno + ", delCnt=" + delCnt + ", delComCnt=" + delComCnt + ", exchanCnt="
				+ exchanCnt + "]";
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public int getDelCnt() {
		return delCnt;
	}

	public void setDelCnt(int delCnt) {
		this.delCnt = delCnt;
	}

	public int getDelComCnt() {
		return delComCnt;
	}

	public void setDelComCnt(int delComCnt) {
		this.delComCnt = delComCnt;
	}

	public int getExchanCnt() {
		return exchanCnt;
	}

	public void setExchanCnt(int exchanCnt) {
		this.exchanCnt = exchanCnt;
	}
	
}
