package com.lect.ex01_string;

public class Ex07_string {
	public static void main(String[] args) {
		String str = "Hello~";
		System.out.println("str의 해쉬코드 : "+str.hashCode());
		str ="hello"; //str의 내용이 변경되면 다시 String 객체 생성
		System.out.println("str의 해쉬코드 : "+str.hashCode());
		String str1="hello";
		System.out.println("a의 해쉬코드 : "+str1.hashCode());
		System.out.println(str==str1?"같다.":"다르다.");
	}
}
