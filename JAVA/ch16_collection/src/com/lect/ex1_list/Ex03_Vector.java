package com.lect.ex1_list;

import java.util.Vector;

public class Ex03_Vector {
	public static void main(String[] args) {
		Vector<Object> vec = new Vector<Object>();
		vec.add("str");
		vec.add(10);//자동으로 new Integer(10);으로 변경된다.
		System.out.println(vec);	
		for(int i=0;i<vec.size();i++) {
			System.out.print(vec.get(i)+"\t");
		}
	}
}
