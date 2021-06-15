package ex;

import java.util.ArrayList;
//  list   [54,45,86, ..................]
public class arr {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);list.add(45);list.add(44);list.add(46);list.add(45);list.add(47);list.add(48);
		for(int i=list.size()-1;i>=0;i--) {
			if(list.get(i)%2==0) {
				list.remove(i);
			}
		}
		System.out.println(list.size());
	}
}
