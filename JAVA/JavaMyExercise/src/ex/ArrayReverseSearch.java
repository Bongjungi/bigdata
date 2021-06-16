package ex;

import java.util.ArrayList;
//  list   [54,45,86, ..................]
public class ArrayReverseSearch {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);list.add(45);list.add(44);list.add(46);list.add(45);list.add(47);list.add(48);
		for(int i=list.size()-1;i>=0;i--) {
			if(list.get(i)%2==0) {
				list.remove(i);
			}
		}
		System.out.println(list.size());
		
//		ArrayList<Integer> list2 = new ArrayList<Integer>();
//		list2.add(4);list2.add(3);list2.add(2);list2.add(3);list2.add(0);list2.add(-1);
//		for(int i=0;i<list2.size();i++) {
//			if(list2.get(i)==3) {
//				list2.remove(i);
//				list2.remove(i);
//				i=0;
//			}
//		}
//		for(int i=0;i<list2.size();i++) {
//			System.out.println(list2.get(i));
//		}
	}
}
