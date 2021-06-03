package com.lect.ex1_list;
//�������� ���� ���� ArrayList, ���� �����Ҷ��� LinkedList
//ArrayList�� ���ٽð�(�о���µ� �ɸ��� �ð�)�� ������ ����������� �����͸� �߰��ϰų� �����ϴµ� ���� �ɸ���.
//LinkedList�� ����������� �����͸� ������ �� ArrayList���� ������.
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
		System.out.println(linkedList.isEmpty()?"�������.":"������ �ִ�.");
	}
}
