package com.lect.ex2_throws;

public class ThrowsEx {
	public ThrowsEx() throws Exception{
		actionC();
	}
	private void actionC() throws Exception{//Main으로 문제를 던진다.     //~~~~Exception이 아닌 그냥 Exception이면 못 내려간다.
		System.out.println("actionC 전반부");
		actionB();
		System.out.println("actionC 후반부");
	}
	private void actionB() throws ArrayIndexOutOfBoundsException{//C로 문제를 던진다.
		System.out.println("actionB 전반부");
		actionA(); //예를 들어 여기서 trycatch를 했으면 actionB후반부가 출력이 되었겠지.
		System.out.println("actionB 후반부");
	}
//	private void actionA() {
//		System.out.println("actionA 전반부");
//		int[] arr = {0,1,2};
//		
//		try{
//			System.out.println(arr[3]);
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println("actionA 후반부");
//	}
	private void actionA() throws ArrayIndexOutOfBoundsException{//B로 문제를 던진다.
		System.out.println("actionA 전반부");
		int[] arr= {0,1,2};
		System.out.println(arr[3]);
		System.out.println("actionA 후반부");
	}
}
