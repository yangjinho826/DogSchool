package com.dog.HC.apply;

public class ApplyPet {
	private int Ua_no, Ua_da_no;
	private String Ua_id, Ua_name, Ua_gender, Ua_daterange;
	private int Ua_age;
	private String Ua_img, Ua_tname;
	private int Ua_agree;
	public ApplyPet() { }
	public ApplyPet(int ua_no, int ua_da_no, String ua_id, String ua_name, String ua_gender, String ua_daterange,
			int ua_age, String ua_img, String ua_tname, int ua_agree) {
		super();
		Ua_no = ua_no;
		Ua_da_no = ua_da_no;
		Ua_id = ua_id;
		Ua_name = ua_name;
		Ua_gender = ua_gender;
		Ua_daterange = ua_daterange;
		Ua_age = ua_age;
		Ua_img = ua_img;
		Ua_tname = ua_tname;
		Ua_agree = ua_agree;
	}
	public int getUa_no() {
		return Ua_no;
	}
	public void setUa_no(int ua_no) {
		Ua_no = ua_no;
	}
	public int getUa_da_no() {
		return Ua_da_no;
	}
	public void setUa_da_no(int ua_da_no) {
		Ua_da_no = ua_da_no;
	}
	public String getUa_id() {
		return Ua_id;
	}
	public void setUa_id(String ua_id) {
		Ua_id = ua_id;
	}
	public String getUa_name() {
		return Ua_name;
	}
	public void setUa_name(String ua_name) {
		Ua_name = ua_name;
	}
	public String getUa_gender() {
		return Ua_gender;
	}
	public void setUa_gender(String ua_gender) {
		Ua_gender = ua_gender;
	}
	public String getUa_daterange() {
		return Ua_daterange;
	}
	public void setUa_daterange(String ua_daterange) {
		Ua_daterange = ua_daterange;
	}
	public int getUa_age() {
		return Ua_age;
	}
	public void setUa_age(int ua_age) {
		Ua_age = ua_age;
	}
	public String getUa_img() {
		return Ua_img;
	}
	public void setUa_img(String ua_img) {
		Ua_img = ua_img;
	}
	public String getUa_tname() {
		return Ua_tname;
	}
	public void setUa_tname(String ua_tname) {
		Ua_tname = ua_tname;
	}
	public int getUa_agree() {
		return Ua_agree;
	}
	public void setUa_agree(int ua_agree) {
		Ua_agree = ua_agree;
	}
}
