package com.lect.ex1_list;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import com.lect.ex2_map.Friend;

public class Ex04_FriendArrayList {
	public static void main(String[] args) {
		//Friend[] friends = {new Friend("ȫ�浿", "999-9999", new Date(new GregorianCalendar(2021,11,11).getTimeInMillis()))};
		ArrayList<Friend> fs= new ArrayList<Friend>();
		fs.add(new Friend("ȫ�浿", "999-9999",new Date(new GregorianCalendar(2021,11,11).getTimeInMillis())));
		fs.add(new Friend("�ű浿","888-8888",new Date(new GregorianCalendar(2020,10,16).getTimeInMillis())));
		System.out.println(fs);
		for(int i=0; i<fs.size(); i++) {
			System.out.println(fs.get(i));
		}
		for(Friend f:fs) {
			System.out.println(f);
		}
	}
}

