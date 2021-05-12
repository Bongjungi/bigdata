package com.lec.ex;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String[] arrName= {"영희","철수","길동","영수","말자"};
		int[] arrHeight=new int[arrName.length];
		int total=0;
		for(int idx=0; idx<arrHeight.length;idx++) {
			System.out.print(arrName[idx]+"의 키는?");
			arrHeight[idx]=scanner.nextInt();
			total+=arrHeight[idx];
		}
		System.out.printf("평균키: %d\n",total/arrHeight.length);
		System.out.printf("평균키: %f\n",total/(double)arrHeight.length);
		scanner.close();
		int maxIdx=0, maxHeight=0;
		int minIdx=0, minHeight=999;
		for (int i=0;i<arrHeight.length;i++) {
			if(arrHeight[i]>maxHeight) {
				maxHeight=arrHeight[i];
				maxIdx=i;
				
			}
			if(arrHeight[i]<minHeight) {
				minHeight=arrHeight[i];
				minIdx=i;
				
			}
		}
		System.out.printf("가장 큰 학생은 : %s, 키 : %d\n",arrName[maxIdx],maxHeight);
		System.out.printf("가장 작은 학생은 : %s, 키 : %d\n",arrName[minIdx],minHeight);
	}
}
