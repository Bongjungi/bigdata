package com.lect.ex3_nullpointerexception;

public class Friend {
	private String name;
	private String tel;
	public Friend() {}
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	@Override
	public String toString() {
		String post = tel.substring(tel.lastIndexOf('-')+1);
		return name+"-***-****-"+post;
	}
	
}
