package com.lect.ex01_store;
//���ð� 1ȣ�� : �δ�� 5000�� ���뱹 ����.
public class StoreNum1 extends HeadQuarterStore {

	public StoreNum1(String name) {
		super(name);  //�̰� ���� �Ű��������»����ڰ� ��� ��� �����ϰ� �����ϴ�. 
	}

	@Override
	public void kimchi() {
		System.out.println("��ġ� : 4500��");
		
	}

	@Override
	public void budae() {
		System.out.println("�δ�� : 5000��");
		
	}

	@Override
	public void bibim() {
		System.out.println("����� : 6000��");
		
	}

	@Override
	public void sundae() {
		System.out.println("���뱹 : �Ǹž���");
		
	}

	@Override
	public void gonggi() {
		System.out.println("����� : ����");
		
	}
	
}
