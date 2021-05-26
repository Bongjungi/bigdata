package com.lect.ex4_product;

public class Product {
	private int serialNo; //객체 고유번호
	private String name;
	public static int count=100; //final 붙이면 고정.
	public Product(String name) {
		this.name=name;
		serialNo=++count;
	}
	public void infoPrint() {
		System.out.printf("이름: %s, 시리얼넘버: %d,공유변수count: %d\n",name,serialNo,count);
	}
}
