package com.lect.ex4_product;

public class Product {
	private int serialNo; //��ü ������ȣ
	private String name;
	public static int count=100; //final ���̸� ����.
	public Product(String name) {
		this.name=name;
		serialNo=++count;
	}
	public void infoPrint() {
		System.out.printf("�̸�: %s, �ø���ѹ�: %d,��������count: %d\n",name,serialNo,count);
	}
}
