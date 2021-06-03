package com.lect.ex02_date;

import java.util.Calendar;

import com.lect.ex01_string.Friend;

public class Ex06 {
	public static void main(String[] args) {
		Friend[] friends = {
			new Friend("해","010-9999-1234","05-22"),
			new Friend("별","010-9999-1111","04-22"),
			new Friend("달","010-9876-1111","05-25")};
		Calendar cal = Calendar.getInstance();
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String strMonth = (month<10)?"0"+month:String.valueOf(month);
		String strDay = (day<10)?"0"+day:String.valueOf(day);
		String strToday=strMonth+"-"+strDay;
		
		boolean outOk = false;
		for(int idx=0;idx<friends.length;idx++) {
			if(friends[idx].getBirthday().equals(strToday)) {
				System.out.println(friends[idx]);
				outOk=true;
			}
			
		}
		
			
			
		
		if(!outOk) {
			System.out.println("오늘이 생일인 사람이 없습니다.");
		}
	}	
}
