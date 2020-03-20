package programmers;

import java.util.*;
public class 소수_찾기 {
	static
	class Solution {
		int answer = 0;
		boolean[] prime = new boolean[10000000];
		boolean[] visited = new boolean[10000000];
		Set<Integer> set = new HashSet<Integer>();
	    public int solution(String numbers) {
	        for(int i = 2; i < prime.length; ++i) {
	        	if(!visited[i]) {
	        		visited[i] = true;
	        		prime[i] = true;
	        		for(int j = i; j < prime.length; j += i) {
	        			visited[j] = true;
	        		}
	        	}
	        }
	        for(int i = 1; i <= numbers.length(); ++i) {
	        	Stack<Character> s = new Stack<Character>();
	        	boolean[] check = new boolean[numbers.length()];
	        	dfs(numbers,s,check,i);
	        }
	        return set.size();
	    }
	    void dfs(String numbers, Stack<Character> s, boolean[] check, int count) {
	    	if(s.size() == count) {
	    		StringBuilder sb = new StringBuilder();
	    		for(char c : s) {
	    			sb.append(c);
	    		}
	    		int num = Integer.parseInt(sb.toString());
	    		if(prime[num]) {
	    			set.add(num);
	    		}
	    		return;
	    	}
	    	for(int i = 0; i < numbers.length(); ++i) {
	    		if(!check[i]) {
	    			check[i] = true;
	    			s.push(numbers.charAt(i));
	    			dfs(numbers,s,check,count);
	    			s.pop();
	    			check[i] = false;
	    		}
	    	}
	    }
	}
	public static void main(String[] args) {
		String numbers = "011";
		Solution sol = new Solution();
		System.out.println(sol.solution(numbers));
	}
}
