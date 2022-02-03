package com.dog.HC.Yuchiwon;

import java.sql.Date;

public class diaryReply {
	private int r_no;
	private int r_mp_no;
	private String r_owner;
	private String r_txt;
	private Date r_when;
	
	public diaryReply() {
		// TODO Auto-generated constructor stub
	}

	public diaryReply(int r_no, int r_mp_no, String r_owner, String r_txt, Date r_when) {
		super();
		this.r_no = r_no;
		this.r_mp_no = r_mp_no;
		this.r_owner = r_owner;
		this.r_txt = r_txt;
		this.r_when = r_when;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public int getR_mp_no() {
		return r_mp_no;
	}

	public void setR_mp_no(int r_mp_no) {
		this.r_mp_no = r_mp_no;
	}

	public String getR_owner() {
		return r_owner;
	}

	public void setR_owner(String r_owner) {
		this.r_owner = r_owner;
	}

	public String getR_txt() {
		return r_txt;
	}

	public void setR_txt(String r_txt) {
		this.r_txt = r_txt;
	}

	public Date getR_when() {
		return r_when;
	}

	public void setR_when(Date r_when) {
		this.r_when = r_when;
	}
	
}
