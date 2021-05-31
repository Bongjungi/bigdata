package com.lect.test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MainTest {
	public static void main(String[] args) {
		ArrayList<Customer> arrayList = new ArrayList<Customer>();
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		while(true) {
			System.out.println("회원가입 하시겠습니까? (Y|N) : ");
			String join = scanner.nextLine();
			if(join.equalsIgnoreCase("n")) {
				break;
			}else if(join.equalsIgnoreCase("y")) {
				Customer customer = Customer.getInstance();
				System.out.println("이름을 입력해주세요 : ");
				customer.setName(scanner.nextLine());
				System.out.println("전화번호를 입력해주세요 : ");
				customer.setTel(scanner.nextLine());
				System.out.println("생일을 입력해주세요(MM-dd) : ");
				customer.setBirthday(scanner.nextLine());
				if(customer.getBirthday().equals(sdf.format(new Date()))) {
					System.out.println("생일 축하합니다.");
				}
				System.out.println("주소를 입력해주세요 : ");
				customer.setAddress(scanner.nextLine());
				arrayList.add(customer);
			}else {
				System.out.println("Y 또는 N을 입력해주세요.");
			}
		}
		Writer writer = null;
		PrintWriter printWriter = null;
		
		try {
			writer = new FileWriter("txtFile/customer.txt",true);
			printWriter = new PrintWriter(writer);
			for(int i=0;i<arrayList.size();i++) {
				printWriter.println(arrayList.get(i));
			}
			printWriter.print("            .....이하 "+arrayList.size()+"명 가입\n");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			if(printWriter!=null) {
				printWriter.close();
			}
			if(writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		scanner.close();
	}
}
