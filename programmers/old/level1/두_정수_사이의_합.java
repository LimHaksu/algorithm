package programmers;

public class 두_정수_사이의_합 {
	static class Solution {
		  public long solution(int a, int b) {
			  if(a>b) {
				  int temp = a;
				  a = b;
				  b = temp;
			  }
		      long answer = 0;
		      for(int i = a; i <= b; ++i) {
		    	  answer += i;
		      }
		      return answer;
		  }
		}
	public static void main(String[] args) {
		int a = 3;
		int b = 5;
		Solution sol = new Solution();
		System.out.println(sol.solution(a, b));
	}
}
