package com.lect.ex1_tryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i, j;
		System.out.println("첫번째 수는? ");
		do{
			try{
				i=scanner.nextInt();break; //a입력시 a\n이 버퍼에 남아있어서 계속 예외처리된다.
			}catch(InputMismatchException e) {
				System.out.println("숫자를 입력해주시오");
				scanner.nextLine();
			}
		}while(true);	
		System.out.println("두번째 수는? ");
		do{
			try{
				j=scanner.nextInt();break; //a입력시 a\n이 버퍼에 남아있어서 계속 예외처리된다.
			}catch(InputMismatchException e) {
				System.out.println("숫자를 입력해주시오");
				scanner.nextLine();
			}
		}while(true);
		try {
			System.out.println("i="+i+"\t j="+j);
			System.out.println("i*j = "+ (i*j));
			System.out.println("i/j= "+(i/j)); //예외 발생 가능 부분
		}catch (ArithmeticException e) {       //예외발생시 수행해야 할 부분 - arithmeticexception인지 뭔지 모르겠으면 그냥 Exception 써라.
			System.out.println(e.getMessage());//예외 메시지 출력
		}
		
		System.out.println("i+j = "+(i+j));
		System.out.println("i-j = "+(i-j));
		System.out.println("DONE");
		scanner.close();
	}
}
