package com.lect.ex1_list;

import java.util.ArrayList;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		String[] array = new String[3];
		array[0]="str0";array[1]="str1";array[2]="str2";
		for(int i=0;i<array.length;i++) {
			System.out.printf("array[%d]=%s\n",i,array[i]);
		}
		System.out.println("=========================");
		ArrayList<String> arrayList= new ArrayList<String>();
		arrayList.add("str0"); //[str0]
		arrayList.add("str1"); //[str0,str1]
		arrayList.add("str2"); //[str0,str1,str2]
		arrayList.add(1, "12");//[str0,12,str1,str2]
		arrayList.set(1,"str1");//[str0,str1,str1,str2]
		for(int i=0;i<arrayList.size();i++) {
			System.out.printf("%d번째 인덱스 값은 : %s\n",i,arrayList.get(i));	
		}
		System.out.println();
		arrayList.remove(1);//[str0,str1,str2]
		arrayList.remove(arrayList.size()-1);//[str0,str1]
		for(int i=0;i<arrayList.size();i++) {
			System.out.printf("%d번째 인덱스 값은 : %s\n",i,arrayList.get(i));
		}
		System.out.println(arrayList);
		arrayList.clear();//[]
		System.out.println(arrayList);
		if(arrayList.size()==0) {
			System.out.println("arrayList의 데이터는 없습니다.");
		}
		if(arrayList.isEmpty()) {
			System.out.println("arrayList가 비워졌다.");	
		}
		arrayList=null; //arrayList 객체를 지웠다.
//		try {
//			System.out.println(arrayList.size());
//				
//		}catch(NullPointerException e) {
//			System.out.println(e.getMessage());
//		}
	}
}