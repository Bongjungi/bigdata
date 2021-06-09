package com.lect.programmers;

import java.util.HashMap;

public class Ex4Class {
	public int solution(int[][] routes) {
    	int answer = 0;
    	HashMap<Integer, Integer> nummap = new HashMap<Integer, Integer>(); 
    	HashMap<Integer, int[]> realmap = new HashMap<Integer, int[]>();
    	HashMap<Integer, int[]> tempmap = new HashMap<Integer, int[]>();
    	for(int i=0;i<routes.length;i++) {
    		realmap.put(i, routes[i]);
        }
    	do {
    		if(realmap.size()==1) {
	        	realmap.remove(0);
	        	answer++;
	        	break;
	        }
    		answer++;
    		int minlength=60000;
    		int minint = 0;
	        nummap.clear();
	        for(int i : realmap.keySet()) {
	        	if(realmap.get(i)[1]-realmap.get(i)[0]<minlength) {
	        		minlength=realmap.get(i)[1]-realmap.get(i)[0];
	        		minint =i;
	        	}
	        }
	        int num=0;
	        for(int i=realmap.get(minint)[0]; i<=realmap.get(minint)[1];i++) {
	        	num=0;
	        	for(int j : realmap.keySet()) {
	        		if(realmap.get(j)[0]<=i&&realmap.get(j)[1]>=i) {
	        			num++;
	        		}
	        	}
	        	nummap.put(i,num);
	        }
	        int max=0;int maxint=0;
	        for(int i=realmap.get(minint)[0]; i<=realmap.get(minint)[1];i++) {
	        	if(nummap.get(i)>max) {
	        		max=nummap.get(i);
	        		maxint=i;
	        	}
	        }
	        for(int i : realmap.keySet()) {
        		tempmap.put(i, realmap.get(i));
        	}
	        for(int i : tempmap.keySet()) {
        		if(tempmap.get(i)[0]<=maxint&&tempmap.get(i)[1]>=maxint) {
        			realmap.remove(i);
        		}
        	}
    	}while(realmap.size()!=0);
    	
        return answer;
    }
}
