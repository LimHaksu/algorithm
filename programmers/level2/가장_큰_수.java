package programmers;
import java.util.*;
public class 가장_큰_수 {
	static
	class Solution {
	    class Node implements Comparable<Node>{
	    	String num;
	    	Node(String num){
	    		this.num = num;
	    	}
			@Override
			public int compareTo(Node o) {
				if(Integer.parseInt(this.num+o.num) > Integer.parseInt(o.num+this.num)) {
					return -1;
				}
				if(Integer.parseInt(this.num+o.num) < Integer.parseInt(o.num+this.num)) {
					return 1;
				}
				return 0;
			}
	    }
		public String solution(int[] numbers) {
	        StringBuilder answer = new StringBuilder();
	        Node[] arr = new Node[numbers.length];
	        for(int i = 0; i < numbers.length; ++i) {
	        	arr[i] = new Node(String.valueOf(numbers[i]));
	        }
	        Arrays.sort(arr);
	        for(Node n : arr) {
	        	answer.append(n.num);
	        }
	        if(answer.charAt(0)=='0'){
	            answer = new StringBuilder("0");
	        }
	        return answer.toString();
	    }
	}
	public static void main(String[] args) {
		int[] numbers = {0,0,0,0};
		Solution sol = new Solution();
		System.out.println(sol.solution(numbers));
	}
}
