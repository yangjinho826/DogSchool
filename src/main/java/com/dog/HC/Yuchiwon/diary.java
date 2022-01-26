package com.dog.HC.Yuchiwon;

import java.sql.Date;

public class diary {
	private int mp_no;
	private String mp_title;
	private String mp_condition;
	private int mp_meal;
	private int mp_defecate;
	private String mp_supplies;
	private String mp_txt;
	private int mp_da_no;
	private String mp_tid;
	private String mp_uid;
	private String mp_uname;
	private Date mp_date;
	
	public diary() {
		// TODO Auto-generated constructor stub
	}

	public diary(int mp_no, String mp_title, String mp_condition, int mp_meal, int mp_defecate, String mp_supplies,
			String mp_txt, int mp_da_no, String mp_tid, String mp_uid, String mp_uname, Date mp_date) {
		super();
		this.mp_no = mp_no;
		this.mp_title = mp_title;
		this.mp_condition = mp_condition;
		this.mp_meal = mp_meal;
		this.mp_defecate = mp_defecate;
		this.mp_supplies = mp_supplies;
		this.mp_txt = mp_txt;
		this.mp_da_no = mp_da_no;
		this.mp_tid = mp_tid;
		this.mp_uid = mp_uid;
		this.mp_uname = mp_uname;
		this.mp_date = mp_date;
	}

	public int getMp_no() {
		return mp_no;
	}

	public void setMp_no(int mp_no) {
		this.mp_no = mp_no;
	}

	public String getMp_title() {
		return mp_title;
	}

	public void setMp_title(String mp_title) {
		this.mp_title = mp_title;
	}

	public String getMp_condition() {
		return mp_condition;
	}

	public void setMp_condition(String mp_condition) {
		this.mp_condition = mp_condition;
	}

	public int getMp_meal() {
		return mp_meal;
	}

	public void setMp_meal(int mp_meal) {
		this.mp_meal = mp_meal;
	}

	public int getMp_defecate() {
		return mp_defecate;
	}

	public void setMp_defecate(int mp_defecate) {
		this.mp_defecate = mp_defecate;
	}

	public String getMp_supplies() {
		return mp_supplies;
	}

	public void setMp_supplies(String mp_supplies) {
		this.mp_supplies = mp_supplies;
	}

	public String getMp_txt() {
		return mp_txt;
	}

	public void setMp_txt(String mp_txt) {
		this.mp_txt = mp_txt;
	}

	public int getMp_da_no() {
		return mp_da_no;
	}

	public void setMp_da_no(int mp_da_no) {
		this.mp_da_no = mp_da_no;
	}

	public String getMp_tid() {
		return mp_tid;
	}

	public void setMp_tid(String mp_tid) {
		this.mp_tid = mp_tid;
	}

	public String getMp_uid() {
		return mp_uid;
	}

	public void setMp_uid(String mp_uid) {
		this.mp_uid = mp_uid;
	}

	public String getMp_uname() {
		return mp_uname;
	}

	public void setMp_uname(String mp_uname) {
		this.mp_uname = mp_uname;
	}

	public Date getMp_date() {
		return mp_date;
	}

	public void setMp_date(Date mp_date) {
		this.mp_date = mp_date;
	}

}
