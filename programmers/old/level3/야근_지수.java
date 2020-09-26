import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i = 0; i < works.length; ++i) {
        	pq.offer(works[i]);
        }
        int temp;
        while(n-->0) {
        	temp = pq.poll();
        	if(temp>0) {
        		temp--;
        	}
        	pq.offer(temp);
        }
        while(!pq.isEmpty()) {
        	temp = pq.poll();
        	answer += temp*temp;
        }
        return answer;
    }
}
public class 야근_지수 {
	public static void main(String[] args) {
		int[] works = {4,3,3};
		int n = 4;
		Solution sol = new  Solution();
		System.out.println(sol.solution(n, works));
	}
}
