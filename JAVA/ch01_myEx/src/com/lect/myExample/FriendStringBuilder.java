package com.lect.myExample;

public class FriendStringBuilder {
	private StringBuilder name;
	private StringBuilder phone; 
	private StringBuilder birthday;
	public FriendStringBuilder() {};
	public FriendStringBuilder(StringBuilder name, StringBuilder phone, StringBuilder birthday) {
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return String.format("이 름 : %s\n핸드폰 : %s\n생 일 : %s",name,phone,birthday);
	}
	public StringBuilder getName() {
		return name;
	}
	public void setName(StringBuilder name) {
		this.name = name;
	}
	public StringBuilder getPhone() {
		return phone;
	}
	public void setPhone(StringBuilder phone) {
		this.phone = phone;
	}
	public StringBuilder getBirthday() {
		return birthday;
	}
	public void setBirthday(StringBuilder birthday) {
		this.birthday = birthday;
	}
	

	
	
}
