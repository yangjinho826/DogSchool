package com.dog.HC.Yuchiwon;

import java.sql.Date;

public class puppy {
	private int uA_no;
	private int uA_da_no;
	private String uA_id;
	private String uA_name;
	private String uA_gender;
	private Date uA_start;
	private Date uA_end;
	private int uA_age;
	private String uA_img;
	private int uA_ta_no;
	private int uA_agree;
	private String uA_daterange;
	
	public puppy() {
		// TODO Auto-generated constructor stub
	}

	public puppy(int uA_no, int uA_da_no, String uA_id, String uA_name, String uA_gender, Date uA_start, Date uA_end,
			int uA_age, String uA_img, int uA_ta_no, int uA_agree, String uA_daterange) {
		super();
		this.uA_no = uA_no;
		this.uA_da_no = uA_da_no;
		this.uA_id = uA_id;
		this.uA_name = uA_name;
		this.uA_gender = uA_gender;
		this.uA_start = uA_start;
		this.uA_end = uA_end;
		this.uA_age = uA_age;
		this.uA_img = uA_img;
		this.uA_ta_no = uA_ta_no;
		this.uA_agree = uA_agree;
		this.uA_daterange = uA_daterange;
	}

	public int getuA_no() {
		return uA_no;
	}

	public void setuA_no(int uA_no) {
		this.uA_no = uA_no;
	}

	public int getuA_da_no() {
		return uA_da_no;
	}

	public void setuA_da_no(int uA_da_no) {
		this.uA_da_no = uA_da_no;
	}

	public String getuA_id() {
		return uA_id;
	}

	public void setuA_id(String uA_id) {
		this.uA_id = uA_id;
	}

	public String getuA_name() {
		return uA_name;
	}

	public void setuA_name(String uA_name) {
		this.uA_name = uA_name;
	}

	public String getuA_gender() {
		return uA_gender;
	}

	public void setuA_gender(String uA_gender) {
		this.uA_gender = uA_gender;
	}

	public Date getuA_start() {
		return uA_start;
	}

	public void setuA_start(Date uA_start) {
		this.uA_start = uA_start;
	}

	public Date getuA_end() {
		return uA_end;
	}

	public void setuA_end(Date uA_end) {
		this.uA_end = uA_end;
	}

	public int getuA_age() {
		return uA_age;
	}

	public void setuA_age(int uA_age) {
		this.uA_age = uA_age;
	}

	public String getuA_img() {
		return uA_img;
	}

	public void setuA_img(String uA_img) {
		this.uA_img = uA_img;
	}

	public int getuA_ta_no() {
		return uA_ta_no;
	}

	public void setuA_ta_no(int uA_ta_no) {
		this.uA_ta_no = uA_ta_no;
	}

	public int getuA_agree() {
		return uA_agree;
	}

	public void setuA_agree(int uA_agree) {
		this.uA_agree = uA_agree;
	}
	
	public String getuA_daterange() {
		return uA_daterange;
	}
	
	public void setuA_daterange(String uA_daterange) {
		this.uA_daterange = uA_daterange;
	}

}
