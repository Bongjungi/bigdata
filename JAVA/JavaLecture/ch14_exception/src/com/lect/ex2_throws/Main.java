package com.lect.ex2_throws;

public class Main {
	public static void main(String[] args)  {//main함수에서 throws(jvm으로)하면 예외처리가 안된다.  
		try {
			new ThrowsEx();
		}catch(Exception e) {
			System.out.println("에러" + e.getMessage());
		}
	}
}
