package com.lect.ex_this;

public class Friend {
	private String name;
	private String tel;
	public Friend() {
		System.out.println("�Ű����� ���� ������ �Լ�");
	}
	public Friend(String name) {
		this(); //Friend() - �������Լ� ȣ��
		this.setName(name);
		System.out.println("�Ű����� �ϳ�¥�� ������ �Լ�");
	}
	public Friend(String name, String tel) {
		this(name); //Friend(name) ȣ��
		this.setName(name);
		this.setTel(tel);
		System.out.println("�Ű����� �ִ� ������ �Լ� �ʱ�ȭ");
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
