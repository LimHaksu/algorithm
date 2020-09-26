package programmers;

public class n124_나라의_숫자 {
	static class Solution {
		public String solution(int n) {
			int a;
			char[] arr = {'4', '1', '2'};
			StringBuilder answer = new StringBuilder();
			while (n > 0) {
				a = n % 3;
				n /= 3;
				if (a == 0) {
					n--;
				}
				answer.append(arr[a]);
			}
			return answer.reverse().toString();
		}
	}
//		  public String solution(int n) {
//		      StringBuilder sb = new StringBuilder();
//		      while(n>0) {
//		    	  sb.append(n%3);
//		    	  n/=3;
//		      }
//		      sb = sb.reverse();
//		      for(int i = sb.length()-1; i >= 0 ; --i) {
//		    	  if(sb.charAt(i)=='0' && i > 0) {
//		    		  int j = i-1;
//		    		  for(; j >= 0; --j) {
//		    			  if(sb.charAt(j) > '0') {
//		    				 sb.setCharAt(j, (char)(sb.charAt(j)-1));
//		    				 break;
//		    			  }
//		    		  }
//		    		  for(j=j+1; j < i; ++j) {
//		    			  sb.setCharAt(j, '2');
//		    		  }
//		    		  sb.setCharAt(i, '4');
//		    	  }else if(sb.charAt(i)=='3') {
//		    		  sb.setCharAt(i, '4');
//		    	  }
//		      }
//		      StringBuilder answer = new StringBuilder();
//		      for(char c : sb.toString().toCharArray()) {
//		    	  if(c!='0') {
//		    		  answer.append(c);
//		    	  }
//		      }
//		      return answer.toString();
//		  }
//		}
	public static void main(String[] args) {
		int n = 18;
		Solution sol = new Solution();
		System.out.println(sol.solution(n));
	}
}
