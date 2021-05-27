package com.lect.myExample;

public class TheRandom {
	public static void main(String[] args) {
		int Row=3;
		int Column=3;
		int[][] var1= new int[Row][Column];
//		var1[0][0]=(int)(Math.random()*Row*Column)+1;
//		System.out.print(var1[0][0]+"\t");
		for(int i=0;i<Row;i++) {
			for(int j=0;j<Column;j++) {
//				if((i==0&&j==0))continue;
				do{ 
					int k=0;
					var1[i][j]=(int)(Math.random()*Row*Column)+1;
					for(int a=0;a<Row;a++) {
						for(int b=0;b<Column;b++) {
							if(var1[i][j]==var1[a][b]) {
								k++;
							}else {
								continue;
							}
						}
					}
					if(k==1)break;
				}while(true);
				System.out.print(var1[i][j]+"\t");
			}
			System.out.println();
			System.out.println();
		}
	}	
}
