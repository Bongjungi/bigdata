package com.lect.ex3_momChild;

public class Bmoney {
	private String name;
	private int money;
	static Amoney amoney=new Amoney();
	
	public Bmoney(String name) {
		this.setName(name);
		
	}
	public void takeMoney(int money) {
		amoney.money-=money;
		this.money+=money;
		}
	public int getMoney() {
		return money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
