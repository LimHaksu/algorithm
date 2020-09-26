package programmers;

public class 시저_암호 {
	static
	class Solution {
		  public String solution(String s, int n) {
		      String answer = "";
		      for(int i = 0; i < s.length(); ++i) {
		    	  char temp = s.charAt(i);
		    	  if(temp >= 'A' && temp <= 'Z') {
		    		  temp += n;
		    		  if(temp > 'Z') {
		    			  temp -= 'Z'-'A'+1;
		    		  }
		    	  }else if(temp >= 'a' && temp <='z') {
		    		  temp += n;
		    		  if(temp >'z') {
		    			  temp -= 'z'-'a'+1;
		    		  }
		    	  }
		    	  answer += temp;
		      }
		      return answer;
		  }
		}
	public static void main(String[] args) {
		String s = "a B z";
		int n  = 4;
		Solution sol = new Solution();
		System.out.println(sol.solution(s, n));
	}
}
