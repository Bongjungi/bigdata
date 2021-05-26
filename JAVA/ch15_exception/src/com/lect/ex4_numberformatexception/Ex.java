package com.lect.ex4_numberformatexception;

public class Ex {
	public static void main(String[] args) {
		String strNo="";
		int no=0;
		try{
			no = Integer.parseInt(strNo.trim());
		}catch(NumberFormatException e) {
			System.out.println("입력하지 않는 값은 0으로 초기화");
		}
		System.out.println(no+1);
	}
}
