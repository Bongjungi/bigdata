package com.lect.ex4_test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Customer> hashmap = new HashMap<String, Customer>();
		
		do{
			String join = null;
			System.out.println("회원가입 하시겠습니까?[예 : Y |아니오 : N]");
			join = scanner.nextLine();
			if(join.equalsIgnoreCase("N")) {
				if(hashmap.isEmpty()) {
					System.out.println("가입절차를 종료합니다.");
				}
				Iterator<String> iterator = hashmap.keySet().iterator();
				while(iterator.hasNext()) {
					String key = iterator.next();
					System.out.println(hashmap.get(key));
				}
				break;
			}else if(join.equalsIgnoreCase("Y")) {
				Customer customer = new Customer();
				System.out.println("이름을 입력해 주세요 : ");
				String n = scanner.nextLine();
				customer.setName(n);
				System.out.println("전화번호를 입력해 주세요 : ");
				String t = scanner.nextLine();
				customer.setTel(t);
				System.out.println("주소를 입력해 주세요 : ");
				String a = scanner.nextLine();
				customer.setAddress(a);
				hashmap.put(t, customer);
				
			}else {
				System.out.println("Y 또는 N을 입력해주세요.");
			}
		}while(true);
		
		scanner.close();
	}
}
