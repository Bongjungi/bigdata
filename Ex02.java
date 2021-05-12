package com.lec.ex;

public class Ex02 {
	public static void main(String[] args) {
		int[][] test= {{10,20,30},{40,50,60}};
		for(int i=0;i<test.length;i++) {
			for(int j=0;j<test[i].length;j++) {
				System.out.printf("test[%d][%d]=%d\n",i,j,test[i][j]);
			}
		}
	}
}
