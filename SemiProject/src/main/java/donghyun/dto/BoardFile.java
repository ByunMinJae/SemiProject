package donghyun.dto;

import java.util.Date;

public class BoardFile {

	private int fileno;
	private int boardno;
	private String fileoriginname;
	private String filestoredname;
	private int filesize;
	private Date boarddate;
	
	public BoardFile() {}

	@Override
	public String toString() {
		return "BoardFile [fileno=" + fileno + ", boardno=" + boardno + ", fileoriginname=" + fileoriginname
				+ ", filestoredname=" + filestoredname + ", filesize=" + filesize + ", boarddate=" + boarddate + "]";
	}
	
	public int getFileno() {
		return fileno;
	}

	public void setFileno(int fileno) {
		this.fileno = fileno;
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public String getFileoriginname() {
		return fileoriginname;
	}

	public void setFileoriginname(String fileoriginname) {
		this.fileoriginname = fileoriginname;
	}

	public String getFilestoredname() {
		return filestoredname;
	}

	public void setFilestoredname(String filestoredname) {
		this.filestoredname = filestoredname;
	}

	public int getFilesize() {
		return filesize;
	}

	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}

	public Date getBoarddate() {
		return boarddate;
	}

	public void setBoarddate(Date boarddate) {
		this.boarddate = boarddate;
	}

	
	
}
