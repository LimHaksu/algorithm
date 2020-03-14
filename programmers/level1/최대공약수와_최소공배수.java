package programmers;

import java.util.Arrays;

public class 최대공약수와_최소공배수 {
	static
	class Solution {
		  public int[] solution(int n, int m) {
		      int gcd = getGcd(n,m);
		      int lcm = n/gcd*m;
		      return new int[] {gcd,lcm};
		  }
		  int getGcd(int n, int m) {
			  if(n < m) {
				  int temp = n;
				  n = m;
				  m = temp;
			  }
			  while(m != 0) {
				  int temp = n % m;
				  n = m;
				  m = temp;
			  }
			  return n;
		  }
		}
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 3;
		int m = 12;
		System.out.println(Arrays.toString(sol.solution(n, m)));
	}
}
