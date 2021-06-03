package com.lect.ex02_date;

import java.util.Calendar;

public class Ex01_calendar {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		System.out.println();
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH)+1; // �ý����� 0������
		int day=calendar.get(Calendar.DAY_OF_MONTH);
		int week=calendar.get(Calendar.DAY_OF_WEEK); //1(��),2(��),3(ȭ),4(��),5(��),6(��),7(��)
		int hour24=calendar.get(Calendar.HOUR_OF_DAY);
		int hour=calendar.get(Calendar.HOUR);
		int ampm=calendar.get(Calendar.AM_PM);
		int minute=calendar.get(Calendar.MINUTE);
		int second=calendar.get(Calendar.SECOND);
		System.out.printf("%d�� %d�� %d��",year,month,day);
		System.out.println();
		switch(week) {
		case 1:
			System.out.println("�Ͽ���");break;
		case 2:
			System.out.println("������");break;
		case 3:
			System.out.println("ȭ����");break;
		case 4:
			System.out.println("������");break;
		case 5:
			System.out.println("�����");break;
		case 6:
			System.out.println("�ݿ���");break;
		case 7:
			System.out.println("�����");break;
		}
		System.out.println();
		System.out.printf("%d�� %d�� %d��(24�ð�)\n",hour24,minute,second);
		System.out.print(ampm==0?"����":"����");
		System.out.printf("%d�� %d�� %d��(12�ð�)\n",hour,minute,second);
		//2021�� 5�� 24�� 15��(3��) 30�� 9��
		//tY(2021) tm(05) td(24) tH(15) tl(3) tp(����/����) tM(30) tS(9) tD(05/24/21) th/tb(5��) ta(��) ......
		//d(����) f(�Ǽ�) s(���ڿ�) c(����) b(true/false)
		System.out.printf("%tY�� %tm�� %td�� %tH�� %tM�� %tS��(24�ð�)\n",calendar,calendar,calendar,calendar,calendar,calendar);
		System.out.printf("%1$tY�� %1$tm�� %1$td�� %1$tH�� %1$tM�� %1$tS��(24�ð�)\n",calendar);
		
	
	}
}
