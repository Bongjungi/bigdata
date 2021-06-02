package com.lect.ex01_string;
//시작시간 측정(http://www.epochconverter.com/clock)
//str 10만번 바꾸기
//끝나는 시간 측정
public class Ex09_strSpeedChk {
	public static void main(String[] args) {
		String string = "A";
		long start =System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
			string=string.concat("a");
		}
		long end = System.currentTimeMillis();
		System.out.println("스트링 10만번 변경 시간 : "+(end-start));
		StringBuffer stringBuffer = new StringBuffer("A");
		start=System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
			stringBuffer=stringBuffer.append("a");
		}
		end=System.currentTimeMillis();
		System.out.println("스트링버퍼 10만번 변경 시간 : "+(end-start));
		StringBuilder stringBuilder = new StringBuilder("A");
		start=System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
			stringBuilder=stringBuilder.append("a");
		}
		end=System.currentTimeMillis();
		System.out.println("스트링빌더 10만번 변경 시간 : "+(end-start));
		
	}
}
