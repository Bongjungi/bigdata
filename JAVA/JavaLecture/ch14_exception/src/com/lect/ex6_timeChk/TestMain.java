package com.lect.ex6_timeChk;

import java.util.Date;
import java.util.GregorianCalendar;

public class TestMain {
	public static void main(String[] args) {
		Date thatday = new Date(new GregorianCalendar(2021,4,1).getTimeInMillis());
		Date now = new Date();
		long diff=now.getTime()-thatday.getTime();
		long day = diff/(1000*60*60*24);
		System.out.println("두 날 사이의 날짜 수는"+day);
		if(day>14) {
			long money=(day-14)*100;
			System.out.println(money+"원 연체료로 납부하셔야 합니다.");
		}
	}
}
