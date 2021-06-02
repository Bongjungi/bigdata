package com.lect.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/* new Sawon("a01","홍길동",Sawon.Computer)
 * new Sawon("a01","홍길동",Part.Computer)
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
		enterDate = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis()); //system의 월은 0부터 시작한다. 그래서 5월이어도 그레고리안에 4(May)를 넣는다.
																					// 평소에는 int month=calendar.get(Calendar.MONTH)+1; 했겠지만
																					// gettimeinmillis같은 밀리세컨을 쓰면 바로 +1같은거 필요없이 자동으로 원하는대로가능
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy년 M월 d일");
		String temp=sdf.format(enterDate);
			
			return "[사번]" +num + " [이름]" + name + " [부서]" + part + " [입사일]" + temp + "\n";
	}
		
}
	
	
	

