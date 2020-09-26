package programmers_unsolved;

public class N개의_최소공배수 {
	static
	class Solution {
		  public int solution(int[] arr) {
		      int answer = 1;
		      for(int i = 0; i < arr.length; ++i) {
		    	 answer = lcm(answer, arr[i]);
		      }
		      return answer;
		  }
		}
	static int gcd(int a, int b) {
		if(a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		while(b > 0) {
			int temp = a%b;
			a = b;
			b = temp;
		}
		return a;
	}
	static int lcm(int a, int b) {
		return a/gcd(a,b)*b;
	}
	public static void main(String[] args) {
		int[] arr = {2,6,8,14};
		Solution sol = new Solution();
		System.out.println(sol.solution(arr));
	}
}
