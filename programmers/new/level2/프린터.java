import java.util.*;
import java.io.*;
class Node{
	int num;
	boolean check;
	Node(int num, boolean check){
		this.num = num;
		this.check = check;
	}
}
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; ++i) {
        	q.add(new Node(priorities[i],i==location));
        }
        while(!q.isEmpty()) {
        	Node node = q.poll();
        	if(findHigherPriority(q, node.num)) {
        		q.add(node);
        	}else {
        		answer++;
        		if(node.check) {
        			break;
        		}
        	}
        }
        return answer;
    }
    boolean findHigherPriority(Queue<Node> q, int number) {
    	for(Node n : q) {
    		if(n.num > number) {
    			return true;
    		}
    	}
    	return false;
    }
}

public class 프린터 {
	public static void main(String[] args) {
		int[] priorities = {2,1,3,2};
		int location = 2;
		Solution sol = new Solution();
		System.out.println(sol.solution(priorities, location));
	}
}
