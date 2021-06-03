package com.lect.ex01_string;

public class Ex08_stringbuilder {
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("abc");
		System.out.println("str의 해쉬코드: "+str.hashCode());
		String string = str.substring(0);
		System.out.println(string);
		System.out.println("1. "+str);
		str.append("def"); //abcdef
		System.out.println("2. "+str);
		str.insert(3, "AAA"); // 3번째 index에 AAA삽입 abcAAAdef
 		System.out.println("3. "+str);
		str.delete(3,6);
		System.out.println("4. "+str);
		System.out.println("str의 해쉬코드 : "+str.hashCode());
		int builderSize= str.capacity();
		System.out.println("str의 가용크기 : "+builderSize+". 그러나 더 큰 데이터도 다른장소를 사용하여 저장할 수 있다.");
		str.append("12345678901234567890");
		System.out.println("5. "+str);
		System.out.println("str의 가용크기: "+str.capacity());
		System.out.println("변경 후 str의 해쉬코드 : "+str.hashCode());
	}

}
