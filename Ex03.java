package com.lec.ex;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String[] arrName= {"����","ö��","�浿","����","����"};
		int[] arrHeight=new int[arrName.length];
		int total=0;
		for(int idx=0; idx<arrHeight.length;idx++) {
			System.out.print(arrName[idx]+"�� Ű��?");
			arrHeight[idx]=scanner.nextInt();
			total+=arrHeight[idx];
		}
		System.out.printf("���Ű: %d\n",total/arrHeight.length);
		System.out.printf("���Ű: %f\n",total/(double)arrHeight.length);
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
		System.out.printf("���� ū �л��� : %s, Ű : %d\n",arrName[maxIdx],maxHeight);
		System.out.printf("���� ���� �л��� : %s, Ű : %d\n",arrName[minIdx],minHeight);
	}
}
