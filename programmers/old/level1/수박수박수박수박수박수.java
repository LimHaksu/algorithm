package programmers;
public class 수박수박수박수박수박수 {
	static
	class Solution {
		  public String solution(int n) {
		      StringBuilder sb = new StringBuilder();
		      for(int i = 0; i < n; ++i) {
		    	  if(i%2==0) {
		    		  sb.append("수");
		    	  }else {
		    		  sb.append("박");
		    	  }
		      }
		      return sb.toString();
		  }
		}
	public static void main(String[] args) {
		int n = 3;
		Solution sol = new Solution();
		System.out.println(sol.solution(n));
	}
}
