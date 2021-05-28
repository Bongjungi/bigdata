package com.lect.ex1_list;
//차곡차곡 쌓을 때는 ArrayList, 많이 변경할때는 LinkedList
//ArrayList는 접근시간(읽어오는데 걸리는 시간)은 빠르나 비순차적으로 데이터를 추가하거나 삭제하는데 오래 걸린다.
//LinkedList는 비순차적으로 데이터를 변경할 때 ArrayList보다 빠르다.
import java.util.LinkedList;

public class Ex02_LinkedList {
	public static void main(String[] args) {
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("str0");//[str0]
		linkedList.add("str1");//[str0,str1]
		linkedList.add("str2");//[str0,str1,str2]
		linkedList.add(1,"1111");//[str0,1111,str1,str2]
		System.out.println(linkedList);
		for(String temp: linkedList) {
			System.out.print(temp);
		}
		System.out.println();
		linkedList.remove("1111");
		for(int i=0;i<linkedList.size();i++) {
			System.out.print(linkedList.get(i));
		}
		linkedList.clear();
		System.out.println();
		System.out.println(linkedList.isEmpty()?"비워졌다.":"데이터 있다.");
	}
}
