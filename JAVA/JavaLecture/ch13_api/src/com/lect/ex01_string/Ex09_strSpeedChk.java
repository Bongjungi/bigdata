package com.lect.ex01_string;
//���۽ð� ����(http://www.epochconverter.com/clock)
//str 10���� �ٲٱ�
//������ �ð� ����
public class Ex09_strSpeedChk {
	public static void main(String[] args) {
		String string = "A";
		long start =System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
			string=string.concat("a");
		}
		long end = System.currentTimeMillis();
		System.out.println("��Ʈ�� 10���� ���� �ð� : "+(end-start));
		StringBuffer stringBuffer = new StringBuffer("A");
		start=System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
			stringBuffer=stringBuffer.append("a");
		}
		end=System.currentTimeMillis();
		System.out.println("��Ʈ������ 10���� ���� �ð� : "+(end-start));
		StringBuilder stringBuilder = new StringBuilder("A");
		start=System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
			stringBuilder=stringBuilder.append("a");
		}
		end=System.currentTimeMillis();
		System.out.println("��Ʈ������ 10���� ���� �ð� : "+(end-start));
		
	}
}
