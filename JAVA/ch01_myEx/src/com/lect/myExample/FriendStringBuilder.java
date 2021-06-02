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
		return String.format("�� �� : %s\n�ڵ��� : %s\n�� �� : %s",name,phone,birthday);
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
