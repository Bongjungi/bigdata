package com.lect.ex2_throws;

public class ThrowsEx {
	public ThrowsEx() throws Exception{
		actionC();
	}
	private void actionC() throws Exception{//Main���� ������ ������.     //~~~~Exception�� �ƴ� �׳� Exception�̸� �� ��������.
		System.out.println("actionC ���ݺ�");
		actionB();
		System.out.println("actionC �Ĺݺ�");
	}
	private void actionB() throws ArrayIndexOutOfBoundsException{//C�� ������ ������.
		System.out.println("actionB ���ݺ�");
		actionA(); //���� ��� ���⼭ trycatch�� ������ actionB�Ĺݺΰ� ����� �Ǿ�����.
		System.out.println("actionB �Ĺݺ�");
	}
//	private void actionA() {
//		System.out.println("actionA ���ݺ�");
//		int[] arr = {0,1,2};
//		
//		try{
//			System.out.println(arr[3]);
//		}catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println("actionA �Ĺݺ�");
//	}
	private void actionA() throws ArrayIndexOutOfBoundsException{//B�� ������ ������.
		System.out.println("actionA ���ݺ�");
		int[] arr= {0,1,2};
		System.out.println(arr[3]);
		System.out.println("actionA �Ĺݺ�");
	}
}
