package com.lect.ex2_map;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

public class Ex02_FriendHashMap {
	public static void main(String[] args) {
		HashMap<String, Friend> hashMap = new HashMap<String, Friend>();
		hashMap.put("999-9999",new Friend("홍길동","999-9999",new Date(new GregorianCalendar().getTimeInMillis())));
		hashMap.put("888-8888", new Friend("홍길순","888-8888"));
		System.out.println(hashMap);
		Iterator<String> iterator = hashMap.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();//iterator.next() == key에 값을 넣고 다음값을 준비.
			System.out.println(key+"의 데이터 "+ hashMap.get(key));
		}
	}
}
