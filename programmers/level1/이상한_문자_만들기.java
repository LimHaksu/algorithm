package programmers;

public class 이상한_문자_만들기 {
	static
	class Solution {
		  public String solution(String s) {
		      int idx = 0;
		      StringBuilder sb = new StringBuilder(s);
		      for(int i = 0; i < s.length(); ++i) {
		    	  if(sb.charAt(i)==' ') {
		    		  idx = 0;
		    	  }else {
		    		  if(idx%2==0) {
		    			  sb.setCharAt(i, (char) (sb.charAt(i)&0xDF));
		    		  }else {
		    			  sb.setCharAt(i, (char) (sb.charAt(i)|0x20));
		    		  }
		    		  idx++;
		    	  }
		      }
		      return sb.toString();
		  }
		}
	public static void main(String[] args) {
		String s = "try hello world";
		Solution sol = new Solution();
		System.out.println(sol.solution(s));
	}
}
