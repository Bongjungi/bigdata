package com.lect.ex02_date;
import java.util.Date;
public class Ex03_date {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
//		int year = date.getYear()+1900; //�� ������ �Լ�
//		int month = date.getMonth()+1; // �� ������ �Լ�
//		int day = date.getDate(); //�� ������ �Լ�
//		System.out.println(year+"�� "+month+"�� "+day+"��");
		System.out.printf("%1$tY�� %1$tm�� %1$td�� %1$tH�� %1$tM�� %1$tS��",date);
	}
}