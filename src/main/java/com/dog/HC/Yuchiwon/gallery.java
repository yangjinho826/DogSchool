package com.dog.HC.Yuchiwon;

import java.sql.Date;
import java.util.List;

public class gallery {
	private int g_no;
	private String g_title;
	private String g_img;
	private int g_da_no;
	private String g_tid;
	private int g_tnum;
	private String g_uid;
	private String g_uname;
	private Date g_date;
	
	private String[] filess;
	
	public gallery() {
		// TODO Auto-generated constructor stub
	}

	public gallery(int g_no, String g_title, String g_img, int g_da_no, String g_tid, int g_tnum, String g_uid,
			String g_uname, Date g_date, String[] filess) {
		super();
		this.g_no = g_no;
		this.g_title = g_title;
		this.g_img = g_img;
		this.g_da_no = g_da_no;
		this.g_tid = g_tid;
		this.g_tnum = g_tnum;
		this.g_uid = g_uid;
		this.g_uname = g_uname;
		this.g_date = g_date;
		this.filess = filess;
	}

	public int getG_no() {
		return g_no;
	}

	public void setG_no(int g_no) {
		this.g_no = g_no;
	}

	public String getG_title() {
		return g_title;
	}

	public void setG_title(String g_title) {
		this.g_title = g_title;
	}

	public String getG_img() {
		return g_img;
	}

	public void setG_img(String g_img) {
		this.g_img = g_img;
	}

	public int getG_da_no() {
		return g_da_no;
	}

	public void setG_da_no(int g_da_no) {
		this.g_da_no = g_da_no;
	}

	public String getG_tid() {
		return g_tid;
	}

	public void setG_tid(String g_tid) {
		this.g_tid = g_tid;
	}

	public int getG_tnum() {
		return g_tnum;
	}

	public void setG_tnum(int g_tnum) {
		this.g_tnum = g_tnum;
	}

	public String getG_uid() {
		return g_uid;
	}

	public void setG_uid(String g_uid) {
		this.g_uid = g_uid;
	}

	public String getG_uname() {
		return g_uname;
	}

	public void setG_uname(String g_uname) {
		this.g_uname = g_uname;
	}

	public Date getG_date() {
		return g_date;
	}

	public void setG_date(Date g_date) {
		this.g_date = g_date;
	}

	public String[] getFiless() {
		return filess;
	}

	public void setFiless(String[] filess) {
		this.filess = filess;
	}

	


	
}
