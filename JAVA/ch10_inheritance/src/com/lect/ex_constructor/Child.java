package com.lect.ex_constructor;
// main�Լ����� Child child = new Child(1,2);
public class Child extends SuperIJ{
	private int total;
	public Child() {
		System.out.println("�Ű����� ���� Child ������ �Լ�");
	}
	public Child(int i, int j) {
//		this.i=i;     i�� private�̶� ��ӹ޾Ƶ� ���� ������. i�� protected�� ����(protected�� ��ӹ��� Ŭ���������� ��밡��)
		setI(i);setJ(j);
		System.out.println("�Ű����� �ִ� Child ������ �Լ�");
	}
	public void sum() {
		total=getI()+getJ();
		System.out.println("�� ��ü�� total���� "+total);
				
	}
}
