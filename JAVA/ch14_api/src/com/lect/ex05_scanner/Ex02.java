package com.lect.ex05_scanner;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("주소 입력: ");
		//scanner.nextLine(); 이거 넣으면 처음 입력한 게 지워진다.
		String add = scanner.nextLine();
		System.out.println("입력하신 주소는:"+add);
		System.out.println("이름을 입력하세요:");
		String name = scanner.nextLine();
		System.out.println("입력하신 이름은: "+name);
		scanner.close();
	}
}
