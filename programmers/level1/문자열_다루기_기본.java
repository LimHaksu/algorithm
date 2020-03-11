package programmers;

public class 문자열_다루기_기본 {
	static
	class Solution {
		  public boolean solution(String s) {
		      if(s.length()==4 || s.length() == 6) {
		    	  for(char c : s.toCharArray()) {
		    		  if(c > '9' || c < '0') {
		    			  return false;
		    		  }
		    	  }
		    	  return true;
		      }
		      return false;
		  }
		}
	public static void main(String[] args) {
		String s = "1234";
		Solution sol = new Solution();
		System.out.println(sol.solution(s));
	}
}
