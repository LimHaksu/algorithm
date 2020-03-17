package programmers;

import java.util.*;

public class 탑 {
	static
	class Solution {
	    public int[] solution(int[] heights) {
	        int[] answer = new int[heights.length];
	        Stack<Integer> s = new Stack<>();
	        for(int i = 0; i < answer.length; ++i) {
	        	if(s.isEmpty()) {
	        		answer[i] = 0;
	        		s.add(i);
	        	}else {
	        		if(heights[i] < heights[s.peek()]) {
	        			answer[i] = s.peek()+1;
	        			s.add(i);
	        		}else if(heights[i] >= heights[s.peek()]) {
	        			while(!s.isEmpty() && heights[i] >= heights[s.peek()]) {
	        				s.pop();
	        			}
	        			if(s.isEmpty()) {
	        				answer[i] = 0;
	        			}else {
	        				answer[i] = s.peek()+1;
	        			}
	        			s.add(i);
	        		}
	        	}
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[] heights = { 1,5,3,6,7,6,5};
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(heights)));
	}
}
