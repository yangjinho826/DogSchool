package com.dog.HC.apply;

public class ApplyTeacher {
	private int tA_no, tA_da_no;
	private String tA_id, tA_name, tA_phonenumber, tA_gender, tA_text;
	private int tA_agree;
	public ApplyTeacher() { }
	public ApplyTeacher(int tA_no, int tA_da_no, String tA_id, String tA_name, String tA_phonenumber, String tA_gender,
			String tA_text, int tA_agree) {
		super();
		this.tA_no = tA_no;
		this.tA_da_no = tA_da_no;
		this.tA_id = tA_id;
		this.tA_name = tA_name;
		this.tA_phonenumber = tA_phonenumber;
		this.tA_gender = tA_gender;
		this.tA_text = tA_text;
		this.tA_agree = tA_agree;
	}
	public int gettA_no() {
		return tA_no;
	}
	public void settA_no(int tA_no) {
		this.tA_no = tA_no;
	}
	public int gettA_da_no() {
		return tA_da_no;
	}
	public void settA_da_no(int tA_da_no) {
		this.tA_da_no = tA_da_no;
	}
	public String gettA_id() {
		return tA_id;
	}
	public void settA_id(String tA_id) {
		this.tA_id = tA_id;
	}
	public String gettA_name() {
		return tA_name;
	}
	public void settA_name(String tA_name) {
		this.tA_name = tA_name;
	}
	public String gettA_phonenumber() {
		return tA_phonenumber;
	}
	public void settA_phonenumber(String tA_phonenumber) {
		this.tA_phonenumber = tA_phonenumber;
	}
	public String gettA_gender() {
		return tA_gender;
	}
	public void settA_gender(String tA_gender) {
		this.tA_gender = tA_gender;
	}
	public String gettA_text() {
		return tA_text;
	}
	public void settA_text(String tA_text) {
		this.tA_text = tA_text;
	}
	public int gettA_agree() {
		return tA_agree;
	}
	public void settA_agree(int tA_agree) {
		this.tA_agree = tA_agree;
	}
}
