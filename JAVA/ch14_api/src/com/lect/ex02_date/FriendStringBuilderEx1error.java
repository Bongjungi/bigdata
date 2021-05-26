package com.lect.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FriendStringBuilderEx1error extends FriendStringBuilder {
	public static void main(String[] args) {
		FriendStringBuilder[] fs= {new FriendStringBuilder(new StringBuilder("해"), new StringBuilder("111-1111"), new StringBuilder("05-25")),
		new FriendStringBuilder(new StringBuilder("달"), new StringBuilder("222-2222"), new StringBuilder("04-25")),
		 new FriendStringBuilder(new StringBuilder("별"), new StringBuilder("222-2222"), new StringBuilder("05-25"))};
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		int k=0;
		for(FriendStringBuilder temp : fs) {
			System.out.println(temp);
			if(temp.getBirthday().equals(new StringBuilder(sdf.format(date)))) {//스트링빌더를 스트링으로 바꿀 수는 없나?
				System.out.println(temp);
			}
			else {
				k++;
			}
		}
		
			
	//	}
		if(k==fs.length) {
			System.out.println("생일자 없음.");
		}
	
	}
	
}
