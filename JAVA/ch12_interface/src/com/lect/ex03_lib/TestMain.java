package com.lect.ex03_lib;

import java.util.Scanner;



public class TestMain {
	public static void main(String[] args) {
		BookLib[] bookLib = {new BookLib("111", "�ڹ�", "������"),new BookLib("222", "����Ŭ", "������"),new BookLib("333", "���̽�", "�ٴٴ�")};
		CDLib[] cdLib = {new CDLib("111","CD1","111"),new CDLib("222","CD2","222"),new CDLib("333","CD1","333")};
		Scanner scanner =new Scanner(System.in);
		int num,idx1;
		String name,borrower,checkoutdate;
		do {
			System.out.println("å����: 1|CD����: 2|å�ݳ�: 3|CD�ݳ�: 4|����: 0");
			num=scanner.nextInt();
			switch(num) {
			case 0:
				System.out.println("�����մϴ�.");
				break;
			case 1:
				System.out.println("ã���ô� å�̸���? ");
				name=scanner.next();
				for(idx1=0;idx1<bookLib.length;idx1++) {
					if(bookLib[idx1].getBookTitle().equals(name)) {
						break;
					}
				}
				if(idx1==bookLib.length) {
					System.out.println("�׷� ���� �����");	
				}else if(bookLib[idx1].getState()==BookLib.STATE_BORROWED){
					System.out.println("��������å�̿���.");	
				}else {
					System.out.println("�̸��Է�");
					borrower=scanner.next();
					System.out.println("��¥�Է�");
					checkoutdate=scanner.next();
					bookLib[idx1].checkOut(borrower, checkoutdate);
				}
				break;
			case 2:
				System.out.println("ã���ô� CD�̸���? ");
				name=scanner.next();
				for(idx1=0;idx1<cdLib.length;idx1++) {
					if(cdLib[idx1].getCdTitle().equals(name)) {
						break;
					}
				}
				if(idx1==cdLib.length) {
					System.out.println("�׷� CD �����");	
				}else if(cdLib[idx1].getState()==CDLib.STATE_BORROWED){
					System.out.println("��������CD�̿���.");	
				}else {
					System.out.println("�̸��Է�");
					borrower=scanner.next();
					System.out.println("��¥�Է�");
					checkoutdate=scanner.next();
					cdLib[idx1].checkOut(borrower, checkoutdate);
				}
				break;
			case 3:
				System.out.println("�ֽô� å�̸���? ");
				name=scanner.next();
				for(idx1=0;idx1<bookLib.length;idx1++) {
					if(bookLib[idx1].getBookTitle().equals(name)) {
						break;
					}
				}
				if(idx1==bookLib.length) {
					System.out.println("�׷� ���� �����");	
				}else {
					bookLib[idx1].checkIn();
				}
				break;
			case 4:
				System.out.println("�ֽô� CD�̸���? ");
				name=scanner.next();
				for(idx1=0;idx1<cdLib.length;idx1++) {
					if(cdLib[idx1].getCdTitle().equals(name)) {
						break;
					}
				}
				if(idx1==cdLib.length) {
					System.out.println("�׷� CD �����");	
				}else {
					cdLib[idx1].checkIn();
				}
				break;
				
			default :
				System.out.println("���� ���Է¹ٶ��ϴ�.");
			}
		}while(num!=0);
		System.out.println("���� ��Ȳ�Դϴ�."); 
		for(BookLib book: bookLib) {
			System.out.println(book);
		}
		System.out.println("CD ��Ȳ�Դϴ�."); 
		for(CDLib cd: cdLib) {
			System.out.println(cd);
		}
		
		scanner.close();
	}
	
}

