package com.dog.HC.schoolmain;

import java.sql.Date;

public class postscript {
	private int p_no;
	private int p_da_no;
	private String p_id;
	private String p_title;
	private String p_txt;
	private Date p_date;
	private int from;
	private int to;
	
	public postscript() {
		// TODO Auto-generated constructor stub
	}

	public postscript(int p_no, int p_da_no, String p_id, String p_title, String p_txt, Date p_date, int from, int to) {
		super();
		this.p_no = p_no;
		this.p_da_no = p_da_no;
		this.p_id = p_id;
		this.p_title = p_title;
		this.p_txt = p_txt;
		this.p_date = p_date;
		this.from = from;
		this.to = to;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public int getP_da_no() {
		return p_da_no;
	}

	public void setP_da_no(int p_da_no) {
		this.p_da_no = p_da_no;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public String getP_txt() {
		return p_txt;
	}

	public void setP_txt(String p_txt) {
		this.p_txt = p_txt;
	}

	public Date getP_date() {
		return p_date;
	}

	public void setP_date(Date p_date) {
		this.p_date = p_date;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}
	
}
