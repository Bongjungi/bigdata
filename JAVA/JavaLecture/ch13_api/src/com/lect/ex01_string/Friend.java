package com.lect.ex01_string;

public class Friend {
	private String name;
	private String phone; 
	private String birthday;
	
	public Friend() {}
	public Friend(String name, String phone, String birthday) {
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return String.format("이 름 : %s\n핸드폰 : %s\n생 일 : %s",name,phone,birthday);
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getBirthday() {
		return birthday;
	}
	
}
