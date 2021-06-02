package com.lect.ex04_object;

import java.util.Random;

public class CardMainTest {
	public static void main(String[] args) {
		Card[] card = {new Card('＃',3),new Card('＆',3),new Card('＃',3),new Card('＊',3),new Card('＠',3)};
		Random random = new Random();
		char[] kinds = {'＃','＆','＊','＠'};
		Card com = new Card(kinds[random.nextInt(4)],random.nextInt(13)+1);
		System.out.println(com);
		for(int idx=0;idx<card.length;idx++) {
			if(card[idx].equals(com)) {
				System.out.println(idx+"번째 카드와 일치");
			}else {
				System.out.println(idx+"번째 카드와 다릅니다.");
			}
		}
			
		
	}
}
