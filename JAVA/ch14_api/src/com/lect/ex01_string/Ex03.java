package com.lect.ex01_string;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�ֹι�ȣ �Է�: ");
		String num=sc.next();
		if(num.charAt(7)=='1') {
			System.out.println("��");
		}else {
			System.out.println("��");
		}
		sc.close();
	}
}
