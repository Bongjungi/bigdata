package com.lect.ex01_string;

import java.util.StringTokenizer;

public class Ex10_tokenizing {
	public static void main(String[] args) {
		String string1 = "�ۺ� ����ƽ ���̵� ���� ��Ʈ�� �Ƹ��׽�";
		String string2 = "��/��Ʈ/�ͽ���/��Ʈ��";
		StringTokenizer token1 = new StringTokenizer(string1);//string1�� space�����ڷ� ����.
		StringTokenizer token2 = new StringTokenizer(string2, "/");
		System.out.println("token1�� ����: "+token1.countTokens());
		System.out.println("token2�� ����: "+token2.countTokens());
		while(token1.hasMoreTokens()) {
			System.out.println(token1.nextToken());
		}
		System.out.println(token1.countTokens());
		while(token2.hasMoreTokens()) {
			System.out.println(token2.nextToken());
		}
		System.out.println(token2.countTokens());
	}
}
