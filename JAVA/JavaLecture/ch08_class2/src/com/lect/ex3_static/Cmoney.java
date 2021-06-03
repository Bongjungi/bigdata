package com.lect.ex3_static;

public class Cmoney {
	public static void main(String[] args) {
		Bmoney bm1 = new Bmoney("°­°­");
		Bmoney bm2 = new Bmoney("±è±è");
		
		bm1.takeMoney(2000);
		bm2.takeMoney(3000);
		System.out.println(bm1.getMoney());
		System.out.println(bm2.getMoney());
		System.out.println(Bmoney.amoney.money);
	}
}
