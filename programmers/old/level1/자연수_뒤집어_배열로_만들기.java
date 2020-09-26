package programmers;

import java.util.Arrays;

public class 자연수_뒤집어_배열로_만들기 {
	static
	class Solution {
		  public int[] solution(long n) {
		      char[] arr = new StringBuilder(String.valueOf(n)).reverse().toString().toCharArray();
		      int[] answer = new int[arr.length];
		      for(int i = 0; i < arr.length; ++i) {
		    	  answer[i] = arr[i]-'0';
		      }
		      return answer;
		  }
		}
	public static void main(String[] args) {
		int n = 12345;
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(n)));
	}
}
