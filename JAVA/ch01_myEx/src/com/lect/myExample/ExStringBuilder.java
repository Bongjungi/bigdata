package com.lect.myExample;

public class ExStringBuilder {
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("������");
		StringBuilder str2 = new StringBuilder("ŰŰŰ");
		System.out.println((str==str2)?"����.":"�ٸ���.");//�ּҰ� �ٸ��ϱ�;
		System.out.println((str.equals(str2))?"����.":"�ٸ���.");//==�̶� �Ȱ����ϱ�;
		
	}	
}
