package com.dog.HC.review;

import java.sql.Date;

public class review {
	private int r_no;
	private int r_da_no;
	private String r_id;
	private String r_title;
	private String r_txt;
	private Date r_date;
	
	public review() {
		// TODO Auto-generated constructor stub
	}

	public review(int r_no, int r_da_no, String r_id, String r_title, String r_txt, Date r_date) {
		super();
		this.r_no = r_no;
		this.r_da_no = r_da_no;
		this.r_id = r_id;
		this.r_title = r_title;
		this.r_txt = r_txt;
		this.r_date = r_date;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public int getR_da_no() {
		return r_da_no;
	}

	public void setR_da_no(int r_da_no) {
		this.r_da_no = r_da_no;
	}

	public String getR_id() {
		return r_id;
	}

	public void setR_id(String r_id) {
		this.r_id = r_id;
	}

	public String getR_title() {
		return r_title;
	}

	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	public String getR_txt() {
		return r_txt;
	}

	public void setR_txt(String r_txt) {
		this.r_txt = r_txt;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}
	
	
}
