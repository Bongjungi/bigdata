package com.lect.ex7_test;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class BookTestMain {
	public static void main(String[] args) {
		BookLib[] bookLib = {new BookLib("890��-01", "java", "ȫ�浿"),new BookLib("890��-02", "hadoop", "ȫ�ϵ�")};
		Scanner scanner = new Scanner(System.in);
		int num,idx;
		String name,borrower;
			do {
				System.out.println("����: 1|�ݳ�: 2|������Ȳ: 0|����: �� ��");
				try {
					num=scanner.nextInt();
					scanner.nextLine();
				}catch(Exception e){
					num=4;
				}
				switch(num) {
				case 0: 
					for(BookLib book: bookLib) {
						System.out.println(book);
					}
					break;
				case 1:
					System.out.println("ã���ô� å�̸���? ");
					name=scanner.nextLine();
					for(idx=0;idx<bookLib.length;idx++) {
						if(bookLib[idx].getBookTitle().equals(name)) {
							break;
						}
					}
					if(idx==bookLib.length) {
						System.out.println("�׷� ���� �����");	
					}else if(bookLib[idx].getState()==BookLib.STATE_BORROWED){
						System.out.println("��������å�̿���.");	
					}else {
						System.out.println("�̸��Է�");
						borrower=scanner.nextLine();
						bookLib[idx].setCheckoutDate(new Date(new GregorianCalendar(2021,4,10).getTimeInMillis()));
						try {
							bookLib[idx].checkOut(borrower);
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
					}	
					break;
				case 2:
					System.out.println("�ֽô� å�̸���? ");
					name=scanner.next();
					for(idx=0;idx<bookLib.length;idx++) {
						if(bookLib[idx].getBookTitle().equals(name)) {
							break;
						}
					}
					if(idx==bookLib.length) {
						System.out.println("�׷� ���� �����");	
					}else {
						try {
							bookLib[idx].checkIn();
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						
					}
					break;
				case 3:
					System.out.println("���� ��Ȳ�Դϴ�."); 
					for(BookLib book: bookLib) {
						System.out.println(book);
					}
					break;
				default:
					System.out.println("����");
					break;
				}
			}while(num<=3);
			
			scanner.close();
		}
				
}
