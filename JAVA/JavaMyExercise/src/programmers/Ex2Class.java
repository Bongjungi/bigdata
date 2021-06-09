package programmers;

import java.util.HashSet;

//해야할 일 [1,2,7,6,4] -> [7, 11, 13, 17] -> return 4; 


//[0][1][2] 013014	 023024	 034
//123124   	134
//234
//
public class Ex2Class {
	public int solution(int[] nums) {
        HashSet<Integer> primeset = new HashSet<Integer>();
        for(int k=0;k<nums.length-2;k++) {
        	for(int i=0;i<nums.length-2-k;i++) {
            	for(int j=0;j<1+k;j++) {
            		if(isprime(nums[i]+nums[i+j+1]+nums[i+k+2])) {
                    	primeset.add(nums[i]+nums[i+j+1]+nums[i+k+2]);
                    }
            	}
            }
        }
        return primeset.size();
    }
	public boolean isprime(int num) {
		if(num==0||num==1||num==2) {
			return false;
		}
		for(int i=2;i<=(int)Math.sqrt((double)num);i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
}
