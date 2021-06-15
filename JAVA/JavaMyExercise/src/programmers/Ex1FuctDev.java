package programmers;

import java.util.ArrayList;

//기능개발

public class Ex1FuctDev {
	public static void main(String[] args) {
		int[] progresses = {95,90,99,99,80,99};
		int[] speeds = {1,1,1,1,1,1};

		for(int i=0;i<solution(progresses, speeds).length;i++) {
			System.out.print(solution(progresses, speeds)[i]);
		}
	}
	public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> day = new ArrayList<Integer>();
        ArrayList<Integer> ans= new ArrayList<Integer>();
			for(int i=0;i<progresses.length;i++) {
				int mod = (100-progresses[i])%speeds[i];
				if(mod==0) {
					day.add((100-progresses[i])/speeds[i]);
				}else {
					day.add((100-progresses[i])/speeds[i]+1);
				}
			}
		int num2=0;
        for(int i=0; i<day.size();i++) {
        	if(i==day.size()-1) {
        		num2++;
        		ans.add(num2);
        		break;
        	}
        	if(day.get(i)<day.get(i+1)) {
            	num2++;
        		ans.add(num2);
            	num2=0;
            }else {
            	num2++;
            }
        } 
        int[] answer = new int[ans.size()];
		for(int i=0;i<ans.size();i++) {
			answer[i]=ans.get(i);
		}
        return answer;
	}
}
