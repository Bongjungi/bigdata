package com.lect.ex01_string;

public class Ex01 {
	public static void main(String[] args) {
		String str1="java"; //최초의 java생성 -str1에 100을 넣고 100번지에 java를 넣는다.
		String str2="java"; //기존에 java가 있으면 해당 주소 저장 아니면 new String(java)
		String str3= new String("java");
		System.out.println(str1==str2?"1과 2는 같은 주소":"1과 2는 다른 주소");
		System.out.println(str2==str3?"2와 3은 같은 주소":"2와 3은 다른 주소");
		str1="java1";
		System.out.println(str1==str2?"1과 2는 같은 주소":"1과 2는 다른 주소");
		System.out.println(str2==str3?"2와 3은 같은 주소":"2와 3은 다른 주소");
		System.out.println(str2.equals(str3)?"같은스트링":"다른스트링");
			
		
	}
}
