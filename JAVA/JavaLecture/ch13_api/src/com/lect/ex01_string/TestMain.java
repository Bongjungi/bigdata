package com.lect.ex01_string;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
		Friend[] friends = {
				new Friend("홍길동","010-9999-1234","05-22"),
				new Friend("가가가","010-9999-1111","04-22"),
				new Friend("나나나","010-9876-1111","05-24")};
		Scanner scanner= new Scanner(System.in);

		do {
			int k=0;
			System.out.print("검색할 전화번호 뒷자리(단, 종료를 원하시면 x를 입력하시오): ");
			String num=scanner.next();
			if(num.equalsIgnoreCase("x")) {
				break;
			}
			for(Friend friend : friends) {
				if(friend.getPhone().substring(friend.getPhone().lastIndexOf("-")+1).equals(num)) {
					System.out.println(friend);
				}else {
					k++;
				}
			}
			if(k==friends.length) {
				System.out.println("해당 전화번호의 친구는 없습니다.");
			}
		}while(true);
		scanner.close();
	}
}
