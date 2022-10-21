package daun.dto;

import java.util.Date;

public class Board {

	private int boardno;
	private String boardtitle;
	private String boardcon;
	private Date boarddate;
	private int userno;
	private int categoryno;
	private int hit;
	
	
	public Board() {}

	public Board(int boardno, String boardtitle, String boardcon, Date boarddate, int userno, int categoryno, int hit) {
		super();
		this.boardno = boardno;
		this.boardtitle = boardtitle;
		this.boardcon = boardcon;
		this.boarddate = boarddate;
		this.userno = userno;
		this.categoryno = categoryno;
		this.hit = hit;
	}


	@Override
	public String toString() {
		return "Board [boardno=" + boardno + ", boardtitle=" + boardtitle + ", boardcon=" + boardcon + ", boarddate="
				+ boarddate + ", userno=" + userno + ", categoryno=" + categoryno + ", hit=" + hit + "]";
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public String getBoardtitle() {
		return boardtitle;
	}

	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}

	public String getBoardcon() {
		return boardcon;
	}

	public void setBoardcon(String boardcon) {
		this.boardcon = boardcon;
	}

	public Date getBoarddate() {
		return boarddate;
	}

	public void setBoarddate(Date boarddate) {
		this.boarddate = boarddate;
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public int getCategoryno() {
		return categoryno;
	}

	public void setCategoryno(int categoryno) {
		this.categoryno = categoryno;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	
	
	
	
}
