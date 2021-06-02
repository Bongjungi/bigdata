package com.lect.ex02_date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FriendStringBuilderMain extends FriendStringBuilder {
	public static void main(String[] args) {
		FriendStringBuilder[] fs= {new FriendStringBuilder(new StringBuilder("해"), new StringBuilder("111-1111"), new StringBuilder("06-02")),
		new FriendStringBuilder(new StringBuilder("달"), new StringBuilder("222-2222"), new StringBuilder("04-25")),
		 new FriendStringBuilder(new StringBuilder("별"), new StringBuilder("222-2222"), new StringBuilder("05-25"))};
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		int k=0;
		for(FriendStringBuilder temp : fs) {
			if(temp.getBirthday().toString().equals(new StringBuilder(sdf.format(date)).toString())) {
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
