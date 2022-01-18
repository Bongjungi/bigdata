package ch01;

import java.util.ArrayList;

public class Exex {
	public static void main(String[] args) {
		float answer = 0;
		String s = "13+213-200/2";
		ArrayList<Integer> intlist = new ArrayList<Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		int temp = 0;
		for(int i=0;i<s.length();i++) {
			System.out.println(i+"번째");
			try {
				temp=temp*10+Integer.parseInt(s.split("")[i]);
			}catch(Exception e){
				intlist.add(temp);
				list.add(i);
				temp=0;
				continue;
			}finally {
				
			}
			
		}
		intlist.add(temp);
		System.out.println(intlist);
		System.out.println(list);
		answer+=intlist.get(0);
		for(int i=1;i<intlist.size();i++) {
			if(s.split("")[list.get(i-1)].equals("+")) {
				answer+=intlist.get(i);
			}else if(s.split("")[list.get(i-1)].equals("-")) {
				answer-=intlist.get(i);
			}else if(s.split("")[list.get(i-1)].equals("*")) {
				answer*=intlist.get(i);
			}else {
				answer/=(intlist.get(i)*1.0);
			}
			
		}
		if(answer==(Math.floor(answer))) {
			System.out.println((int)answer);
		}else {
			System.out.println(answer);
		}
		
	}
}
