package com.lect.ex01_string;

public class Ex02 {
	public static void main(String[] args) {
		String str1="abcXabc";
		String str2=new String("ABCXabc");
		String str3="   ja  va   ";
		System.out.println("1. "+str1.concat(str2));//abcXabcABCXabc
		System.out.println("2. "+str1.substring(3));//3번째부터 끝까지
		System.out.println("3. "+str1.substring(3, 6));//3번째부터 6번째앞까지
		System.out.println("4. "+str1.length());//문자열길이7
		System.out.println("5. "+str1.toUpperCase());//모두 대문자로
		System.out.println("6. "+str1.toLowerCase());//모두 소문자로
		System.out.println("7. "+str1.charAt(2));// 2번째 인덱스의 글자
		System.out.println("8. "+str1.indexOf('b'));//몇번째 인덱스에 b가 위치하는가
		System.out.println("9. "+str1.indexOf('d'));//없으면 -1 리턴
		System.out.println("10. "+str1.indexOf('b', 3));//3번째 인덱스부터 b를 찾아라
		System.out.println("11. "+str1.lastIndexOf('b'));//마지막부터 b를 찾음
		System.out.println("12. "+str1.equals(str2));//str1과 str2의 값이 같냐
		System.out.println("13. "+str1.equalsIgnoreCase(str2));//대소문자무시하고 값이 같은지
		System.out.println("14. "+str3.trim());//좌우 space 제거     ja  va
		System.out.println("15. "+str1.replace('a', '★'));//a를 ★로 수정.
		System.out.println("16. "+str1.replace("abc","바꿔"));
		System.out.println("17. "+str1.replace("abc","바꿔"));
		System.out.println("최종 str1= "+str1);
	}
}
