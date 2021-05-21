package com.lec.ex;

public class Array {
	public static void main(String[] args) {
		int[] iArr= {10,20,30,40,50}; //1.배열 변수 선언과 초기화 //iArr에는 주소가 들어가고 주소가 가리키는 곳에 10,20,30,40,50이 있다.
		iArr[0]=90; //배열은 인덱스로 접근한다.(지금 생성한 index는 0~4) //iArr[0]의 값이 주소이고 그 주소의 값이 90
		//int[] iArr2 = new int[iArr.length]; //배열객체성성
		//int[] iArr3; //배열변수만 선언 iArr3=null;도 같은선언
		//iArr3= new int[3];
		int[][] iArr4= {{1,2,3},{4,5,6},{7,8}}; //이렇게도 설정가능 배열3칸 중 1칸마다 또다른 배열이 들어가 있는것
		for(int[] temp: iArr4) {
			System.out.println(temp[0]);
		}
	
	
	
	
	
	}
}
