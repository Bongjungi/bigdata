package com.lect.myExample;

public class TheRandom {
	public static void main(String[] args) {
//		long start =System.currentTimeMillis();
//		for(int p=0;p<50000;p++) {
//			int Row=5;
//			int Column=4;
//			int[][] var1= new int[Row][Column];
//			for(int i=0;i<Row;i++) {
//				for(int j=0;j<Column;j++) {
//					do{ 
//						int k=0;
//						var1[i][j]=(int)(Math.random()*Row*Column)+1;
//						for(int a=0;a<Row;a++) {
//							for(int b=0;b<Column;b++) {
//								if(var1[i][j]==var1[a][b]) {
//									k++;
//								}else {
//									continue;
//								}
//							}
//						}
//						if(k==1)break;
//					}while(true);
//					System.out.print(var1[i][j]+"\t");
//				}
//				System.out.println();
//				System.out.println();
//			}
//		}
//		long end = System.currentTimeMillis();
//		System.out.println("걸린 시간 :"+ (end-start));
		/****************************************************************
		 * 
		 */
//		long start = System.currentTimeMillis();
//		for(int p=0;p<500;p++) {
//			int row=10;
//			int column=16;
//			int[] tempcard = new int[row*column];
//			int num=0;
//			int[][] card = new int[row][column];
//			for(int i=0;i<row*column;i++) {
//				int temp=(int)(Math.random()*row*column)+1;
//				boolean ok =true;
//				for(int j=0;j<i;j++) {
//					if(temp==tempcard[j]) {
//						i--;
//						ok=false;
//						break;
//					}
//				}
//				if(ok) {
//					tempcard[i]=temp;
//				}
//			}
//			for(int i=0;i<row;i++){
//				for(int j=0;j<column;j++) {
//					card[i][j]=tempcard[num];
//					num++;
//				}
//			}	
//			for(int i=0;i<row;i++) {
//				for(int j=0;j<column;j++) {
//					System.out.print(card[i][j]+"\t");	
//				}
//				System.out.println();
//				System.out.println();
//			}
//		}	
//		long end = System.currentTimeMillis();
//		System.out.println("걸린 시간 :"+ (end-start));
		
	}		
}