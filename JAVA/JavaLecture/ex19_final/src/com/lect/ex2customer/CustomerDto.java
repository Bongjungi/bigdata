package com.lect.ex2customer;

public class CustomerDto {
	private String phone, name;
	private int id, point;
	public CustomerDto(int id, String phone, String name, int point) {
		this.id = id;
		this.phone = phone;
		this.name = name;
		this.point = point;
	}
	@Override
	public String toString() {
		
		return String.format("%d\t%s\t%s\t%d",id, phone,name,point);
	}
	
	public int getId() {
		return id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
}
