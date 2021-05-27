package com.lect.ex4_test;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Customer> array= new ArrayList<Customer>();
		
		do{
			String join = null;
			System.out.println("회원가입 하시겠습니까?[예 : Y |아니오 : N]");
			try{
				join = scanner.nextLine();
			}catch(Exception e) {
				System.out.println("Y 또는 N을 입력해주세요."); 
			}
			if(join.equalsIgnoreCase("N")) {
				if(array.isEmpty()) {
					System.out.println("가입절차를 종료합니다.");
				}
				for(int i=0; i<array.size(); i++) {
					System.out.println(array.get(i));
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
				array.add(customer);
				
			}else {
				System.out.println("Y 또는 N을 입력해주세요.");
			}
		}while(true);
		
		scanner.close();
	}
}
