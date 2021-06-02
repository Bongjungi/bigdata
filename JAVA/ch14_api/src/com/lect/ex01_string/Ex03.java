package com.lect.ex01_string;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("주민번호 입력: ");
		String num=sc.next();
		if(num.charAt(7)=='1') {
			System.out.println("남");
		}else {
			System.out.println("여");
		}
		sc.close();
	}
}
