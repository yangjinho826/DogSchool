package com.dog.HC.manage;

public class ManageSearch {
	private String searchFiled;  //검색 조건
    private String searchValue;  //검색어
    public ManageSearch() { }
	public ManageSearch(String searchFiled, String searchValue) {
		super();
		this.searchFiled = searchFiled;
		this.searchValue = searchValue;
	}
	public String getSearchFiled() {
		return searchFiled;
	}
	public void setSearchFiled(String searchFiled) {
		this.searchFiled = searchFiled;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
}
