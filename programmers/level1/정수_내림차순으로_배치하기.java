package programmers;
import java.util.*;
public class 정수_내림차순으로_배치하기 {
	static
	class Solution {
		  public long solution(long n) {
		      char[] arr = String.valueOf(n).toCharArray();
		      Arrays.sort(arr);
		      StringBuilder sb = new StringBuilder(String.valueOf(arr)).reverse();
		      return Long.parseLong(sb.toString());
		  }
		}	
	public static void main(String[] args) {
		int n = 118372;
		Solution sol = new Solution();
		System.out.println(sol.solution(n));
	}
}
