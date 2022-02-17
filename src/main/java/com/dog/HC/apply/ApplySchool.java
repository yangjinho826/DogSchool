package com.dog.HC.apply;

public class ApplySchool {
	private int dA_no;
	private String dA_id, dA_name, dA_schoolname, dA_addr, dA_phonenumber;
	private int dA_agree;
	public ApplySchool() { }
	public ApplySchool(int dA_no, String dA_id, String dA_name, String dA_schoolname, String dA_addr,
			String dA_phonenumber, int dA_agree) {
		super();
		this.dA_no = dA_no;
		this.dA_id = dA_id;
		this.dA_name = dA_name;
		this.dA_schoolname = dA_schoolname;
		this.dA_addr = dA_addr;
		this.dA_phonenumber = dA_phonenumber;
		this.dA_agree = dA_agree;
	}
	public int getdA_no() {
		return dA_no;
	}
	public void setdA_no(int dA_no) {
		this.dA_no = dA_no;
	}
	public String getdA_id() {
		return dA_id;
	}
	public void setdA_id(String dA_id) {
		this.dA_id = dA_id;
	}
	public String getdA_name() {
		return dA_name;
	}
	public void setdA_name(String dA_name) {
		this.dA_name = dA_name;
	}
	public String getdA_schoolname() {
		return dA_schoolname;
	}
	public void setdA_schoolname(String dA_schoolname) {
		this.dA_schoolname = dA_schoolname;
	}
	public String getdA_addr() {
		return dA_addr;
	}
	public void setdA_addr(String dA_addr) {
		this.dA_addr = dA_addr;
	}
	public String getdA_phonenumber() {
		return dA_phonenumber;
	}
	public void setdA_phonenumber(String dA_phonenumber) {
		this.dA_phonenumber = dA_phonenumber;
	}
	public int getdA_agree() {
		return dA_agree;
	}
	public void setdA_agree(int dA_agree) {
		this.dA_agree = dA_agree;
	}
}
