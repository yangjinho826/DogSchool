package com.dog.HC.apply;

public class ApplyPet {
	private int uA_no, uA_da_no;
	private String uA_id, uA_name, uA_gender, uA_daterange;
	private int uA_age;
	private String uA_img, uA_tname;
	private int uA_agree;
	
	public ApplyPet() {
		// TODO Auto-generated constructor stub
	}

	public ApplyPet(int uA_no, int uA_da_no, String uA_id, String uA_name, String uA_gender, String uA_daterange,
			int uA_age, String uA_img, String uA_tname, int uA_agree) {
		super();
		this.uA_no = uA_no;
		this.uA_da_no = uA_da_no;
		this.uA_id = uA_id;
		this.uA_name = uA_name;
		this.uA_gender = uA_gender;
		this.uA_daterange = uA_daterange;
		this.uA_age = uA_age;
		this.uA_img = uA_img;
		this.uA_tname = uA_tname;
		this.uA_agree = uA_agree;
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

	public String getuA_daterange() {
		return uA_daterange;
	}

	public void setuA_daterange(String uA_daterange) {
		this.uA_daterange = uA_daterange;
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

	public String getuA_tname() {
		return uA_tname;
	}

	public void setuA_tname(String uA_tname) {
		this.uA_tname = uA_tname;
	}

	public int getuA_agree() {
		return uA_agree;
	}

	public void setuA_agree(int uA_agree) {
		this.uA_agree = uA_agree;
	}
	
}
