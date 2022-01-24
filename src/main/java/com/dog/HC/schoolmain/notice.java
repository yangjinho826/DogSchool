package com.dog.HC.schoolmain;

import java.util.Date;

public class notice {
	private int n_no;
	private int n_da_no;
	private String n_id;
	private String n_title;
	private String n_txt;
	private Date n_date;
	
	
	public notice() {
		// TODO Auto-generated constructor stub
	}


	public notice(int n_no, int n_da_no, String n_id, String n_title, String n_txt, Date n_date) {
		super();
		this.n_no = n_no;
		this.n_da_no = n_da_no;
		this.n_id = n_id;
		this.n_title = n_title;
		this.n_txt = n_txt;
		this.n_date = n_date;
	}


	public int getN_no() {
		return n_no;
	}


	public void setN_no(int n_no) {
		this.n_no = n_no;
	}


	public int getN_da_no() {
		return n_da_no;
	}


	public void setN_da_no(int n_da_no) {
		this.n_da_no = n_da_no;
	}


	public String getN_id() {
		return n_id;
	}


	public void setN_id(String n_id) {
		this.n_id = n_id;
	}


	public String getN_title() {
		return n_title;
	}


	public void setN_title(String n_title) {
		this.n_title = n_title;
	}


	public String getN_txt() {
		return n_txt;
	}


	public void setN_txt(String n_txt) {
		this.n_txt = n_txt;
	}


	public Date getN_date() {
		return n_date;
	}


	public void setN_date(Date n_date) {
		this.n_date = n_date;
	}
	
	
	
}
