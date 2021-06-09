package programmers;

public class Ex3ClassMain {
	public static void main(String[] args) {
		Ex3Class ex = new Ex3Class();
		int[] priorities = {2,1,3,2};
		int location = 2;
		System.out.println(ex.solution(priorities, location));
	}
}
