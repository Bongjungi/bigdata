package com.lect.ex01_string;

public class Ex01 {
	public static void main(String[] args) {
		String str1="java"; //������ java���� -str1�� 100�� �ְ� 100������ java�� �ִ´�.
		String str2="java"; //������ java�� ������ �ش� �ּ� ���� �ƴϸ� new String(java)
		String str3= new String("java");
		System.out.println(str1==str2?"1�� 2�� ���� �ּ�":"1�� 2�� �ٸ� �ּ�");
		System.out.println(str2==str3?"2�� 3�� ���� �ּ�":"2�� 3�� �ٸ� �ּ�");
		str1="java1";
		System.out.println(str1==str2?"1�� 2�� ���� �ּ�":"1�� 2�� �ٸ� �ּ�");
		System.out.println(str2==str3?"2�� 3�� ���� �ּ�":"2�� 3�� �ٸ� �ּ�");
		System.out.println(str2.equals(str3)?"������Ʈ��":"�ٸ���Ʈ��");
			
		
	}
}
