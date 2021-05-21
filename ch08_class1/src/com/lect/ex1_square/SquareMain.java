package com.lect.ex1_square;

public class SquareMain {
	public static void main(String[] args) {
		Square s1=new Square();
		System.out.println(s1.getside());
		Square s2=new Square(10);
		System.out.println(s2.getside());
		s1.setSide(5);
		s2.setSide(9);
		System.out.println(s1.area());
		System.out.println(s2.area());
	}
}
