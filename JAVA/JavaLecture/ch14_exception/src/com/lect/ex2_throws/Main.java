package com.lect.ex2_throws;

public class Main {
	public static void main(String[] args)  {//main�Լ����� throws(jvm����)�ϸ� ����ó���� �ȵȴ�.  
		try {
			new ThrowsEx();
		}catch(Exception e) {
			System.out.println("����" + e.getMessage());
		}
	}
}
