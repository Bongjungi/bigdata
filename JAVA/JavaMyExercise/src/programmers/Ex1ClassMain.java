package programmers;

//기능개발

public class Ex1ClassMain {
	public static void main(String[] args) {
		Ex1Class ex = new Ex1Class();
		int[] progresses = {95,90,99,99,80,99};
		int[] speeds = {1,1,1,1,1,1};

		for(int i=0;i<ex.solution(progresses, speeds).length;i++) {
			System.out.print(ex.solution(progresses, speeds)[i]);
		}
		
		
		
		

		
	}
}
