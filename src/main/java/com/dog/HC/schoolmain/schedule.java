package com.dog.HC.schoolmain;

import java.sql.Date;

public class schedule {
	private int s_no;
	private int s_da_no;
	private int s_month;
	private String s_text;
	private Date s_day;
	
	public schedule() {
		// TODO Auto-generated constructor stub
	}

	public schedule(int s_no, int s_da_no, int s_month, String s_text, Date s_day) {
		super();
		this.s_no = s_no;
		this.s_da_no = s_da_no;
		this.s_month = s_month;
		this.s_text = s_text;
		this.s_day = s_day;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public int getS_da_no() {
		return s_da_no;
	}

	public void setS_da_no(int s_da_no) {
		this.s_da_no = s_da_no;
	}

	public int getS_month() {
		return s_month;
	}

	public void setS_month(int s_month) {
		this.s_month = s_month;
	}

	public String getS_text() {
		return s_text;
	}

	public void setS_text(String s_text) {
		this.s_text = s_text;
	}

	public Date getS_day() {
		return s_day;
	}

	public void setS_day(Date s_day) {
		this.s_day = s_day;
	}
	
	
	
	
}

