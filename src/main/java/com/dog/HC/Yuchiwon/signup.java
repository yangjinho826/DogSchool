package com.dog.HC.Yuchiwon;

public class signup {

	private String id;
	private String pw;
	private String name;
	private String phonenumber;
	private String gender;
	private int typee;
	
	public signup() {
		// TODO Auto-generated constructor stub
	}

	public signup(String id, String pw, String name, String phonenumber, String gender, int typee) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phonenumber = phonenumber;
		this.gender = gender;
		this.typee = typee;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getTypee() {
		return typee;
	}

	public void setTypee(int typee) {
		this.typee = typee;
	}
	
}
