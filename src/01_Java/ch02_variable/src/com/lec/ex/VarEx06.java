package com.lec.ex;

public class VarEx06 {
//����ȯ = ������������ȯ, �����������ȯ
	public static void main(String[] args) {
		int i1=10;
		double d1=i1; //4����Ʈ i1�� 8����Ʈ d1�� �ִ´�.i1�� ����� �ٲ� ��. - ������ ��ȯ
		System.out.printf("i1=%d, d1=%.2f\n",i1,d1);
		//i1=d1; �׳��� �Ұ��� ��������
		d1=10.9;
		i1=(int)d1; //����� ����ȯ - ������ �����κ��� ©��
		System.out.printf("i1=%d, d1=%.2f\n",i1,d1);
	}
}
