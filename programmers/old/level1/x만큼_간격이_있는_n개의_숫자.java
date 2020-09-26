package programmers;

import java.util.Arrays;

public class x만큼_간격이_있는_n개의_숫자 {
	static
	class Solution {
		  public long[] solution(int x, int n) {
		      long[] answer = new long[n];
		      long temp = x;
		      for(int i = 0; i < n; ++i) {
		    	  answer[i] = temp;
		    	  temp += x;
		      }
		      return answer;
		  }
		}
	public static void main(String[] args) {
		int x = 2, n = 5;
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(x, n)));
	}
}
