package com.lect.ex01_string;

public class Ex07_string {
	public static void main(String[] args) {
		String str = "Hello~";
		System.out.println("str�� �ؽ��ڵ� : "+str.hashCode());
		str ="hello"; //str�� ������ ����Ǹ� �ٽ� String ��ü ����
		System.out.println("str�� �ؽ��ڵ� : "+str.hashCode());
		String str1="hello";
		System.out.println("a�� �ؽ��ڵ� : "+str1.hashCode());
		System.out.println(str==str1?"����.":"�ٸ���.");
	}
}
