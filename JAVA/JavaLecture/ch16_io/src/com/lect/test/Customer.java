package com.lect.test;


public class Customer {
	private String name;
	private String tel;
	private String birthday;
	private String address;
	private static Customer INSTANCE;
	public static Customer getInstance() {
		if(INSTANCE==null) { 
			INSTANCE=new Customer(); 
		}
		return INSTANCE;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		
		return String.format("%s %s %s»ý %s",name,tel,birthday,address);
	}
	
}
