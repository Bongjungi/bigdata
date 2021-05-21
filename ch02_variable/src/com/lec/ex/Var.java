package com.lec.ex;

public class Var {
	public static int i=10; //int-4byte짜리 정수공간
	public static byte j=20; //byte-8bit짜리 정수공간
	public static double h=1; //double-8byte짜리 실수공간                         int cnt=h 불가능 - 8바이트 더블이 4바이트 인트안에 못들어감.
	public static char c='나'; //char-2byte짜리 문자공간
	public static boolean b=true; //boolean-1byte짜리 트루폴스공간
	public static long l=2200000000L; //L을 쓰는 이유는 기본적으로 int값으로 인식해서 long값으로 인식하기 위해
	public static float f=3.14159265359f; //f를 쓰는 이유: 기본적으로 double로 인식해서 float로 인식시키기 위해
	public static double g=3.1415926359;
	public static String s="나나나"; //String은 클래스이다.
}
