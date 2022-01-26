package com.dog.HC.apply;

public class ApplySchool {
	private int Da_no;
	private String Da_id, Da_name, Da_schoolname, Da_addr, Da_phonenumber;
	private int Da_agree;
	public ApplySchool() { }
	public ApplySchool(int da_no, String da_id, String da_name, String da_schoolname, String da_addr,
			String da_phonenumber, int da_agree) {
		super();
		Da_no = da_no;
		Da_id = da_id;
		Da_name = da_name;
		Da_schoolname = da_schoolname;
		Da_addr = da_addr;
		Da_phonenumber = da_phonenumber;
		Da_agree = da_agree;
	}
	public int getDa_no() {
		return Da_no;
	}
	public void setDa_no(int da_no) {
		Da_no = da_no;
	}
	public String getDa_id() {
		return Da_id;
	}
	public void setDa_id(String da_id) {
		Da_id = da_id;
	}
	public String getDa_name() {
		return Da_name;
	}
	public void setDa_name(String da_name) {
		Da_name = da_name;
	}
	public String getDa_schoolname() {
		return Da_schoolname;
	}
	public void setDa_schoolname(String da_schoolname) {
		Da_schoolname = da_schoolname;
	}
	public String getDa_addr() {
		return Da_addr;
	}
	public void setDa_addr(String da_addr) {
		Da_addr = da_addr;
	}
	public String getDa_phonenumber() {
		return Da_phonenumber;
	}
	public void setDa_phonenumber(String da_phonenumber) {
		Da_phonenumber = da_phonenumber;
	}
	public int getDa_agree() {
		return Da_agree;
	}
	public void setDa_agree(int da_agree) {
		Da_agree = da_agree;
	}
}
