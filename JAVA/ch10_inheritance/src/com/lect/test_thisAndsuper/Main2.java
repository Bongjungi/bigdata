package com.lect.test_thisAndsuper;

public class Main2 {
	public static void main(String[] args) {
		Person2 a= new Staff2("������","������","�ٴٴ�"); //person2�� ������������ ��Ұ�, Staff2�� �ٴٴ� ��Ҵ�.
		a.print(); //Staff2�� print�̴�.
		System.out.println(a.getId());
		System.out.println(a.getName());
	}
}
