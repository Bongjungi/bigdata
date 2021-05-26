package com.lec.loopandcondtion;

public class For_continue_break {
	public static void main(String[] args) {
		int a=1,b=14;
		int[][] c= {{1,2,3},{4,5,6},{7,8,9}};
		for(int i=0;i<=b;i++) {
			if(a==10) {
				continue; //a=10이면 실행하지말고 넘겨라(다시 for문으로 가라)
			}else {
				a++;
			}
		}
		for(int[] temp : c) {
			switch(b) {
			case 14 :
				System.out.println(temp[0]);
				break; //그만 하고 ()에서 빠져나와라 -switch에 있으면 switch탈출 for에 있으면 for문탈출
			case 13 :
				System.out.println("z");
				break;
			default : //나머지
				
			}
		}
	}
}
