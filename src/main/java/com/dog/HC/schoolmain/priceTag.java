package com.dog.HC.schoolmain;

public class priceTag {
	private int p_no;
	private int p_da_no;
	private String p_Dogkind;
	private int p_price;
	private int p_date;
	
	public priceTag() {
		// TODO Auto-generated constructor stub
	}

	public priceTag(int p_no, int p_da_no, int p_price, String p_Dogkind, int p_date) {
		super();
		this.p_no = p_no;
		this.p_da_no = p_da_no;
		this.p_price = p_price;
		this.p_Dogkind = p_Dogkind;
		this.p_date = p_date;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public int getP_da_no() {
		return p_da_no;
	}

	public void setP_da_no(int p_da_no) {
		this.p_da_no = p_da_no;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getP_Dogkind() {
		return p_Dogkind;
	}

	public void setP_Dogkind(String p_Dogkind) {
		this.p_Dogkind = p_Dogkind;
	}

	public int getP_date() {
		return p_date;
	}

	public void setP_date(int p_date) {
		this.p_date = p_date;
	}

	
	
	
}
