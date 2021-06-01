package com.lect.myExample;

public class ExStringBuilder {
	public static void main(String[] args) {
		StringBuilder str = new StringBuilder("쿠쿠쿠");
		StringBuilder str2 = new StringBuilder("키키키");
		System.out.println((str==str2)?"같다.":"다르다.");//주소가 다르니까;
		System.out.println((str.equals(str2))?"같다.":"다르다.");//==이랑 똑같으니까;
		
	}	
}
