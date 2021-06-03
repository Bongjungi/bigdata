package com.lect.ex1_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j;
		System.out.println("ù��° ����? ");
		do{
			try{
				i=scanner.nextInt();break; //a�Է½� a\n�� ���ۿ� �����־ ��� ����ó���ȴ�.
			}catch(InputMismatchException e) {
				System.out.println("���ڸ� �Է����ֽÿ�");
				scanner.nextLine();
			}
		}while(true);	
		System.out.println("�ι�° ����? ");
		do{
			try{
				j=scanner.nextInt();break; //a�Է½� a\n�� ���ۿ� �����־ ��� ����ó���ȴ�.
			}catch(InputMismatchException e) {
				System.out.println("���ڸ� �Է����ֽÿ�");
				scanner.nextLine();
			}
		}while(true);
		try {
			System.out.println("i="+i+"\t j="+j);
			System.out.println("i*j = "+ (i*j));
			System.out.println("i/j= "+(i/j)); //���� �߻� ���� �κ�
		}catch (ArithmeticException e) {       //���ܹ߻��� �����ؾ� �� �κ� - arithmeticexception���� ���� �𸣰����� �׳� Exception ���.
			System.out.println(e.getMessage());//���� �޽��� ���
		}
		
		System.out.println("i+j = "+(i+j));
		System.out.println("i-j = "+(i-j));
		System.out.println("DONE");
		scanner.close();
	}
}
