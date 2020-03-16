package programmers;

import java.util.*;

public class 실패율 {
	static
	class Solution {
	    class Node implements Comparable<Node>{
	    	double fr;
	    	int idx;
	    	Node(int idx, double fr){
	    		this.idx = idx;
	    		this.fr = fr;
	    	}
			@Override
			public int compareTo(Node o) {
				if(this.fr < o.fr) {
					return 1;
				}else if(this.fr > o.fr) {
					return -1;
				}else {
					return Integer.compare(this.idx, o.idx);
				}
			}
	    	
	    }
		public int[] solution(int N, int[] stages) {
	        int[] answer = new int[N];
	        int[] challenging = new int[N+2];
	        int[] arrive = new int[N+2];
	        for(int i = 0; i < stages.length; ++i) {
	        	for(int j = 1; j <= stages[i]; ++j) {
	        		arrive[j]++;
	        	}
	        	challenging[stages[i]]++;
	        }
	        Node[] failureRatio = new Node[N];
	        for(int i = 0; i < failureRatio.length; ++i) {
	        	failureRatio[i] = new Node(i+1, arrive[i+1]==0 ? 0 : (double)challenging[i+1] / arrive[i+1]);
	        }
	        Arrays.sort(failureRatio);
	        for(int i = 0; i < N; ++i) {
	        	answer[i] = failureRatio[i].idx;
	        }
	        return answer;
	    }
	}
	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2,1,2,6,2,4,3,3};
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(N, stages)));
	}
}
