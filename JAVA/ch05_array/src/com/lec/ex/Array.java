package com.lec.ex;

public class Array {
	public static void main(String[] args) {
		int[] iArr= {10,20,30,40,50}; //1.�迭 ���� ����� �ʱ�ȭ //iArr���� �ּҰ� ���� �ּҰ� ����Ű�� ���� 10,20,30,40,50�� �ִ�.
		iArr[0]=90; //�迭�� �ε����� �����Ѵ�.(���� ������ index�� 0~4) //iArr[0]�� ���� �ּ��̰� �� �ּ��� ���� 90
		//int[] iArr2 = new int[iArr.length]; //�迭��ü����
		//int[] iArr3; //�迭������ ���� iArr3=null;�� ��������
		//iArr3= new int[3];
		int[][] iArr4= {{1,2,3},{4,5,6},{7,8}}; //�̷��Ե� �������� �迭3ĭ �� 1ĭ���� �Ǵٸ� �迭�� �� �ִ°�
		for(int[] temp: iArr4) {
			System.out.println(temp[0]);
		}
	
	
	
	
	
	}
}
