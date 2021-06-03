package com.lect.ex_this;

public class Friend {
	private String name;
	private String tel;
	public Friend() {
		System.out.println("매개변수 없는 생성자 함수");
	}
	public Friend(String name) {
		this(); //Friend() - 생성자함수 호출
		this.setName(name);
		System.out.println("매개변수 하나짜리 생성자 함수");
	}
	public Friend(String name, String tel) {
		this(name); //Friend(name) 호출
		this.setName(name);
		this.setTel(tel);
		System.out.println("매개변수 있는 생성자 함수 초기화");
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
}
