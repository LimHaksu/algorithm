package programmers;
import java.util.*;
public class 더_맵게 {
	static
	class Solution {
	    public int solution(int[] scoville, int K) {
	        int answer = 0;
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
	        for(int i = 0; i < scoville.length; ++i) {
	        	pq.add(scoville[i]);
	        }
	        int min = pq.poll();
	        while(min < K) {
	        	if(pq.size()==0) {
	        		answer = -1;
	        		break;
	        	}
	        	answer++;
	        	int secondMin = pq.poll();
	        	int newScv = min + secondMin * 2;
	        	pq.add(newScv);
	        	min = pq.poll();
	        }
	        return answer;
	    }
	};
	public static void main(String[] args) {
		int[] scoville = {1,2,3,9,10,12};
		int K = 7;
		Solution sol = new Solution();
		System.out.println(sol.solution(scoville, K));
	}
}
