package com.lect.ex01_string;

import java.util.StringTokenizer;

public class Ex11_string_array {
	public static void main(String[] args) {
		
	
		String string1 = "�ۺ� ����ƽ ���̵� ���� ��Ʈ�� �Ƹ��׽�";
		StringTokenizer token = new StringTokenizer(string1);
		String[] arr = new String[token.countTokens()];
		int idx=0;
		while(token.hasMoreTokens()) {
			arr[idx]=token.nextToken();
		}
	
	
	}
}
