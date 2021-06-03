package com.lect.ex_override2;



public class TestMain {
	public static void main(String[] args) {
		HeadQuarterStore[] hs= {new HeadQuarterStore("히히"),new StoreNum1("야"),new StoreNum2("왜"),new StoreNum3("그냥")};
		for(HeadQuarterStore i:hs) {
			System.out.println(i.getName());
			i.kimchi();i.budae();i.bibim();i.sundae();i.gonggi();
		}
		
	}
}
