package programmers;

public class 소수_찾기 {
	static class Solution {
	  public int solution(int n) {
		  boolean[] arr = new boolean[n+1];
		  int count = 0;
		  for(int i = 2; i <= n; ++i) {
			  if(!arr[i]) {
				  count++;
				  for(int j = i; j <= n; j += i) {
					  arr[j] = true;
				  }
			  }
		  }
		  return count;
	  }
	}
		
	public static void main(String[] args) {
		int n = 10;
		Solution sol = new Solution();
		System.out.println(sol.solution(n));
	}
}
