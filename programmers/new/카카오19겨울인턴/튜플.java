package A2;
import java.io.*;
import java.util.*;
class Node implements Comparable<Node>{
	Set<Integer> set = new HashSet<Integer>();
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.set.size(), o.set.size());
	}
}
class Solution {
    public int[] solution(String s) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        Node node = null;
        StringBuilder number = new StringBuilder();
        for(int i = 1; i < s.length()-1; ++i) {
        	switch(s.charAt(i)) {
        	case '{':
        		node = new Node();
        		break;
        	case '}':
        		node.set.add(Integer.parseInt(number.toString()));
        		pq.add(node);
        		node = null;
        		number = new StringBuilder();
        		break;
        	case ',':
        		if(node != null) {
        			node.set.add(Integer.parseInt(number.toString()));
        			number = new StringBuilder();
        		}
        		break;
    		default:
    			number.append(s.charAt(i));
    			break;
        	}
        }
        Set<Integer> checked = new HashSet<Integer>();
        int[] answer = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()) {
        	Node n = pq.poll();
        	for(int num : n.set) {
        		if(!checked.contains(num)) {
        			answer[idx++] = num;
        			checked.add(num);
        		}
        	}
        }
        return answer;
    }
}
public class 튜플 {
	public static void main(String[] args) {
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(s)));
	}
}
