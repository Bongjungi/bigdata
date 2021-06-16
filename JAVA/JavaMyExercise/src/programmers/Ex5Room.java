package programmers;

public class Ex5Room {
	public static void main(String[] args) {
		int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0}; //return 3;
//		int[] arrows = {0,1,6,4,0,7,2,4};

		System.out.println(solution(arrows));
	}
	public static int solution(int[] arrows) {
		int answer = 0;

		if(arrows.length==0||arrows.length==1||arrows.length==2) {
			return answer;
		}

        //{x,y};
		int[][] ans = new int[arrows.length+1][2];
		ans[0][0]=0;
		ans[0][1]=0;
		
		for(int i=0;i<2;i++) {
        	switch(arrows[i]) {
        	case 0 : ans[i+1][0]=ans[i][0];ans[i+1][1]=ans[i][1]+1;break;
        	case 1 : ans[i+1][0]=ans[i][0]+1;ans[i+1][1]=ans[i][1]+1;break;
        	case 2 : ans[i+1][0]=ans[i][0]+1;ans[i+1][1]=ans[i][1];break;
        	case 3 : ans[i+1][0]=ans[i][0]+1;ans[i+1][1]=ans[i][1]-1;break;
        	case 4 : ans[i+1][0]=ans[i][0];ans[i+1][1]=ans[i][1]-1;break;
        	case 5 : ans[i+1][0]=ans[i][0]-1;ans[i+1][1]=ans[i][1]-1;break;
        	case 6 : ans[i+1][0]=ans[i][0]-1;ans[i+1][1]=ans[i][1];break;
        	case 7 : ans[i+1][0]=ans[i][0]-1;ans[i+1][1]=ans[i][1]+1;break;
        	}
        }
        for(int i=2; i<arrows.length; i++) {
        	switch(arrows[i]) {
        	case 0 : ans[i+1][0]=ans[i][0];ans[i+1][1]=ans[i][1]+1;break;
        	case 1 : ans[i+1][0]=ans[i][0]+1;ans[i+1][1]=ans[i][1]+1;break;
        	case 2 : ans[i+1][0]=ans[i][0]+1;ans[i+1][1]=ans[i][1];break;
        	case 3 : ans[i+1][0]=ans[i][0]+1;ans[i+1][1]=ans[i][1]-1;break;
        	case 4 : ans[i+1][0]=ans[i][0];ans[i+1][1]=ans[i][1]-1;break;
        	case 5 : ans[i+1][0]=ans[i][0]-1;ans[i+1][1]=ans[i][1]-1;break;
        	case 6 : ans[i+1][0]=ans[i][0]-1;ans[i+1][1]=ans[i][1];break;
        	case 7 : ans[i+1][0]=ans[i][0]-1;ans[i+1][1]=ans[i][1]+1;break;
        	}
        	if(same(ans[i-1],ans[i+1])) {
        		
    			continue;
    		}
        	for(int j=0;j<i;j++) {
        		if(same(ans[j],ans[i+1])) {
        				answer++;
        				break;
        		}
        	}
        }
          return answer;
	}
	public static boolean same(int[] array1, int[] array2) {
		int k=0;
		for(int i=0;i<array1.length;i++) {
			if(array1[i]!=array2[i]) {
				k=1;
			}
		}
		if(k==0) {
			return true;
		}else {
			return false;
		}
	}
}
