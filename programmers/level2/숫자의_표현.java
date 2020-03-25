import java.util.*;
public class 숫자의_표현 {
	static
	class Solution {
		  public int solution(int n) {
		      int answer = 0;
		      for(int i = 1; i <= n; ++i) {
		    	  int sum = 0;
		    	  for(int j = i; j <= n; ++j) {
		    		  sum += j;
		    		  if(sum == n) {
		    			  answer++;
		    		  }
		    		  if(sum >= n) {
		    			  break;
		    		  }
		    	  }
		      }
		      return answer;
		  }
		}
	public static void main(String[] args) {
		int n = 15;
		Solution sol = new Solution();
		System.out.println(sol.solution(n));
	}
}
