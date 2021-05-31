package com.lect.myExample;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ExDate {
	public static void main(String[] args) {
		Date date = new Date(new GregorianCalendar(2021,11,11).getTimeInMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년-MM월-dd일 E요일");
		Calendar calendar = Calendar.getInstance();
		System.out.println(sdf.format(date));
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		System.out.println(new Date());
		System.out.println(new Date().getTime());
		System.out.println(Calendar.DAY_OF_WEEK);
		System.out.println(calendar.get(7));
	}
}
