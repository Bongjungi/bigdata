package com.lect.ex2.swing;

public class Friend {
	private String name;
	private String tel;
	private int age;
	public Friend() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Friend(String name, String tel, int age) {
		super();
		this.name = name;
		this.tel = tel;
		this.age = age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+"\t"+tel+"\t"+age;
	}
}
