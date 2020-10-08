import java.io.*;
import java.util.*;
class Node{
	int idx;
	int number;
	Node(int idx, int number){
		this.idx = idx;
		this.number = number;
	}
}
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Node> stack = new Stack<Node>();
        for(int i = 0; i < answer.length; ++i) {
        	if(stack.isEmpty()) {
        		stack.push(new Node(i, prices[i]));
        	}else {
        		while(!stack.isEmpty() && prices[i]<stack.peek().number) {
        			Node node = stack.pop();
        			answer[node.idx] = i-node.idx;
        		}
        		stack.push(new Node(i, prices[i]));
        	}
        }
        while(!stack.isEmpty()) {
			Node node = stack.pop();
			answer[node.idx] = answer.length-1-node.idx;
		}
        return answer;
    }
}
public class 주식가격 {
	public static void main(String[] args) throws Exception{
		int[] prices = {1,2,3,2,3};
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(prices)));
	}
}
