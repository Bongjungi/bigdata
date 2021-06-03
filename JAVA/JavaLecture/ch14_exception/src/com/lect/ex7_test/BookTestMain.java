package com.lect.ex7_test;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class BookTestMain {
	public static void main(String[] args) {
		BookLib[] bookLib = {new BookLib("890ㄱ-01", "java", "홍길동"),new BookLib("890ㄱ-02", "hadoop", "홍하둡")};
		Scanner scanner = new Scanner(System.in);
		int num,idx;
		String name,borrower;
			do {
				System.out.println("대출: 1|반납: 2|도서현황: 0|종료: 그 외");
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
					System.out.println("찾으시는 책이름은? ");
					name=scanner.nextLine();
					for(idx=0;idx<bookLib.length;idx++) {
						if(bookLib[idx].getBookTitle().equals(name)) {
							break;
						}
					}
					if(idx==bookLib.length) {
						System.out.println("그런 도서 없어요");	
					}else if(bookLib[idx].getState()==BookLib.STATE_BORROWED){
						System.out.println("대출중인책이에요.");	
					}else {
						System.out.println("이름입력");
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
					System.out.println("주시는 책이름은? ");
					name=scanner.next();
					for(idx=0;idx<bookLib.length;idx++) {
						if(bookLib[idx].getBookTitle().equals(name)) {
							break;
						}
					}
					if(idx==bookLib.length) {
						System.out.println("그런 도서 없어요");	
					}else {
						try {
							bookLib[idx].checkIn();
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						
					}
					break;
				case 3:
					System.out.println("도서 현황입니다."); 
					for(BookLib book: bookLib) {
						System.out.println(book);
					}
					break;
				default:
					System.out.println("종료");
					break;
				}
			}while(num<=3);
			
			scanner.close();
		}
				
}
