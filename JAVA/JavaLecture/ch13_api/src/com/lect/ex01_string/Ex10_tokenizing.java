package com.lect.ex01_string;

import java.util.StringTokenizer;

public class Ex10_tokenizing {
	public static void main(String[] args) {
		String string1 = "퍼블릭 스태틱 보이드 메인 스트링 아르그스";
		String string2 = "컴/렉트/익스원/스트링";
		StringTokenizer token1 = new StringTokenizer(string1);//string1를 space구분자로 분할.
		StringTokenizer token2 = new StringTokenizer(string2, "/");
		System.out.println("token1의 갯수: "+token1.countTokens());
		System.out.println("token2의 갯수: "+token2.countTokens());
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
