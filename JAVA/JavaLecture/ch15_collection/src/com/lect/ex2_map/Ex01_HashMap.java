package com.lect.ex2_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
//Map계열과 Set계열은 순서가 없다.
public class Ex01_HashMap {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("aaa");
		System.out.println(list.get(0));
		HashMap<Integer , String> hashmap = new HashMap<Integer, String>();//키값 데이터값 내가 정한다.
		hashmap.put(1,"str1");//{1=str1}
		hashmap.put(2,"str2");//{1=str1, 2=str2}
		hashmap.put(3,"str3");//{1=str1, 2=str2, 3=str3}
		System.out.println(hashmap.get(2));
		System.out.println(hashmap);
		hashmap.remove(2);
		System.out.println(hashmap);
		hashmap.clear();
		System.out.println(hashmap.isEmpty()?"데이터 모두 삭제":"데이터 있음");
		hashmap.put(10, "Hong gildong");
		hashmap.put(1, "Kim dongil");
		hashmap.put(21, "Lee soonsin");
		hashmap.put(13, "Yu ain");
		System.out.println(hashmap);
		System.out.println(hashmap.keySet());
		Iterator<Integer> iterator = hashmap.keySet().iterator();
		System.out.println(iterator);
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key+"의 데이터는 "+hashmap.get(key));
		}
	}
}