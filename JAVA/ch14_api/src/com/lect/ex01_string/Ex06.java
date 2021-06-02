package com.lect.ex01_string;

import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		String[] tels = {"010-9999-9999","010-8888-8888","010-6547-8888"};
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("회원의 전화번호 뒷자리는?(종료 시 x)");
			String searchTel = scanner.next();
			if(searchTel.equalsIgnoreCase("x")) {
				System.out.println("종료");
				break;
			}
			int k=0;
			for(String temp : tels) {
				if(temp.substring(temp.lastIndexOf("-")+1).equals(searchTel)) {
					System.out.println(temp);
				}else {
					k++;
				}	
			}
			if(k==tels.length) {
				System.out.println("없어");
			}
		}while(true);	
		scanner.close();
	}
}
