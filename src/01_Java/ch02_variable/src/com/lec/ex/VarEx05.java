package com.lec.ex;

public class VarEx05 {
	public static void main(String[] args) {
		//float f=10.000002F;
		float f=(float)10.0001; //�����������ȯ
		System.out.println(f);
		double d=10.0001;
		System.out.println(d);
		if (f==d) {
			System.out.println("�κ����°���");
		}
	}
}
