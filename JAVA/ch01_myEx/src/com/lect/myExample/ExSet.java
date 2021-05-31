package com.lect.myExample;

import java.util.HashSet;
import java.util.Iterator;

public class ExSet {
	public static void main(String[] args) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		int row = 3;
		int column = 4;
		int[][] card = new int[row][column];
		do{
			int ran = (int)(Math.random()*row*column)+1;
			hashSet.add(ran);
			System.out.println(hashSet);
			if(hashSet.size()==row*column) {
				break;
			}
		}while(true);
		
		Iterator<Integer> iterator = hashSet.iterator();
		for(int i=0;i<card.length;i++) {
			for(int j=0;j<card[i].length;j++) {
				card[i][j]=iterator.next();
			}
		}
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				System.out.print(card[i][j]+"\t");	
			}
		
			System.out.println();
			System.out.println();
		}
	}
}
