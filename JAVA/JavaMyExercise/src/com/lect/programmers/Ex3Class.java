package com.lect.programmers;
//priorities : [2,1,3,2], location : 2   >>    return 1
//[1,1,9,1,1,1],0  >>  return 5


public class Ex3Class {
	public int solution(int[] priorities, int location) {
		int answer = 0;
        int max=0;
    	int maxint=0;
    	do {
    		answer++;
    		max=0;
            for(int i=maxint;i<priorities.length;i++) {
            	if(priorities[i]>max) {
            		max=priorities[i];
            		maxint=i;
            	}
            }
            for(int i=0;i<maxint;i++) {
            	if(priorities[i]>max) {
            		max=priorities[i];
            		maxint=i;
            	}
            }
            priorities[maxint]=0;
    	}while(maxint!=location);
    		
        
        return answer;
    }
}
