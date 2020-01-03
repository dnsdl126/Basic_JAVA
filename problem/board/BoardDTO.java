package problem.board;

import java.sql.Date;

public class BoardDTO {
	// 1.변수 (DB Table 참조)
	private int bno; 
	private String title; 
	private String content; 
	private String writer; 
	private Date regdate; 
	private int viewcnt;
	public BoardDTO(int bno, String title, String content, String writer, Date regdate, int viewcnt) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.viewcnt = viewcnt;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	@Override
	public String toString() {
		return bno + "\t" + title + "\t" + content + "\t" + writer
				+ "\t" + regdate + "\t" + viewcnt + "\n";
	}
	public BoardDTO(String title, String content, String writer) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}
	public BoardDTO(int bno, String title, String content, String writer) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	
}

