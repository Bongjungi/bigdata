package com.lect.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lect.ex01_string.Friend;

public class Ex05 {
	public static void main(String[] args) {
		Friend[] friends = {
				new Friend("해","010-9999-1234","05-22"),
				new Friend("별","010-9999-1111","04-22"),
				new Friend("달","010-9876-1111","05-24")};
		Date date = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("MM-dd"); 
		boolean outOk =false;
		for(int idx=0;idx<friends.length;idx++) {
			if(sdf.format(date).equals(friends[idx].getBirthday())){
				System.out.println(friends[idx]);
				outOk=true;
			}
		}
		if(!outOk) {
			System.out.println("생일자 없음.");
		}
	}
}
