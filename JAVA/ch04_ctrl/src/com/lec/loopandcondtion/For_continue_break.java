package com.lec.loopandcondtion;

public class For_continue_break {
	public static void main(String[] args) {
		int a=1,b=14;
		int[][] c= {{1,2,3},{4,5,6},{7,8,9}};
		for(int i=0;i<=b;i++) {
			if(a==10) {
				continue; //a=10�̸� ������������ �Ѱܶ�(�ٽ� for������ ����)
			}else {
				a++;
			}
		}
		for(int[] temp : c) {
			switch(b) {
			case 14 :
				System.out.println(temp[0]);
				break; //�׸� �ϰ� ()���� �������Ͷ� -switch�� ������ switchŻ�� for�� ������ for��Ż��
			case 13 :
				System.out.println("z");
				break;
			default : //������
				
			}
		}
	}
}
