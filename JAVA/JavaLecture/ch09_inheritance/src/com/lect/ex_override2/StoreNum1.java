package com.lect.ex_override2;
//���ð� 1ȣ�� : �δ�� 5000�� ���뱹 ����.
public class StoreNum1 extends HeadQuarterStore {

	public StoreNum1(String name) {
		super(name);  //�̰� ���� �Ű��������»����ڰ� ��� ��� �����ϰ� �����ϴ�.
						//super() = HeadQuarterStore(), super. = HeadQuarterStore.
	}
	@Override
	public void budae() {
		System.out.println("�δ��:5000��");
	}
	@Override
	public void sundae() {
		System.out.println("���뱹:����");
	}
	
}
