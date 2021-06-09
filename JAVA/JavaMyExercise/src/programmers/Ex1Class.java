package programmers;

//기능개발
//progresses : 현재 작업 진행정도
//speeds : 작업 진행속도
//return : 작업 완료 날짜당 작업완료개수
//progresses : [50,90,50], speeds : [20,1,20] -> return : [1,2]
//progresses : [93,30,55], speeds : [1,30,5] ->  return : [2,1]
//progresses : [95,90,99,99,80,99], speeds :  [1,1,1,1,1,1] -> return : [1,3,2]

//1. My idea - progresses : [50,90,50], speeds : [20,1,20] -> day(완성까지 걸리는 날짜) : [3,10,3] 
//-> 3<10(num2(=0)값 1증가 뒤에 good에 추가, num2=0초기화), 10<3 (num2(=0)값 1 증가),3(마지막)(num2값 1증가 뒤 good에 num2값 입력) -> good을 return



import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;


        
       //1. 

public class Ex1Class {
	public int[] solution(int[] progresses, int[] speeds) {
		
        ArrayList<Integer> day = new ArrayList<Integer>();
        ArrayList<Integer> ans= new ArrayList<Integer>();

			for(int i=0;i<progresses.length;i++) {
				int mod = (100-progresses[i])%speeds[i];
				if(mod==0) {
					day.add((100-progresses[i])/speeds[i]);
				}else {
					day.add((100-progresses[i])/speeds[i]+1);
				}
			}//day 완료
			
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
        } // good 완료
        
        int[] answer = new int[ans.size()];
		for(int i=0;i<ans.size();i++) {
			answer[i]=ans.get(i);
		}
        return answer;
	}
}
		
	//2.
//public class Ex1Class {
//	public int[] solution(int[] progresses, int[] speeds) {
//		Queue<Progress> q=  new LinkedList<>();
//        List<Integer> temp = new ArrayList<>();
//        for(int i =0 ; i < progresses.length ; i++){
//  
//            int remain = 100 - progresses[i];;
//            int finish_day = remain / speeds[i];
//            int mod = remain % speeds[i];
//            
//            if(mod > 0)
//                finish_day ++;
//            
//            
//            if(q.isEmpty()){
//                q.add(new Progress(finish_day,1));
//            }else{
//                if(q.peek().finish >= finish_day){
//                    //첫 작업이 오래 걸리는 경우
//                    q.peek().count += 1;
//                }else{
//                    temp.add(q.poll().count);
//                    q.add(new Progress(finish_day,1));
//                }
//            }
//        }
//        
//        if(!q.isEmpty())
//            temp.add(q.poll().count);
//        
//        int [] ret = new int[temp.size()];
//        
//        for(int i =0 ; i < ret.length;  i++){
//            ret[i] = temp.get(i);
//        }
//        
//        return ret;
//    }
//    
//    private class Progress{
//        int finish, count;
//        
//        public Progress(int f, int c){
//            this.finish = f;
//            this.count= c;
//        }
//    }
//}
