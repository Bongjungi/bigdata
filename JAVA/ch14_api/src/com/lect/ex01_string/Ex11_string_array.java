package com.lect.ex01_string;

import java.util.StringTokenizer;

public class Ex11_string_array {
	public static void main(String[] args) {
		
	
		String string1 = "퍼블릭 스태틱 보이드 메인 스트링 아르그스";
		StringTokenizer token = new StringTokenizer(string1);
		String[] arr = new String[token.countTokens()];
		int idx=0;
		while(token.hasMoreTokens()) {
			arr[idx]=token.nextToken();
		}
	
	
	}
}
