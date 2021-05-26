package com.lect.ex03_lib;

import java.util.Scanner;



public class TestMain {
	public static void main(String[] args) {
		BookLib[] bookLib = {new BookLib("111", "자바", "가가가"),new BookLib("222", "오라클", "나나나"),new BookLib("333", "파이썬", "다다다")};
		CDLib[] cdLib = {new CDLib("111","CD1","111"),new CDLib("222","CD2","222"),new CDLib("333","CD1","333")};
		Scanner scanner =new Scanner(System.in);
		int num,idx1;
		String name,borrower,checkoutdate;
		do {
			System.out.println("책대출: 1|CD대출: 2|책반납: 3|CD반납: 4|종료: 0");
			num=scanner.nextInt();
			switch(num) {
			case 0:
				System.out.println("종료합니다.");
				break;
			case 1:
				System.out.println("찾으시는 책이름은? ");
				name=scanner.next();
				for(idx1=0;idx1<bookLib.length;idx1++) {
					if(bookLib[idx1].getBookTitle().equals(name)) {
						break;
					}
				}
				if(idx1==bookLib.length) {
					System.out.println("그런 도서 없어요");	
				}else if(bookLib[idx1].getState()==BookLib.STATE_BORROWED){
					System.out.println("대출중인책이에요.");	
				}else {
					System.out.println("이름입력");
					borrower=scanner.next();
					System.out.println("날짜입력");
					checkoutdate=scanner.next();
					bookLib[idx1].checkOut(borrower, checkoutdate);
				}
				break;
			case 2:
				System.out.println("찾으시는 CD이름은? ");
				name=scanner.next();
				for(idx1=0;idx1<cdLib.length;idx1++) {
					if(cdLib[idx1].getCdTitle().equals(name)) {
						break;
					}
				}
				if(idx1==cdLib.length) {
					System.out.println("그런 CD 없어요");	
				}else if(cdLib[idx1].getState()==CDLib.STATE_BORROWED){
					System.out.println("대출중인CD이에요.");	
				}else {
					System.out.println("이름입력");
					borrower=scanner.next();
					System.out.println("날짜입력");
					checkoutdate=scanner.next();
					cdLib[idx1].checkOut(borrower, checkoutdate);
				}
				break;
			case 3:
				System.out.println("주시는 책이름은? ");
				name=scanner.next();
				for(idx1=0;idx1<bookLib.length;idx1++) {
					if(bookLib[idx1].getBookTitle().equals(name)) {
						break;
					}
				}
				if(idx1==bookLib.length) {
					System.out.println("그런 도서 없어요");	
				}else {
					bookLib[idx1].checkIn();
				}
				break;
			case 4:
				System.out.println("주시는 CD이름은? ");
				name=scanner.next();
				for(idx1=0;idx1<cdLib.length;idx1++) {
					if(cdLib[idx1].getCdTitle().equals(name)) {
						break;
					}
				}
				if(idx1==cdLib.length) {
					System.out.println("그런 CD 없어요");	
				}else {
					cdLib[idx1].checkIn();
				}
				break;
				
			default :
				System.out.println("숫자 재입력바랍니다.");
			}
		}while(num!=0);
		System.out.println("도서 현황입니다."); 
		for(BookLib book: bookLib) {
			System.out.println(book);
		}
		System.out.println("CD 현황입니다."); 
		for(CDLib cd: cdLib) {
			System.out.println(cd);
		}
		
		scanner.close();
	}
	
}

