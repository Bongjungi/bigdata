package com.lect.test_thisAndsuper;

public class Main2 {
	public static void main(String[] args) {
		Person2 a= new Staff2("가가가","나나나","다다다"); //person2에 가가가나나나 담았고, Staff2에 다다다 담았다.
		a.print(); //Staff2의 print이다.
		System.out.println(a.getId());
		System.out.println(a.getName());
	}
}
