package com.lect.ex02_date;

import java.util.Calendar;

public class Ex01_calendar {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		System.out.println();
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH)+1; // 시스템은 0월부터
		int day=calendar.get(Calendar.DAY_OF_MONTH);
		int week=calendar.get(Calendar.DAY_OF_WEEK); //1(일),2(월),3(화),4(수),5(목),6(금),7(토)
		int hour24=calendar.get(Calendar.HOUR_OF_DAY);
		int hour=calendar.get(Calendar.HOUR);
		int ampm=calendar.get(Calendar.AM_PM);
		int minute=calendar.get(Calendar.MINUTE);
		int second=calendar.get(Calendar.SECOND);
		System.out.printf("%d년 %d월 %d일",year,month,day);
		System.out.println();
		switch(week) {
		case 1:
			System.out.println("일요일");break;
		case 2:
			System.out.println("월요일");break;
		case 3:
			System.out.println("화요일");break;
		case 4:
			System.out.println("수요일");break;
		case 5:
			System.out.println("목요일");break;
		case 6:
			System.out.println("금요일");break;
		case 7:
			System.out.println("토요일");break;
		}
		System.out.println();
		System.out.printf("%d시 %d분 %d초(24시간)\n",hour24,minute,second);
		System.out.print(ampm==0?"오전":"오후");
		System.out.printf("%d시 %d분 %d초(12시간)\n",hour,minute,second);
		//2021년 5월 24일 15시(3시) 30분 9초
		//tY(2021) tm(05) td(24) tH(15) tl(3) tp(오전/오후) tM(30) tS(9) tD(05/24/21) th/tb(5월) ta(월) ......
		//d(정수) f(실수) s(문자열) c(문자) b(true/false)
		System.out.printf("%tY년 %tm월 %td일 %tH시 %tM분 %tS초(24시간)\n",calendar,calendar,calendar,calendar,calendar,calendar);
		System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$tH시 %1$tM분 %1$tS초(24시간)\n",calendar);
		
	
	}
}
