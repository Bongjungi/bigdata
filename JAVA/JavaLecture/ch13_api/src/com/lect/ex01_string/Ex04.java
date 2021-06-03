package com.lect.ex01_string;
//문자열 뒤집기, 짝수번째 문자열
public class Ex04 {
	public static void main(String[] args) {
		String str ="2002 WorldCup Korea";
		int a=0;
		char[] kuku1=new char[str.length()];
		char[] kuku2=new char[str.length()/2];
		for(int i=0;i<str.length();i++){
			int k=str.length()-i-1;
			kuku1[i]=str.charAt(k);
		}
		String str1= new String(kuku1);
		System.out.println(str1);
		for(int i=1;i<str.length();i+=2) {
			kuku2[a]=str.charAt(i);
			a++;
		}
		String str2= new String(kuku2);
		System.out.println(str2);
	}
}
