package programmers;
import java.util.*;
public class 주식가격 {
	static
	class Solution {
	    public int[] solution(int[] prices) {
	        int[] answer = new int[prices.length];
	        Stack<Integer> idxStack = new Stack<Integer>();
	        for(int i = 0; i < prices.length; ++i) {
	        	if(idxStack.isEmpty()) {
	        		idxStack.add(i);
	        	}else {
	        		if(prices[i] >= prices[idxStack.peek()]) {
	        			idxStack.add(i);
	        		}else {
	        			while(!idxStack.isEmpty() && prices[i] < prices[idxStack.peek()]) {
	        				answer[idxStack.peek()] = i-idxStack.pop();
	        			}
	        			idxStack.add(i);
	        		}
	        	}
	        }
	        while(!idxStack.isEmpty()) {
	        	answer[idxStack.peek()] = prices.length-1-idxStack.pop();
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[] prices = { 1,2,3,2,1,3};
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(prices)));
	}
}
