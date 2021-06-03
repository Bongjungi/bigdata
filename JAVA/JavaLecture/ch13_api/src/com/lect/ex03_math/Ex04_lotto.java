package com.lect.ex03_math;

public class Ex04_lotto {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		for(int i=0;i<6;i++) {
			int temp=(int)(Math.random()*45)+1;
			boolean ok =true;
			for(int j=0;j<i;j++) {
				if(temp==lotto[j]) {
					i--;
					ok=false;
					break;
				}
			}
			if(ok) {
				lotto[i]=temp;
			}
		}
		for(int l : lotto) {
			System.out.print(l+"\t");
		}
	}
}
