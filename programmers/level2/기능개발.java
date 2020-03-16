package programmers;
import java.util.*;
public class 기능개발 {
	static
	class Solution {
	    public int[] solution(int[] progresses, int[] speeds) {
	        int[] neededDays = new int[progresses.length];
	        for(int i = 0; i < neededDays.length; ++i) {
	        	if((100-progresses[i])%speeds[i]==0) {
	        		neededDays[i] = (100-progresses[i])/speeds[i];
	        	}else {
	        		neededDays[i] = (100-progresses[i])/speeds[i]+1;	        			
	        	}
	        }
	        int prevMaxNum = neededDays[0];
	        int count = 1;
	        ArrayList<Integer> arrList = new ArrayList<Integer>();
	        for(int i = 1; i < neededDays.length; ++i) {
	        	if(neededDays[i] > prevMaxNum) {
	        		prevMaxNum = neededDays[i];
	        		arrList.add(count);
	        		count = 1;
	        	}else{
	        		count++;
	        	}
	        }
	        arrList.add(count);
	        int[] answer = new int[arrList.size()];
	        for(int i = 0; i < answer.length; ++i) {
	        	answer[i] = arrList.get(i);
	        }
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(progresses, speeds)));
	}
}
