package com.lect.ex_override2;
// override - ����
// overload - ���������� ���� �ߺ����
public class HeadQuarterStore {
	private String name;
	public HeadQuarterStore(String name) {
		this.name=name;
	}
	public void kimchi() {
		System.out.println("��ġ�:5000��");
	}
	public void budae() {
		System.out.println("�δ��:6000��");
	}
	public void bibim() {
		System.out.println("�����:6000��");
	}
	public void sundae() {
		System.out.println("���뱹:5000��");
	}
	public void gonggi() {
		System.out.println("�����:1000��");
	}
	public String getName() {
		return name;
	}
	
}
