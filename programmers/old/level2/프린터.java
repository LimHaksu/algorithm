package programmers;
import java.util.*;
public class 프린터 {
	static
	class Solution {
		class Node{
			int idx;
			int priority;
			Node(int idx, int priority){
				this.idx = idx;
				this.priority = priority;
			}
		}
	    public int solution(int[] priorities, int location) {
	        int answer = 0;
	        Queue<Node> q = new LinkedList<>();
	        for(int i = 0; i < priorities.length; ++i) {
	        	q.add(new Node(i,priorities[i]));
	        }
	        while(!q.isEmpty()) {
	        	Node node = q.poll();
	        	boolean check = true;
	        	for(Node n : q) {
	        		if(n.priority > node.priority) {
	        			check = false;
	        			break;
	        		}
	        	}
	        	if(check) {
	        		answer++;
	        		if(node.idx == location) {
	        			break;
	        		}
	        	}else {
	        		q.add(node);
	        	}
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int[] priorities = {1,1,9,1,1,1};
		int location = 0;
		Solution sol = new Solution();
		System.out.println(sol.solution(priorities, location));
	}
}
