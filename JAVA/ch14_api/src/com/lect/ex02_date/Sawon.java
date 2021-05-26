package com.lect.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/* new Sawon("a01","ȫ�浿",Sawon.Computer)
 * new Sawon("a01","ȫ�浿",Part.Computer)
   2021.05.24,            */

public class Sawon {
	private String num;
	private String name;
	private String part;
	private Date enterDate;
	public Sawon(String num, String name, String part) {
		this.num=num;
		this.name=name;
		this.part=part;
		enterDate=new Date();
	}
	public Sawon(String num, String name, String part, int y, int m, int d) { 
		this.num=num;
		this.name=name;
		this.part=part;
		enterDate = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis()); //system�� ���� 0���� �����Ѵ�. �׷��� 5���̾ �׷����ȿ� 4(May)�� �ִ´�.
																					// ��ҿ��� int month=calendar.get(Calendar.MONTH)+1; �߰�����
																					// gettimeinmillis���� �и������� ���� �ٷ� +1������ �ʿ���� �ڵ����� ���ϴ´�ΰ���
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy�� M�� d��");
		String temp=sdf.format(enterDate);
			
			return "[���]" +num + " [�̸�]" + name + " [�μ�]" + part + " [�Ի���]" + temp + "\n";
	}
		
}
	
	
	

