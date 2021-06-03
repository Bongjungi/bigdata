package com.lect.ex02_date;
import java.util.Date;
public class Ex03_date {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
//		int year = date.getYear()+1900; //곧 없어질 함수
//		int month = date.getMonth()+1; // 곧 없어질 함수
//		int day = date.getDate(); //곧 없어질 함수
//		System.out.println(year+"년 "+month+"월 "+day+"일");
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초",date);
	}
}