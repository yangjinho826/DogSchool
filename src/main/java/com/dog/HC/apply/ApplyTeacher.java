package com.dog.HC.apply;

import java.math.BigDecimal;

public class ApplyTeacher {
	private int Ta_no, Ta_da_no;
	private String Ta_id, Ta_name, Ta_phonenumber, Ta_gender, Ta_text;
	private int Ta_agree;
	public ApplyTeacher() { }
	public ApplyTeacher(int ta_no, int ta_da_no, String ta_id, String ta_name, String ta_phonenumber,
			String ta_gender, String ta_text, int ta_agree) {
		super();
		Ta_no = ta_no;
		Ta_da_no = ta_da_no;
		Ta_id = ta_id;
		Ta_name = ta_name;
		Ta_phonenumber = ta_phonenumber;
		Ta_gender = ta_gender;
		Ta_text = ta_text;
		Ta_agree = ta_agree;
	}
	public int getTa_no() {
		return Ta_no;
	}
	public void setTa_no(int ta_no) {
		Ta_no = ta_no;
	}
	public int getTa_da_no() {
		return Ta_da_no;
	}
	public void setTa_da_no(int ta_da_no) {
		Ta_da_no = ta_da_no;
	}
	public String getTa_id() {
		return Ta_id;
	}
	public void setTa_id(String ta_id) {
		Ta_id = ta_id;
	}
	public String getTa_name() {
		return Ta_name;
	}
	public void setTa_name(String ta_name) {
		Ta_name = ta_name;
	}
	public String getTa_phonenumber() {
		return Ta_phonenumber;
	}
	public void setTa_phonenumber(String ta_phonenumber) {
		Ta_phonenumber = ta_phonenumber;
	}
	public String getTa_gender() {
		return Ta_gender;
	}
	public void setTa_gender(String ta_gender) {
		Ta_gender = ta_gender;
	}
	public String getTa_text() {
		return Ta_text;
	}
	public void setTa_text(String ta_text) {
		Ta_text = ta_text;
	}
	public int getTa_agree() {
		return Ta_agree;
	}
	public void setTa_agree(int ta_agree) {
		Ta_agree = ta_agree;
	}
}
