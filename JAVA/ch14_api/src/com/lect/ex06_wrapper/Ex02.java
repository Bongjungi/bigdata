package com.lect.ex06_wrapper;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력: ");
		String inputNo= sc.next();
		int no = Integer.parseInt(inputNo);
		System.out.println("입력하신 수는 : "+(no+1));
		sc.close();
	}
}
